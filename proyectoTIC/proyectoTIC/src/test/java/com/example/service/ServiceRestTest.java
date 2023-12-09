package com.example.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.entidades.Empresa;
import com.example.entidades.Oferta;
import com.example.repository.EmpresaRepository;
import com.example.repository.OfertaRepository;

import java.util.List;
import java.util.Optional;

class ServiceRestTest {

    @InjectMocks
    ServiceRest serviceRest;

    @Mock
    EmpresaRepository empresaRepository;

    @Mock
    OfertaRepository ofertaRepository;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createEmpresa() {
        Empresa empresaEntrada = new Empresa();
        when(empresaRepository.save(any(Empresa.class))).thenReturn(empresaEntrada);

        Empresa empresaCreada = serviceRest.createEmpresa(empresaEntrada);
        assertEquals(empresaEntrada, empresaCreada);

        verify(empresaRepository, times(1)).save(eq(empresaEntrada));
    }

    @Test
    void getAllEmpresas() {
        when(empresaRepository.findAll()).thenReturn(List.of());

        List<Empresa> empresas = serviceRest.getAllEmpresas();

        assertNotNull(empresas);
        assertEquals(0, empresas.size());

        verify(empresaRepository, times(1)).findAll();
    }

    @Test
    void getEmpresaById() {
        Long idExistente = 1L;
        Empresa empresaExistente = new Empresa();
        empresaExistente.setId(idExistente);

        when(empresaRepository.findById(idExistente)).thenReturn(Optional.of(empresaExistente));

        Empresa resultado = serviceRest.getEmpresaById(idExistente);
        assertNotNull(resultado);
        assertEquals(idExistente, resultado.getId());
    }

    @Test
    void getEmpresaByNom() throws Exception {
        String nombreExistente = "Empresa1";
        Empresa empresaExistente = new Empresa();
        empresaExistente.setId(1L);
        empresaExistente.setNom(nombreExistente);

        when(empresaRepository.findByNom(nombreExistente)).thenReturn(empresaExistente);

        Empresa empresaObtenida = serviceRest.getEmpresaByNom(nombreExistente);
        assertNotNull(empresaObtenida);
        assertEquals(empresaExistente.getId(), empresaObtenida.getId());
        assertEquals(empresaExistente.getNom(), empresaObtenida.getNom());
    }

    @Test
    void testUpdateEmpresa() {
        Long idExistente = 1L;
        Empresa empresaExistente = new Empresa();
        empresaExistente.setId(idExistente);
        empresaExistente.setNom("Empresa Existente");

        when(empresaRepository.findById(idExistente)).thenReturn(Optional.of(empresaExistente));

        Empresa empresaActualizada = new Empresa();
        empresaActualizada.setId(idExistente);
        empresaActualizada.setNom("Empresa Actualizada");

        when(empresaRepository.save(eq(empresaActualizada))).thenReturn(empresaActualizada);

        Empresa resultado = serviceRest.updateEmpresa(idExistente, empresaActualizada);
        assertNotNull(resultado);
        assertEquals(empresaActualizada.getId(), resultado.getId());
        assertEquals(empresaActualizada.getNom(), resultado.getNom());

        verify(empresaRepository, times(1)).findById(eq(idExistente));
        verify(empresaRepository, times(1)).save(eq(empresaActualizada));
        verifyNoMoreInteractions(empresaRepository);
    }

    @Test
    void deleteEmpresa() {
        Long idEmpresa = 1L;

        serviceRest.deleteEmpresa(idEmpresa);

        verify(empresaRepository, times(1)).deleteById(eq(idEmpresa));
    }

    @Test
    void createOferta() {
        Long empresaId = 1L;
        Oferta ofertaEntrada = new Oferta();
        Empresa empresaExistente = new Empresa();
        empresaExistente.setId(empresaId);

        when(empresaRepository.findById(empresaId)).thenReturn(Optional.of(empresaExistente));
        when(ofertaRepository.save(any(Oferta.class))).thenReturn(ofertaEntrada);

        Oferta ofertaCreada = serviceRest.createOferta(empresaId, ofertaEntrada);

        assertNotNull(ofertaCreada);
        assertEquals(ofertaEntrada, ofertaCreada);

        verify(empresaRepository, times(1)).findById(eq(empresaId));
        verify(ofertaRepository, times(1)).save(eq(ofertaEntrada));
    }

    @Test
    void getAllOfertas() {
        when(ofertaRepository.findAll()).thenReturn(List.of());

        List<Oferta> ofertas = serviceRest.getAllOfertas();

        assertNotNull(ofertas);
        assertEquals(0, ofertas.size());

        verify(ofertaRepository, times(1)).findAll();
    }

    @Test
    void getOfertaById() {
        Long ofertaId = 1L;
        Oferta ofertaExistente = new Oferta();
        ofertaExistente.setId(ofertaId);

        when(ofertaRepository.findById(ofertaId)).thenReturn(Optional.of(ofertaExistente));

        Oferta resultado = serviceRest.getOfertaById(ofertaId);

        assertNotNull(resultado);
        assertEquals(ofertaId, resultado.getId());

        verify(ofertaRepository, times(1)).findById(eq(ofertaId));
    }

    @Test
    void getOfertasByEmpresa() {
        Long empresaId = 1L;
        Oferta ofertaExistente = new Oferta();
        ofertaExistente.setId(1L);

        when(ofertaRepository.findById(empresaId)).thenReturn(Optional.of(ofertaExistente));

        Optional<Oferta> resultado = serviceRest.getOfertaByIdEmpresa(empresaId);

        assertTrue(resultado.isPresent());
        assertEquals(ofertaExistente, resultado.get());
    }

    @Test
    void UpdateOferta() {
        Long empresaIdExistente = 1L;
        Long ofertaIdExistente = 2L;

        Oferta ofertaExistente = new Oferta();
        ofertaExistente.setId(ofertaIdExistente);
        Empresa empresa = new Empresa();
        empresa.setId(empresaIdExistente);
        ofertaExistente.setEmpresa(empresa);

        Oferta ofertaActualizada = new Oferta();
        ofertaActualizada.setId(ofertaIdExistente);
        ofertaActualizada.setNom("Oferta Actualizada");

        when(ofertaRepository.findById(ofertaIdExistente)).thenReturn(Optional.of(ofertaExistente));
        when(ofertaRepository.save(any(Oferta.class))).thenReturn(ofertaExistente);

        Oferta resultado = serviceRest.updateOferta(empresaIdExistente, ofertaIdExistente, ofertaActualizada);

        assertNotNull(resultado);
        assertEquals(ofertaIdExistente, resultado.getId());
        assertEquals(ofertaActualizada.getNom(), resultado.getNom());

        verify(ofertaRepository, times(1)).findById(ofertaIdExistente);
        verify(ofertaRepository, times(1)).save(ofertaExistente);
        verify(ofertaRepository, never()).deleteById(anyLong());
    }

    @Test
    void deleteOferta() {
        Long empresaId = 1L;
        Long ofertaId = 2L;

        Oferta oferta = new Oferta();
        Empresa empresa = new Empresa();
        empresa.setId(empresaId);
        oferta.setEmpresa(empresa);

        when(ofertaRepository.findById(ofertaId)).thenReturn(Optional.of(oferta));

        serviceRest.deleteOferta(empresaId, ofertaId);

        verify(ofertaRepository, times(1)).deleteById(eq(ofertaId));
    }

    @Test
    void getOfertasByTipoEstudio() {
        String tipoEstudio = "Ingeniería";
        when(ofertaRepository.findByEstudios(tipoEstudio)).thenReturn(List.of());

        List<Oferta> ofertas = serviceRest.getOfertasByTipoEstudio(tipoEstudio);

        assertNotNull(ofertas);
        assertEquals(0, ofertas.size());

        verify(ofertaRepository, times(1)).findByEstudios(eq(tipoEstudio));
    }

    @Test
    void getOfertasByPais() {
        String pais = "España";
        when(ofertaRepository.findAllByEmpresaPais(pais)).thenReturn(List.of());

        List<Oferta> ofertas = serviceRest.getOfertasByPais(pais);

        assertNotNull(ofertas);
        assertEquals(0, ofertas.size());

        verify(ofertaRepository, times(1)).findAllByEmpresaPais(eq(pais));
    }

    @Test
    void getOfertasByCiutat() {
        String ciutat = "Barcelona";
        when(ofertaRepository.findAllByEmpresaCiutat(ciutat)).thenReturn(List.of());

        List<Oferta> ofertas = serviceRest.getOfertasByCiutat(ciutat);

        assertNotNull(ofertas);
        assertEquals(0, ofertas.size());

        verify(ofertaRepository, times(1)).findAllByEmpresaCiutat(eq(ciutat));
    }
}
