package com.example.repository;

import com.example.entidades.Empresa;
import com.example.entidades.Oferta;
import com.example.service.ServiceRest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class AppRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private OfertaRepository ofertaRepository;

    // Métodos de ayuda para insertar datos de prueba
    private Empresa insertDemoEmpresa() {
        Empresa empresa = new Empresa("Empresa X", "Ubicacion X",
                    "Ciudad X", "Pais X");
        entityManager.persist(empresa);
        entityManager.flush();
        return empresa;
    }

    private Oferta insertDemoOferta(Empresa empresa) {
        Oferta oferta = new Oferta("Nombre X", "Idioma X",
                "Conocimientos X", "Estudios X",
                  "Descripcion X", "Requisitos X", empresa);
        entityManager.persist(oferta);
        entityManager.flush();
        return oferta;
    }

    // Prueba para empresas

    @Test
    public void testAllEmpresas() {
        insertDemoEmpresa();

        List<Empresa> empresas = empresaRepository.findAll();

        System.out.println("Empresas existentes:");
        empresas.forEach(empresa -> {
            System.out.println("ID: " + empresa.getId() + ", Nombre: " + empresa.getNom() + ", Ubicación: " + empresa.getUbicacio() +
                                ", Ciudad: " + empresa.getCiutat() + ", Pais: " + empresa.getPais() );
        });

        assertEquals(16, empresas.size());
    }

    @Test
    public void testCreateEmpresa() {
        Empresa empresa = new Empresa("Empresa Y", "Ubicacion Y", "Ciudad Y", "Pais Y");
        Empresa empresaGuardada = empresaRepository.save(empresa);

        assertTrue(empresaGuardada.getId() != null && empresaGuardada.getId() > 0);
        assertEquals("Empresa Y", empresaGuardada.getNom());
        assertEquals("Ubicacion Y", empresaGuardada.getUbicacio());
        assertEquals("Ciudad Y", empresaGuardada.getCiutat());
        assertEquals("Pais Y", empresaGuardada.getPais());
    }

    @Test
    public void testEmpresaFindById() {
        Empresa empresaGuardada = insertDemoEmpresa();
        Optional<Empresa> empresaEncontrada = empresaRepository.findById(empresaGuardada.getId());

        assertTrue(empresaEncontrada.isPresent());
        assertEquals("Empresa X", empresaEncontrada.get().getNom());
        assertEquals("Ubicacion X", empresaEncontrada.get().getUbicacio());
        assertEquals("Ciudad X", empresaEncontrada.get().getCiutat());
        assertEquals("Pais X", empresaEncontrada.get().getPais());
    }

    @Test
    public void testFindByNom() {
        Empresa empresa = insertDemoEmpresa();

        Empresa result = empresaRepository.findByNom("Empresa X");

        assertEquals(empresa, result);
    }

    @Test
    public void testEmpresaUpdate() {
        Empresa empresaGuardada = insertDemoEmpresa();
        empresaGuardada.setNom("Empresa Modificada");
        empresaGuardada.setUbicacio("Ubicacion Modificada");
        empresaGuardada.setCiutat("Ciudad Modificada");
        empresaGuardada.setPais("Pais Modificado");

        Empresa empresaActualizada = empresaRepository.save(empresaGuardada);

        assertEquals("Empresa Modificada", empresaActualizada.getNom());
        assertEquals("Ubicacion Modificada", empresaActualizada.getUbicacio());
        assertEquals("Ciudad Modificada", empresaActualizada.getCiutat());
        assertEquals("Pais Modificado", empresaActualizada.getPais());

    }

    @Test
    public void testEmpresaDeleteById() {
        Empresa empresaGuardada = insertDemoEmpresa();
        empresaRepository.deleteById(empresaGuardada.getId());
        Optional<Empresa> empresaEncontrada = empresaRepository.findById(empresaGuardada.getId());

        assertTrue(empresaEncontrada.isEmpty(), "La empresa no se eliminó");
    }

    // Prueba para ofertas

    @Test
    public void testCreateOferta() {
        Optional<Empresa> empresaOptional = empresaRepository.findById(1L);

        if (empresaOptional.isPresent()) {
            Empresa empresaExistente = empresaOptional.get();

            Oferta ofertaDemo = insertDemoOferta(empresaExistente);
            Oferta ofertaGuardada = ofertaRepository.save(ofertaDemo);

            assertNotNull(ofertaGuardada.getId());

            assertEquals("Nombre X", ofertaGuardada.getNom());
            assertEquals(empresaExistente, ofertaGuardada.getEmpresa());
        } else {
            System.err.println("Error: No se encontró ninguna empresa con el ID asignado");
        }
    }

    @Test
    public void testOfertaFindById() {
        Optional<Empresa> empresaOptional = empresaRepository.findById(1L);

        if (empresaOptional.isPresent()) {
            Empresa empresa = empresaOptional.get();

            Oferta ofertaDemo = insertDemoOferta(empresa);

            Optional<Oferta> ofertaEncontrada = ofertaRepository.findById(ofertaDemo.getId());

            assertTrue(ofertaEncontrada.isPresent());

            assertEquals("Nombre X", ofertaEncontrada.get().getNom());
            assertEquals(empresa, ofertaEncontrada.get().getEmpresa());
        } else {
            System.err.println("Error: No se encontró ninguna empresa con el ID asignado.");
        }
    }


    @Test
    public void testOfertaFindByIdEmpresa() {
        Optional<Empresa> empresaOptional = empresaRepository.findById(1L);

        if (empresaOptional.isPresent()) {
            Empresa empresa = empresaOptional.get();

            Oferta ofertaDemo = insertDemoOferta(empresa);

            Optional<Oferta> ofertaEncontrada = ofertaRepository.findById(ofertaDemo.getId());

            assertTrue(ofertaEncontrada.isPresent());

            assertEquals("Nombre X", ofertaEncontrada.get().getNom());
            assertEquals(empresa, ofertaEncontrada.get().getEmpresa());
        } else {
            System.err.println("Error: No se encontró ninguna empresa con el ID asignado.");
        }
    }

    @Test
    public void testOfertaUpdate() {
        Optional<Empresa> empresa = empresaRepository.findById(1L);

        if (empresa.isPresent()) {
            Empresa empresaExistente = empresa.get();

            Oferta ofertaDemo = insertDemoOferta(empresaExistente);

            ofertaDemo.setNom("Oferta Modificada");
            ofertaDemo.setDescripcion("Descripción Modificada");

            Oferta ofertaActualizada = ofertaRepository.save(ofertaDemo);

            assertEquals("Oferta Modificada", ofertaActualizada.getNom());
            assertEquals("Descripción Modificada", ofertaActualizada.getDescripcion());
        } else {
            System.err.println("Error: No se encontró ninguna empresa con el ID asignado");
        }
    }

    @Test
    public void testOfertaDeleteById() {
        Optional<Empresa> empresaOptional = empresaRepository.findById(1L);

        if (empresaOptional.isPresent()) {
            Empresa empresaExistente = empresaOptional.get();

            Oferta ofertaDemo = insertDemoOferta(empresaExistente);

            ofertaRepository.deleteById(ofertaDemo.getId());

            Optional<Oferta> ofertaEncontrada = ofertaRepository.findById(ofertaDemo.getId());
            assertTrue(ofertaEncontrada.isEmpty(), "La oferta no se eliminó");
        } else {
            System.err.println("Error: No se encontró ninguna empresa con el ID asignado");
        }
    }

    @Test
    public void testAllOfertas() {
        List<Oferta> ofertas = ofertaRepository.findAll();

        assertEquals(28, ofertas.size());

        System.out.println("Ofertas: ");
        ofertas.forEach(oferta -> {
            System.out.println("ID: " + oferta.getId());
            System.out.println("Nombre: " + oferta.getNom());
            System.out.println("Idioma: " + oferta.getIdiomas());
            System.out.println("Conocimientos: " + oferta.getConocimientos());
            System.out.println("Estudios: " + oferta.getEstudios());
            System.out.println("Descripción: " + oferta.getDescripcion());
            System.out.println("Requisitos: " + oferta.getRequisitos());
            System.out.println("Empresa: " + oferta.getEmpresa().getNom());
            System.out.println("------");
        });
    }

    @Test
    public void testOfertadByTipoEstudio() {
        Empresa empresaDemo = insertDemoEmpresa();
        Oferta ofertaDemo = insertDemoOferta(empresaDemo);
        ofertaDemo.setEstudios("Estudios X");

        String tipoEstudio = "Estudios X";
        List<Oferta> ofertas = ofertaRepository.findByEstudios(tipoEstudio);

        Oferta ofertaEncontrada = ofertas.get(0);
        assertEquals(tipoEstudio, ofertaEncontrada.getEstudios());
    }

    @Test
    public void testGetOfertasByCiutat() {
        insertDemoEmpresa();

        String ciudad = "Ciudad X";
        List<Oferta> ofertas = ofertaRepository.findAllByEmpresaCiutat(ciudad);

        ofertas.forEach(oferta ->
                assertEquals(ciudad, oferta.getEmpresa().getCiutat()));
    }

    @Test
    public void testGetOfertasByPais() {
        insertDemoEmpresa();

        String pais = "Pais X";
        List<Oferta> ofertas = ofertaRepository.findAllByEmpresaPais(pais);

        ofertas.forEach(oferta ->
                assertEquals(pais, oferta.getEmpresa().getPais()));
    }

}


