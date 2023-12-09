package com.example.entidades;


import jakarta.persistence.*;

@Entity
@Table(name = "ofertas")
public class Oferta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String idiomas;
    private String conocimientos;
    private String estudios;
    private String descripcion;
    private String requisitos;


    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public Oferta(String nom, String idiomas, String conocimientos,
                  String estudios, String descripcion, String requisitios, Empresa empresa){
        this.nom = nom;
        this.idiomas = idiomas;
        this.conocimientos = conocimientos;
        this.estudios = estudios;
        this.descripcion = descripcion;
        this.requisitos = requisitios;
        this.empresa = empresa;
    }

    public Oferta() {}

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

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String requisitos) {
        this.idiomas = requisitos;
    }

    public String getConocimientos() {
        return conocimientos;
    }

    public void setConocimientos(String conocimientosNecesarios) {
        this.conocimientos = conocimientosNecesarios;
    }

    public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudiosNecesarios) {
        this.estudios = estudiosNecesarios;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRequisitos(){ return requisitos; }
    public void setRequisitos(String requisitos){ this.requisitos = requisitos; }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

}