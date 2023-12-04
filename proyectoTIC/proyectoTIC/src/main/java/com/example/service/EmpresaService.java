package com.example.service;

import com.example.entidades.Empresa;

import java.util.List;

public interface EmpresaService {
	List<Empresa> getAllEmpresas();
	Empresa getEmpresaById(Long id);
	Empresa createEmpresa(Empresa empresa);
	/*Empresa getEmpresaByNom(String nom) throws Exception;*/
	void deleteEmpresa(Long id);
	Empresa updateEmpresa(Long id, Empresa empresaActualizada);
}
