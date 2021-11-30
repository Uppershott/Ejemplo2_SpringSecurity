package com.nttdata.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.models.Celular;
import com.nttdata.services.CelularService;
import com.nttdata.services.UsuarioService;

@Controller
@RequestMapping("/celular")
public class CelularController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	CelularService celularService;
	
	@RequestMapping("")
	public String inicioCelular(Model model){
		model.addAttribute("celular", new Celular());
		model.addAttribute("listaUsuarios", usuarioService.obtenerListaUsuarios());
		
		model.addAttribute("listaCelulares", celularService.obtenerListaCelulares());
		return "celular.jsp";
	}
	
	@RequestMapping("/crear")
	public String crearCelular(@ModelAttribute("celular") Celular celular, Model model) {
		System.out.println("Numero celular: "+celular.getNumero());
		System.out.println("Nombre usuario: "+celular.getUsuario().getNombre());
		String error="";
		List<Celular> celulares = celularService.obtenerListaCelulares();
		
		for(int i=0; i<celulares.size();i++) {
			if(celulares.get(i).getUsuario().getId() == celular.getUsuario().getId()) {
				error="Error: El usuario ingresado ya posee un celular";
				break;
			}
		}
		if(error.isEmpty()) {
			celularService.insertarCelular(celular);
			return "redirect:/celular";
		}else {
			model.addAttribute("error", error);
			return "error.jsp";
		}
	}
}
