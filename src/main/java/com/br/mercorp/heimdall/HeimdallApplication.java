package com.br.mercorp.heimdall;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.br.mercorp.entity.Application;
import com.br.mercorp.entity.Authorization;
import com.br.mercorp.entity.Resource;
import com.br.mercorp.entity.Role;
import com.br.mercorp.entity.User;
import com.br.mercorp.enums.Restriction;
import com.br.mercorp.heimdall.service.ApplicationService;
import com.br.mercorp.heimdall.service.AuthorizationService;
import com.br.mercorp.heimdall.service.ResourceService;
import com.br.mercorp.heimdall.service.RoleService;
import com.br.mercorp.heimdall.service.UserService;
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
	
	@Autowired
	private ResourceService resourceService;
	
	/*@Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }*/
	   
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
	 * Configuração de verificação de base de dados
	 */
	private void checkDatabase() {
		log.info("Verificação de usuario na base de dados");
		//verifica o número de registros de usuários 
		int row = (int) userService.count();
		/** não existe registros de usuários, exigências: 
		    - applicação registrada(esta aplicação); 
		    - papel de administrador para a aplicação;
		    - usuário cadastrado
		 */
		
		if(row == 0) {
			log.info("Sem registro de usuário");
			//cria aplicação
			Application application = new Application();
			application.setName(("Controle de acesso de sistema").toUpperCase());
			application.setAcronym(("Heimdall").toUpperCase());
			
			//grava aplicação e recebe objeto persistido na base de dados(com id, versão, data de criação)
			Application savedApplication = applicationService.save(application).get();
			
			//cria papel de administrador
			Role administatorRole = new Role();
			administatorRole.setName(("Administrador").toUpperCase());
			administatorRole.setDescription(("Controle total").toUpperCase());
			administatorRole.setApplication(savedApplication);
			
			//cria papel de usuário
			Role userRole = new Role();
			userRole.setName(("Usuario").toUpperCase());
			userRole.setDescription(("Visualização de registro").toUpperCase());
			userRole.setApplication(savedApplication);
			
			//grava papeis e recebe objeto persistido na base de dados(com id, versão, data de criação)
			Role savedAdministratorRole = roleService.save(administatorRole).get();
			Role savedUserRole = roleService.save(userRole).get();
			
			//cria recurso para usuário
			Resource resource = new Resource();
			resource.setName(("SELECT").toUpperCase());
			resource.setDescription(("Operação de seleção").toUpperCase());
			resource.setRestriction(Restriction.ALLOWED);
			resource.setRole(savedUserRole);
			
			Resource savedResource = resourceService.save(resource).get();
								
			//cria usuário
			User user = new User();
			user.setName(("Mércio Carvalho").toUpperCase());
			user.setLogin("merciopio");
			user.setEmail("merciopio@gmail.com");
			user.setPassword(SenhaUtil.criptografa("123456789"));						
			
			//grava usuário e recebe objeto persistido na base de dados(com id, versão, data de criação)
			User savedUser = userService.save(user).get();
			
			//cria autorização de acesso para o usuário com o sistema e seu papel
			Authorization authorization = new Authorization();
			authorization.setRole(savedAdministratorRole);
			authorization.setUser(savedUser);
			
			//grava autorização e recebe objeto persistido na base de dados(com id, versão, data de criação)
			log.info("Gravando usuário padrão");
			Authorization savedAuthorization = authorizationService.save(authorization).get();
			
		}
	
	}
}
