package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entidades.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}