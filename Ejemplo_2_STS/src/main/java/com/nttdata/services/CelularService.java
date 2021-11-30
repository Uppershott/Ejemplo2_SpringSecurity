package com.nttdata.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Celular;
import com.nttdata.repositories.CelularRepository;

@Service
public class CelularService {
	
	@Autowired
	CelularRepository celularRepository;

	public void insertarCelular(Celular celular) {
		celularRepository.save(celular);
	}

	public List<Celular> obtenerListaCelulares() {
		return celularRepository.findAll();
	}
}
