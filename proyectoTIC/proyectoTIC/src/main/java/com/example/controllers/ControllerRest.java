package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.entidades.Empresa;
import com.example.entidades.Oferta;
import com.example.service.ServiceRest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ControllerRest {

    @Autowired
    private ServiceRest serviceRest;

    // Creación de una empresa
    @PostMapping("/empresas") // Vamos a guardar un objeto
    public Empresa createEmpresa(@RequestBody Empresa empresa) throws Exception {
        return serviceRest.createEmpresa(empresa);
    }

    // Listar todas las empresas
    @GetMapping("/empresas")
    public List<Empresa> getAllEmpresas() {

        return serviceRest.getAllEmpresas();
    }

    // Listar empresas por id
    @GetMapping("/empresas/{id}")
    public Empresa searchEmpresaById(@PathVariable("id") Long id) throws Exception {
        return serviceRest.getEmpresaById(id);
    }

    // Actualizar datos de una empresa introduciendo el id
    @PutMapping("/empresas/{id}")
    public Empresa updateEmpresa(@PathVariable("id") Long id, @RequestBody Empresa empresa) throws Exception {
        return serviceRest.updateEmpresa(id, empresa);
    }

    // Eliminar empresa y ofertas asociadas a la empresa
    @DeleteMapping("/empresas/{id}")
    public void deleteEmpresa(@PathVariable("id") Long id) throws Exception {
        serviceRest.deleteEmpresa(id);
    }

    // Crear una oferta asociada a una empresa por su id
    @PostMapping("/empresas/{empresaId}/ofertas")
    public Oferta createOferta(@PathVariable("empresaId") Long empresaId, @RequestBody Oferta oferta) throws Exception {
        Empresa empresa = serviceRest.getEmpresaById(empresaId);
        oferta.setEmpresa(empresa);
        return serviceRest.createOferta(empresaId, oferta);
    }

    // Listar todas las ofertas publicadas
    @GetMapping("/ofertas")
    public List<Oferta> getAllOfertas() {

        return serviceRest.getAllOfertas();
    }

    // Listar una oferta en particular a través de su ID
    @GetMapping("/ofertas/{ofertaId}")
    public Oferta getOfertaById(@PathVariable("ofertaId") Long ofertaId) throws Exception {
        return serviceRest.getOfertaById(ofertaId);
    }

    // Listar las ofertas existentes de una empresa a través de la ID de esta
    @GetMapping("/empresas/{empresaId}/ofertas")
    public List<Oferta> getOfertasByIdEmpresa(@PathVariable("empresaId") Long empresaId) {
        try {
            Optional<Oferta> ofertaOptional = serviceRest.getOfertaByIdEmpresa(empresaId);
            return ofertaOptional.map(Collections::singletonList).orElseGet(Collections::emptyList);
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    // Actualizar oferta a través del id de la empresa asociada y el id de la oferta
    @PutMapping("/empresas/{empresaId}/ofertas/{ofertaId}")
    public Oferta updateOferta(@PathVariable("empresaId") Long empresaId, @PathVariable("ofertaId") Long ofertaId,
                               @RequestBody Oferta oferta) throws Exception {
        return serviceRest.updateOferta(empresaId, ofertaId, oferta);
    }

    // Eliminar una oferta a través de su id y del de la empresa asociada
    @DeleteMapping("/empresas/{empresaId}/ofertas/{ofertaId}")
    public void deleteOferta(@PathVariable("empresaId") Long empresaId, @PathVariable("ofertaId") Long ofertaId) throws Exception {
        serviceRest.deleteOferta(empresaId, ofertaId);
    }

    // Buscar una empresa por su nombre
    @GetMapping("/empresas/nombre/{nom}")
    public Empresa searchEmpresaByNom(@PathVariable("nom") String nom) throws Exception {
        return serviceRest.getEmpresaByNom(nom);
    }

    @GetMapping("/ofertas/tipoestudio/{tipoEstudio}") // Buscar una oferta por el tipo de estudio
    public List<Oferta> getOfertasByTipoEstudio(@PathVariable("tipoEstudio") String tipoEstudio) throws Exception {
        return serviceRest.getOfertasByTipoEstudio(tipoEstudio);
    }

    // Buscar ofertas por país
    @GetMapping("/ofertas/pais/{pais}")
    public List<Oferta> getOfertasByPais(@PathVariable("pais") String pais) throws Exception {
        return serviceRest.getOfertasByPais(pais);
    }

    // Buscar ofertas por ciudad
    @GetMapping("/ofertas/ciudad/{ciutat}")
    public List<Oferta> getOfertasByCiutat(@PathVariable("ciutat") String ciutat) throws Exception {
        return serviceRest.getOfertasByCiutat(ciutat);
    }
}
