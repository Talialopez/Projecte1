package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entidades.Empresa;
import com.example.service.EmpresaService;

@RestController
@RequestMapping("api/empresas")
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;
	
	@PostMapping // Vamos a guardar un objeto
	public Empresa createEmpresa(@RequestBody Empresa empresa) {
		return empresaService.createEmpresa(empresa);	
	}
	
	@GetMapping
	public List<Empresa> getAllEmpresas() {
		return empresaService.getAllEmpresas();
	}
	
	@GetMapping("{id}")
	public Empresa searchEmpresaById(@PathVariable("id") Long id) {
		return empresaService.getEmpresaById(id);
	}
	
	@GetMapping("{nom}")
	public Empresa searchEmpresaByNom(@PathVariable("nom") String nom) throws Exception {
	    try {
	        return empresaService.getEmpresaByNom(nom);
	    } catch (Exception e) {
	        throw new Exception("No se encontró ninguna empresa con el nombre: " + nom);
	    }
	}

	@PutMapping("{id}")
	public Empresa updateEmpresa(@PathVariable("id") Long id, @RequestBody Empresa empresa) {
	    return empresaService.updateEmpresa(id, empresa);
	}
	
	@DeleteMapping("{id}")
	public void deleteEmpresaById(@PathVariable("id") Long id) {
		empresaService.deleteEmpresa(id);
	}
}