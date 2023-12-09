package com.example.repository;

import com.example.entidades.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entidades.Oferta;

import java.util.List;

@Repository
public interface OfertaRepository extends JpaRepository<Oferta, Long> {
    List<Oferta> findByEstudios(String estudios);
    List<Oferta> findAllByEmpresaPais(String pais);
    List<Oferta> findAllByEmpresaCiutat(String ciutat);
}