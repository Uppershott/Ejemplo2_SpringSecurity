package com.nttdata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.models.Proyecto;
import com.nttdata.services.ProyectoService;

@Controller
@RequestMapping("/proyecto")
public class ProyectoController {
	
	@Autowired
	ProyectoService proyectoService;
	
	@RequestMapping("")
	public String inicioProyecto(@ModelAttribute("proyecto") Proyecto proyecto){
		proyectoService.obtenerProyectosJoinUsuarios();
		return "proyecto.jsp";
	}
	
	@RequestMapping("/crear")
	public String crearProyecto(@ModelAttribute("proyecto") Proyecto proyecto) {
		proyectoService.insertarProyecto(proyecto);
		return "redirect:/proyecto";
	}
}
