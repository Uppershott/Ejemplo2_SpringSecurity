package com.nttdata.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.models.Proyecto;

@Repository
public interface ProyectoRespository extends CrudRepository<Proyecto,Long> {
	List<Proyecto> findAll();
	
	@Query("SELECT p FROM Proyecto p JOIN p.usuarios u")
	List<Proyecto> obtenerProyectoJoinUsuario();
	
}
