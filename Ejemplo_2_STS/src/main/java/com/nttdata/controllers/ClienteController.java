package com.nttdata.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nttdata.models.Cliente;
import com.nttdata.services.ClienteService;
import com.nttdata.services.ProveedorService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	ProveedorService proveedorService;
	
	@RequestMapping("")
	public String clientes(@ModelAttribute("cliente") Cliente cliente, Model model) {
		
		model.addAttribute("listaProveedores", proveedorService.obtenerListaProveedores());
		model.addAttribute("listaClientes", clienteService.obtenerListaClientes());
		return "cliente.jsp";
	}
	
	@RequestMapping("/pagos")
	public String clientesPagos() {
		return "clientes pagos";
	}
	
	@RequestMapping("/m/{rut}/{dv}")
	public String rutCliente(
			@PathVariable("rut") Integer rut, 
			@PathVariable("dv") String dv) {
		
		return "El rut es: "+rut+" dígito verificador: "+dv;
	}
	
	@RequestMapping("/crear")
	public String crearCliente(@ModelAttribute("cliente") Cliente cliente) {
		clienteService.insertarCliente(cliente);
		return "redirect:/cliente";
	}
	
	@RequestMapping("/editar")
	public String editar(@RequestParam("id") Long id, Model model) {
		Cliente cliente = clienteService.buscarCliente(id);
		
		model.addAttribute("cliente", cliente);
		model.addAttribute("listaProveedores", proveedorService.obtenerListaProveedores());
		return "clienteEdit.jsp";
	}
	
	@RequestMapping(value="/editarCliente", method=RequestMethod.PUT)
	public String editarCliente(@Valid @ModelAttribute("cliente") Cliente cliente) {
		clienteService.insertarCliente(cliente);
		return "redirect:/cliente";
	}
}
