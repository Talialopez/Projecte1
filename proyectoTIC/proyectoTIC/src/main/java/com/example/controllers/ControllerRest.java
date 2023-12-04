package com.example.controllers;

import java.util.List;
import java.util.Optional;

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
import com.example.entidades.Oferta;
import com.example.repository.EmpresaRepository;
import com.example.repository.OfertaRepository;
import com.example.service.ServiceRest;

@RestController
@RequestMapping("/api")
public class ControllerRest {

    @Autowired
    private ServiceRest serviceRest;
    @Autowired
    private EmpresaRepository empresaR;
    @Autowired
    private OfertaRepository ofertaR;


    @PostMapping// Vamos a guardar un objeto
    public Empresa createEmpresa(@RequestBody Empresa empresa) {
        return serviceRest.createEmpresa(empresa);
    }

    @GetMapping("/empresas")
    public List<Empresa> getAllEmpresas() {
        return serviceRest.getAllEmpresas();
    }

    @GetMapping("{id}")
    public Empresa searchEmpresaById(@PathVariable("id") Long id) {
        return serviceRest.getEmpresaById(id);
    }

    @PutMapping("{id}")
    public Empresa updateEmpresa(@PathVariable("id") Long id, @RequestBody Empresa empresa) {
        return serviceRest.updateEmpresa(id, empresa);
    }

    @DeleteMapping("{id}")
    public void deleteEmpresa(@PathVariable("id") Long id) {
        serviceRest.deleteEmpresa(id);
    }

    @PostMapping("/empresas/{empresaId}/ofertas")
    public Oferta createOferta(@PathVariable("empresaId") Long empresaId, @RequestBody Oferta oferta) {
        Empresa empresa = serviceRest.getEmpresaById(empresaId);
        oferta.setEmpresa(empresa);
        return serviceRest.createOferta(empresaId, oferta);
    }

    @GetMapping("/ofertas")
    public List<Oferta> getAllOfertas() {
        return serviceRest.getAllOfertas();
    }

    @GetMapping("/empresas/{empresaId}/ofertas")
    public Optional<Oferta> getOfertasByEmpresa(@PathVariable("empresaId") Long empresaId) {
        return serviceRest.getOfertasByEmpresa(empresaId);
    }

    @PutMapping("/empresas/{empresaId}/ofertas/{ofertaId}")
    public Oferta updateOferta(@PathVariable("empresaId") Long empresaId, @PathVariable("ofertaId") Long ofertaId,
                               @RequestBody Oferta oferta) {
        return serviceRest.updateOferta(empresaId, ofertaId, oferta);
    }

    @DeleteMapping("/empresas/{empresaId}/ofertas/{ofertaId}")
    public void deleteOferta(@PathVariable("empresaId") Long empresaId, @PathVariable("ofertaId") Long ofertaId) {
        serviceRest.deleteOferta(empresaId, ofertaId);
    }
}