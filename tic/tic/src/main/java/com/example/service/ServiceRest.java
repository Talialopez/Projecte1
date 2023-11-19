package com.example.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.entidades.Empresa;
import com.example.entidades.Oferta;
import com.example.repository.EmpresaRepository;
import com.example.repository.OfertaRepository;

@Component
public class ServiceRest {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
    @Autowired
    private OfertaRepository ofertaRepository;
	
	
	public Empresa createEmpresa(Empresa empresa) {
		return empresaRepository.save(empresa);
	}
	
	public Empresa getEmpresaById(Long id) {
		Optional<Empresa> optionalEmpresa = empresaRepository.findById(id);
		return optionalEmpresa.get();
	}
	
	
	/**public Empresa getEmpresaByNom(String nom) throws Exception {
		Empresa empresa = empresaRepository.findByNom(nom);

        if (empresa == null) {
            throw new Exception("No se encontró ninguna empresa con el nombre: " + nom);
        }
        return empresa;
    }*/
	
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
	        empresa.setUbicacio(empresaActualizada.getUbicacio());

	        return empresaRepository.save(empresa);
	    }

	    return null;
	}


	public Oferta createOferta(Long empresaId, Oferta oferta) {
	    Optional<Empresa> optionalEmpresa = empresaRepository.findById(empresaId);

	    if (optionalEmpresa.isPresent()) {
	        Empresa empresa = optionalEmpresa.get();
	        oferta.setEmpresa(empresa); //
	        return ofertaRepository.save(oferta); 
	    }

	    return null;
	}


    public List<Oferta> getAllOfertas() {
        return ofertaRepository.findAll();
    }

    public Optional<Oferta> getOfertasByEmpresa(Long empresaId) {
        return ofertaRepository.findById(empresaId);
    }

    public Oferta updateOferta(Long empresaId, Long ofertaId, Oferta ofertaActualizada) {
        Optional<Oferta> optionalOferta = ofertaRepository.findById(ofertaId);

        if (optionalOferta.isPresent()) {
            Oferta oferta = optionalOferta.get();
            if (oferta.getEmpresa().getId().equals(empresaId)) {
                oferta.setNom(ofertaActualizada.getNom());
                oferta.setRequisitos(ofertaActualizada.getRequisitos());
                oferta.setConocimientosNecesarios(ofertaActualizada.getConocimientosNecesarios());
                oferta.setEstudiosNecesarios(ofertaActualizada.getEstudiosNecesarios());
                oferta.setDescripcion(ofertaActualizada.getDescripcion());

                return ofertaRepository.save(oferta);
            }
        }
        return null;
    }

    public void deleteOferta(Long empresaId, Long ofertaId) {
        ofertaRepository.findById(ofertaId).ifPresent(oferta -> {
            if (oferta.getEmpresa().getId().equals(empresaId)) {
                ofertaRepository.deleteById(ofertaId);
            }
        });
    }
}