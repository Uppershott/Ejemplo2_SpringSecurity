package com.nttdata.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Proyecto;
import com.nttdata.repositories.ProyectoRespository;

@Service
public class ProyectoService {
	
	@Autowired
	ProyectoRespository proyectoRepository;

	public void insertarProyecto(Proyecto proyecto) {
		proyectoRepository.save(proyecto);
	}
	
	public List<Proyecto> obtenerListaProyectos(){
		return proyectoRepository.findAll();
	}

	public List<Proyecto> obtenerProyectosJoinUsuarios() {
		return proyectoRepository.obtenerProyectoJoinUsuario();
	}
}
