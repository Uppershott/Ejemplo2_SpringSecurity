package com.nttdata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.repositories.UsuarioRepository;

@RestController
public class ApiController {
	
	@Autowired
	UsuarioRepository ur;
	
	@GetMapping("api/usuarios")
	public String finalUser() {
		return ur.findAll().toString();
	}
}
