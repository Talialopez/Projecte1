package com.example.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "empresas")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String descripcio;
    private String ubicacio;
    
    
    Empresa() {}
    
    Empresa(String nom, String descripcio, String ubicacio){
    	this.nom = nom;
    	this.descripcio = descripcio;
    	this.ubicacio = ubicacio;
    }
    
    public Long getId() {
    	return this.id;
    }
    
    public void setId(Long id) {
    	this.id = id;
    }
    
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getDescripcio() {
		return descripcio;
	}
	
	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	public String getUbicacio() {
		return ubicacio;
	}

	public void setUbicacio(String ubicacio) {
		this.ubicacio = ubicacio;
	}
}
