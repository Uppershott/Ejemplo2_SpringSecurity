package com.nttdata.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.models.Usuario;
import com.nttdata.services.UsuarioService;

@Controller
public class HomeController {

	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping("/") //método inicial
	public String inicio() {
		//usuarioService.persistirUsuarioRol(new Usuario());
		return "inicio.jsp";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login.jsp";
	}
	
	@RequestMapping("/registro")
	public String registro(@ModelAttribute("usuario") Usuario usuario) {
		
		return "registro.jsp";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "el index!";
	}
	
	@RequestMapping("/inicio/menu")
	public String menu() {
		return "el menu!";
	}
	
	@RequestMapping("/home")
	public String home(HttpSession session, Model model) {
		
		Usuario usuario = (Usuario)session.getAttribute("usuario");
		String usuarioString = usuario.getNombre();
		
		model.addAttribute("usuarioString", usuarioString);
		return "home.jsp";
	}
}
