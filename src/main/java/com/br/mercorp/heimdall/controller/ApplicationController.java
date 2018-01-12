package com.br.mercorp.heimdall.controller;

import org.slf4j.Logger ;
import org.slf4j.LoggerFactory ;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.mercorp.heimdall.service.impl.ApplicationServiceImpl;

@RestController
@RequestMapping("/heimdall")
public class ApplicationController {

	private static final Logger log = LoggerFactory.getLogger(ApplicationServiceImpl.class);
	
	@RequestMapping("/")
	public String index() {
		log.info("Tela de login");
		return "login";
	}

	/*
	 * @PostMapping public ResponseEntity<Response<ApplicationDTO>>
	 * cadastrar(@Valid @RequestBody ApplicationDTO applicationDTO, BindingResult
	 * result) { Response<ApplicationDTO> response = new Response<ApplicationDTO>();
	 * if (result.hasErrors()) { result.getAllErrors().forEach(error ->
	 * response.getErrors().add(error.getDefaultMessage())); return
	 * ResponseEntity.badRequest().body(response); }
	 * response.setData(applicationDTO); return ResponseEntity.ok(response); }
	 */
	
	
	
	

}
