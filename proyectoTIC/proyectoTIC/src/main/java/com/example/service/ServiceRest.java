package com.example.service;

import java.util.List;
import java.util.NoSuchElementException;
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
        try {
            return empresaRepository.save(empresa);
        } catch (Exception e) {
            throw new RuntimeException("Error al crear la empresa: " + e.getMessage(), e);
        }
    }

    public Empresa getEmpresaById(Long id) {
        try {
            Optional<Empresa> optionalEmpresa = empresaRepository.findById(id);
            return optionalEmpresa.orElseThrow(() ->
                    new NoSuchElementException("No se encontró ninguna empresa con el ID: " + id));
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener la empresa por ID: " + e.getMessage(), e);
        }
    }

    public Empresa getEmpresaByNom(String nom) throws Exception {
        try {
            Empresa empresa = empresaRepository.findByNom(nom);

            if (empresa == null) {
                throw new NoSuchElementException("No se encontró ninguna empresa con el nombre: " + nom);
            }

            return empresa;
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener la empresa por nombre: " + e.getMessage(), e);
        }
    }

    public List<Empresa> getAllEmpresas() {
        try {
            return empresaRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener todas las empresas: " + e.getMessage(), e);
        }
    }

    public void deleteEmpresa(Long id) {
        try {
            empresaRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar la empresa con ID: " + id + ": " + e.getMessage(), e);
        }
    }

    public Empresa updateEmpresa(Long id, Empresa empresaActualizada) {
        try {
            Optional<Empresa> optionalEmpresa = empresaRepository.findById(id);

            if (optionalEmpresa.isPresent()) {
                Empresa empresa = optionalEmpresa.get();

                if (empresaActualizada.getNom() != null) {
                    empresa.setNom(empresaActualizada.getNom());
                }
                if (empresaActualizada.getUbicacio() != null) {
                    empresa.setUbicacio(empresaActualizada.getUbicacio());
                }
                if (empresaActualizada.getCiutat() != null) {
                    empresa.setCiutat(empresaActualizada.getCiutat());
                }
                if (empresaActualizada.getPais() != null) {
                    empresa.setPais(empresaActualizada.getPais());
                }

                return empresaRepository.save(empresa);
            } else {
                throw new NoSuchElementException("No se encontró ninguna empresa con el ID: " + id);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar la empresa: " + e.getMessage(), e);
        }
    }

    public Oferta createOferta(Long empresaId, Oferta oferta) {
        try {
            Optional<Empresa> optionalEmpresa = empresaRepository.findById(empresaId);

            if (optionalEmpresa.isPresent()) {
                Empresa empresa = optionalEmpresa.get();
                oferta.setEmpresa(empresa);
                return ofertaRepository.save(oferta);
            } else {
                throw new NoSuchElementException("No se encontró ninguna empresa con el ID: " + empresaId + " para crear la oferta.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al crear la oferta: " + e.getMessage(), e);
        }
    }

    public List<Oferta> getAllOfertas() {
        try {
            return ofertaRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener todas las ofertas: " + e.getMessage(), e);
        }
    }

    public Oferta getOfertaById(Long ofertaId) {
        return ofertaRepository.findById(ofertaId)
                .orElseThrow(() -> new NoSuchElementException("No se encontró ninguna oferta con el ID: " + ofertaId));
    }

    public Optional<Oferta> getOfertaByIdEmpresa(Long ofertaId) {
        try {
            return ofertaRepository.findById(ofertaId);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener la oferta por ID: " + e.getMessage(), e);
        }
    }


    public Oferta updateOferta(Long empresaId, Long ofertaId, Oferta ofertaActualizada) {
        try {
            Optional<Oferta> optionalOferta = ofertaRepository.findById(ofertaId);

            if (optionalOferta.isPresent()) {
                Oferta oferta = optionalOferta.get();

                if (oferta.getEmpresa().getId().equals(empresaId)) {
                    oferta.setNom(ofertaActualizada.getNom());
                    oferta.setIdiomas(ofertaActualizada.getIdiomas());
                    oferta.setConocimientos(ofertaActualizada.getConocimientos());
                    oferta.setEstudios(ofertaActualizada.getEstudios());
                    oferta.setDescripcion(ofertaActualizada.getDescripcion());
                    oferta.setRequisitos(ofertaActualizada.getRequisitos());

                    return ofertaRepository.save(oferta);
                } else {
                    throw new NoSuchElementException("No se encontró la oferta con ID: " + ofertaId + " para la empresa con ID: " + empresaId);
                }
            } else {
                throw new NoSuchElementException("No se encontró ninguna oferta con el ID: " + ofertaId);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar la oferta: " + e.getMessage(), e);
        }
    }

    public void deleteOferta(Long empresaId, Long ofertaId) {
        try {
            ofertaRepository.findById(ofertaId).ifPresent(oferta -> {
                Empresa empresa = oferta.getEmpresa();
                if (empresa != null && empresa.getId().equals(empresaId)) {
                    ofertaRepository.deleteById(ofertaId);
                } else {
                    throw new NoSuchElementException("No se encontró la oferta con ID: " + ofertaId + " para la empresa con ID: " + empresaId);
                }
            });
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar la oferta: " + e.getMessage(), e);
        }
    }

    public List<Oferta> getOfertasByTipoEstudio(String tipoEstudio) {
        try {
            return ofertaRepository.findByEstudios(tipoEstudio);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener ofertas por tipo de estudio: " + e.getMessage(), e);
        }
    }

    public List<Oferta> getOfertasByPais(String pais) {
        try {
            return ofertaRepository.findAllByEmpresaPais(pais);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener ofertas por país: " + e.getMessage(), e);
        }
    }

    public List<Oferta> getOfertasByCiutat(String ciutat) {
        try {
            return ofertaRepository.findAllByEmpresaCiutat(ciutat);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener ofertas por ciudad: " + e.getMessage(), e);
        }
    }
}
