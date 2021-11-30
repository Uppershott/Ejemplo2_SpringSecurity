package com.nttdata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.models.Proveedor;
import com.nttdata.services.ProveedorService;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {
	
	@Autowired
	ProveedorService proveedorService;
	
	@RequestMapping("")
	public String index() {
		
		return "proveedor.jsp";
	}
	
	@RequestMapping("/insertar")
	public String insertar(@ModelAttribute("proveedor") Proveedor proveedor) {
		proveedorService.insertarProveedor(proveedor);
		return "redirect:/proveedor";
	}
}
