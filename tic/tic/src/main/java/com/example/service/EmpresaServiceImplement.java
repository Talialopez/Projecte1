package com.example.service;

import com.example.entidades.Empresa;
import com.example.repository.EmpresaRepository;
import com.example.repository.OfertaRepository;

import java.util.List;
import java.util.Optional;


public class EmpresaServiceImplement implements EmpresaService {
	
	private EmpresaRepository empresaRepository;
	
	private OfertaRepository ofertaRepository;
	
	
	public EmpresaServiceImplement(EmpresaRepository empresaRepository) {
		this.empresaRepository = empresaRepository;
	}
	
	public EmpresaServiceImplement(OfertaRepository ofertaRepository) {
		this.ofertaRepository = ofertaRepository;
	}

	@Override
	public List<Empresa> getAllEmpresas(){
		return empresaRepository.findAll();
	}

	@Override
	public Empresa getEmpresaById(Long id) {
		Optional<Empresa> optionalEmpresa = empresaRepository.findById(id);
		return optionalEmpresa.get();
	}
	@Override
	public Empresa createEmpresa(Empresa empresa) {
		return empresaRepository.save(empresa);
	}
	
	/*@Override
	public Empresa getEmpresaByNom(String nom) throws Exception {
		Empresa empresa = empresaRepository.findByNom(nom);

        if (empresa == null) {
            throw new Exception("No se encontró ninguna empresa con el nombre: " + nom);
        }
        return empresa;
    }
	*/
	@Override
	public void deleteEmpresa(Long id) {
		empresaRepository.deleteById(id);
	}
	
	@Override
	public Empresa updateEmpresa(Long id, Empresa empresaActualizada) {
	    Optional<Empresa> empresaEncontrada = empresaRepository.findById(id);

	    if (empresaEncontrada.isPresent()) {
	        Empresa empresa = empresaEncontrada.get();
	        empresa.setNom(empresaActualizada.getNom());
	        empresa.setUbicacio(empresaActualizada.getUbicacio());

	        return empresaRepository.save(empresa);
	    }

	    return null;
	}
	
	
	
}
