package com.nttdata.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Proveedor;
import com.nttdata.repositories.ProveedorRepository;

@Service
public class ProveedorService {
	
	@Autowired
	ProveedorRepository proveedorRepository;

	public Object obtenerListaProveedores() {
		return proveedorRepository.findAll();
	}

	public void insertarProveedor(Proveedor proveedor) {
		proveedorRepository.save(proveedor);
	}
	
	
}
