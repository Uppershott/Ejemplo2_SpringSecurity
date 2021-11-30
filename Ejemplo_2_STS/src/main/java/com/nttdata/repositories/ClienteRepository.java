package com.nttdata.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nttdata.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
	//List<Cliente> findAll();
	
	//Cliente es el objeto, en singular, no la tabla
	@Query("SELECT c FROM Cliente c")
	List<Cliente> findAllClientes();
}
