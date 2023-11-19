package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entidades.Oferta;

@Repository
public interface OfertaRepository extends JpaRepository<Oferta, Long> {

}
