package com.example.service;

import com.example.entidades.Empresa;
import com.example.repository.EmpresaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmpresaServiceImplementsTest {
	
	//SUT
	EmpresaService empresaService;
	//Dependencias
	@Mock
	EmpresaRepository empresaRepository;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		empresaService = new EmpresaServiceImplement(empresaRepository);
		
	}

	@Test
	void getAllEmpresas() {
		when(empresaRepository.findAll()).thenReturn(List.of());
		
		List<Empresa> empresas = empresaService.getAllEmpresas();
		
		assertNotNull(empresas);
		assertEquals(0, empresas.size());
		
		verify(empresaRepository, times(1)).findAll();
	}
	
	@Test
	void findById() {
		
		Long idExistente = 1L;
        Empresa empresaExistente = new Empresa();
        empresaExistente.setId(idExistente);

        when(empresaRepository.findById(idExistente)).thenReturn(Optional.of(empresaExistente));

        Empresa resultado = empresaService.getEmpresaById(idExistente);
        assertNotNull(resultado);
        assertEquals(idExistente, resultado.getId());
	}
	
	@Test
    public void testCreateEmpresa() {
        Empresa empresaEntrada = new Empresa();
        empresaEntrada.setId(1L);
        empresaEntrada.setNom("Empresa1");

        when(empresaRepository.save(any(Empresa.class))).thenReturn(empresaEntrada);

        Empresa empresaCreada = empresaService.createEmpresa(empresaEntrada);
        assertNotNull(empresaCreada);
        assertEquals(empresaEntrada.getId(), empresaCreada.getId());
        assertEquals(empresaEntrada.getNom(), empresaCreada.getNom());

        verify(empresaRepository, times(1)).save(eq(empresaEntrada));
    }
	
	/*@Test
    public void testGetEmpresaByNom() throws Exception {
        String nombreExistente = "Empresa1";
        Empresa empresaExistente = new Empresa();
        empresaExistente.setId(1L);
        empresaExistente.setNom(nombreExistente);

        when(empresaRepository.findByNom(nombreExistente)).thenReturn(empresaExistente);

        Empresa empresaObtenida = empresaService.getEmpresaByNom(nombreExistente);
        assertNotNull(empresaObtenida);
        assertEquals(empresaExistente.getId(), empresaObtenida.getId());
        assertEquals(empresaExistente.getNom(), empresaObtenida.getNom());
    }*/
	
	@Test
    public void testDeleteEmpresa() {
        Long idEmpresa = 1L;

        empresaService.deleteEmpresa(idEmpresa);

        verify(empresaRepository, times(1)).deleteById(eq(idEmpresa));
    }
	
	@Test
    public void testUpdateEmpresa() {
        Long idExistente = 1L;
        Empresa empresaExistente = new Empresa();
        empresaExistente.setId(idExistente);
        empresaExistente.setNom("Empresa Existente");
        /*empresaExistente.setDescripcio("Descripción original");*/
        empresaExistente.setUbicacio("Ubicación original");

        when(empresaRepository.findById(idExistente)).thenReturn(Optional.of(empresaExistente));

        Empresa empresaActualizada = new Empresa();
        empresaActualizada.setId(idExistente);
        empresaActualizada.setNom("Empresa Actualizada");
        /*empresaActualizada.setDescripcio("Nueva descripción");*/
        empresaActualizada.setUbicacio("Nueva ubicación");

        Empresa empresaActualizadaResult = empresaService.updateEmpresa(idExistente, empresaActualizada);
        assertNotNull(empresaActualizadaResult);
        assertEquals(idExistente, empresaActualizadaResult.getId());
        assertEquals(empresaActualizada.getNom(), empresaActualizadaResult.getNom());
        /*assertEquals(empresaActualizada.getDescripcio(), empresaActualizadaResult.getDescripcio());*/
        assertEquals(empresaActualizada.getUbicacio(), empresaActualizadaResult.getUbicacio());

        verify(empresaRepository, times(1)).save(eq(empresaExistente));
    }


}
