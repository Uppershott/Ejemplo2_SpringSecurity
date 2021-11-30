package com.nttdata.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.models.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor,Long>{
	//List<Proveedor> findAll();
}
