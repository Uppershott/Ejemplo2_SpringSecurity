package com.nttdata.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nttdata.models.Usuario;
import com.nttdata.services.ProyectoService;
import com.nttdata.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	ProyectoService proyectoService;
	
	@RequestMapping("")
	public String usuario(@ModelAttribute ("usuario") Usuario usuario,
			Model model) {
		usuarioService.obtenerNombresApellidosUsuarios();
		usuarioService.obtenerNombresApellidosUsuarios();
		model.addAttribute("listaUsuarios", usuarioService.obtenerListaUsuarios());
		model.addAttribute("listaProyectos", proyectoService.obtenerListaProyectos());
		return "usuario.jsp";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login.jsp";
	}
	
	/*
	 * @RequestMapping("/loginJsp") public String
	 * loginUsuario(@RequestParam("email") String email, @RequestParam("password")
	 * String password, HttpSession session) {
	 * if(usuarioService.loginUsuario(email,password)) {
	 * System.out.println("Son válidos");
	 * 
	 * Usuario usuario = usuarioService.findByEmail(email);
	 * session.setAttribute("usuario", usuario);
	 * 
	 * return "redirect:/home"; }else { System.err.println("No es válido"); return
	 * "login.jsp"; } }
	 */
	
	@RequestMapping()
	public String loginUsuario(Principal principal, Model model, HttpSession session) {
		String nombre = principal.getName();
		
		usuarioService.findByNombre(nombre);
		
		return "home.jsp";
				
	}
	
	@RequestMapping("/crear")
	public String crearUsuario(@Valid @ModelAttribute("usuario") Usuario usuario, Model model) {
		//usuarioService.registroUsuario(usuario);
		usuarioService.persistirUsuarioRol(usuario);
		return "login.jsp";
	}
	
	@RequestMapping("/editar")
	public String editar(@RequestParam("id") Long id, Model model) {
		Usuario usuario = usuarioService.encontrarUsuario(id);
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("listaProyectos", proyectoService.obtenerListaProyectos());
		
		return "usuarioEdit.jsp";
	}
	
	@RequestMapping(value="/editarUsuario", method=RequestMethod.PUT)
	public String editarUsuario(@Valid @ModelAttribute("usuario") Usuario usuario) {
		System.out.println("User id: "+usuario.getId());
		usuarioService.registroUsuario(usuario);
		return "redirect:/usuario";
	}
	
	
	@RequestMapping("/eliminar")
	public String eliminarUsuario(@RequestParam("id") Long id, Model model) {
		Usuario usuario = usuarioService.encontrarUsuario(id);
		if(usuario!=null) {
			usuarioService.eliminarUsuario(usuario);
			return "redirect:/usuario";
		}else {
			String error ="";
			model.addAttribute("error", error);
			return "error.jsp";
		}
	}
	
	/*
	@RequestMapping("/login")
	public String login(@RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido,
			@RequestParam("limite") String limite,
			@RequestParam("codigoPostal") String codigoPostal) {
		System.out.println("Nombre: "+nombre);
		System.out.println("Apellido: "+apellido);
		System.out.println("Limite: "+limite);
		System.out.println("Código postal: "+codigoPostal);
		return "redirect:/usuario";
	}
	*/
	
	
}
