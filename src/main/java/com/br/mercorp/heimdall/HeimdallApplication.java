package com.br.mercorp.heimdall;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.br.mercorp.entity.Application;
import com.br.mercorp.entity.Authorization;
import com.br.mercorp.entity.Resource;
import com.br.mercorp.entity.Role;
import com.br.mercorp.entity.User;
import com.br.mercorp.enums.Restriction;
import com.br.mercorp.heimdall.service.ApplicationService;
import com.br.mercorp.heimdall.service.AuthorizationService;
import com.br.mercorp.heimdall.service.RoleService;
import com.br.mercorp.heimdall.service.UserService;
import com.br.mercorp.heimdall.service.impl.ApplicationServiceImpl;
import com.br.mercorp.security.util.SenhaUtil;

@SpringBootApplication
@EnableJpaRepositories("com.br.mercorp.*")
@ComponentScan(basePackages = { "com.br.mercorp.*" })
@EntityScan("com.br.mercorp.*") 
public class HeimdallApplication implements CommandLineRunner {

   private static final Logger log = LoggerFactory.getLogger(HeimdallApplication.class);
	
	@Autowired
	private ApplicationService applicationService;
	
	@Autowired
	private AuthorizationService authorizationService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	public static void main(String[] args) {
		SpringApplication.run(HeimdallApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		init();
	}
	
	/**
	 * Configuração inicial para a aplicação
	 */
	private void init(){
		checkDatabase();
	}
	
	/**
	 * Configuração verificação de base de dados
	 */
	private void checkDatabase() {
		//verifica o número de registros de usuários 
		int row = (int) userService.count();
		/** não existe registros de usuários, exigências: 
		    - applicação registrada(esta aplicação); 
		    - papel de administrador para a aplicação;
		    - usuário cadastrado
		 */
		log.info("Sem registro de usuário");
		if(row == 0) {		
			//cria papel de administrador
			Role administatorRole = new Role();
			administatorRole.setName(("Administrador").toUpperCase());
			administatorRole.setDescription(("Controle total").toUpperCase());
			
			//cria recurso para usuário
			Resource resource = new Resource();
			resource.setName(("SELECT").toUpperCase());
			resource.setDescription(("Operação de seleção").toUpperCase());
			resource.setRestriction(Restriction.ALLOWED);
			
			//cria papel de usuário
			Role userRole = new Role();
			userRole.setName(("Usuário").toUpperCase());
			userRole.setDescription(("Visualização de registro").toUpperCase());
			userRole.getResources().add(resource);
			
			//cria aplicação
			Application application = new Application();
			application.setName(("Controle de acesso de sistema").toUpperCase());
			application.setAcronym(("Heimdall").toUpperCase());
			application.getRoles().add(administatorRole);
			application.getRoles().add(userRole);
			
			//cria usuário
			User user = new User();
			user.setName(("Mércio Carvalho").toUpperCase());
			user.setLogin("merciopio");
			user.setEmail("merciopio@gmail.com");
			user.setPassword(SenhaUtil.criptografa("123456789"));
			
			//grava papeis e recebe objeto persistido na base de dados(com id, versão, data de criação)
			Role savedAdministratorRole = roleService.save(administatorRole).get();
			Role savedUserRole = roleService.save(userRole).get();
			
			//grava aplicação e recebe objeto persistido na base de dados(com id, versão, data de criação)
			Application savedApplication = applicationService.save(application).get();
			
			//grava usuário e recebe objeto persistido na base de dados(com id, versão, data de criação)
			User savedUser = userService.save(user).get();
			
			//cria autorização de acesso para o usuário com o sistema e seu papel
			Authorization authorization = new Authorization();
			authorization.setApplication(savedApplication);
			authorization.setRole(savedAdministratorRole);
			authorization.setUser(savedUser);
			
			//grava autorização e recebe objeto persistido na base de dados(com id, versão, data de criação)
			log.info("Gravando usuário padrão");
			Authorization savedAuthorization = authorizationService.save(authorization).get();
			
		}
	
	}
}
