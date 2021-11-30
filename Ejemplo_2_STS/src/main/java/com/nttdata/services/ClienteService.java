package com.nttdata.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Cliente;
import com.nttdata.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;

	public void insertarCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	public List<Cliente> obtenerListaClientes() {
		return clienteRepository.findAll();
	}

	public Cliente buscarCliente(Long id) {
		return clienteRepository.findById(id).get();
	}
	
	
}
