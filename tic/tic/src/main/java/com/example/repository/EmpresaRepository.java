package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entidades.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

	@Query("SELECT e FROM Empresa e WHERE e.nom = :nom")
	Empresa findByNom(@Param("nom") String nom);
}
