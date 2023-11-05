package com.example.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.entidades.Empresa;
import com.example.repository.EmpresaRepository;

@Component
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	
	public Empresa createEmpresa(Empresa empresa) {
		return empresaRepository.save(empresa);
	}
	
	public Empresa getEmpresaById(Long id) {
		Optional<Empresa> optionalEmpresa = empresaRepository.findById(id);
		return optionalEmpresa.get();
	}
	
	public Empresa getEmpresaByNom(String nom) throws Exception {
		Empresa empresa = empresaRepository.findByNom(nom);

        if (empresa == null) {
            throw new Exception("No se encontró ninguna empresa con el nombre: " + nom);
        }
        return empresa;
    }
	
	public List<Empresa> getAllEmpresas(){
		return empresaRepository.findAll();
	}
	
	public void deleteEmpresa(Long id) {
		empresaRepository.deleteById(id);
	}

	public Empresa updateEmpresa(Long id, Empresa empresaActualizada) {
	    Optional<Empresa> empresaEncontrada = empresaRepository.findById(id);

	    if (empresaEncontrada.isPresent()) {
	        Empresa empresa = empresaEncontrada.get();
	        empresa.setNom(empresaActualizada.getNom());
	        empresa.setDescripcio(empresaActualizada.getDescripcio());
	        empresa.setUbicacio(empresaActualizada.getUbicacio());

	        return empresaRepository.save(empresa);
	    }

	    return null;
	}

}
