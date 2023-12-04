package com.example.entidades;


import jakarta.persistence.*;

@Entity
@Table(name = "ofertas")
public class Oferta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String requisitos;
    private String conocimientosNecesarios;
    private String estudiosNecesarios;
    private String descripcion;


    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public Oferta(String nom, String requisitos, String conocimientosNecesarios, String estudiosNecesarios, String descripcion, Empresa empresa){
        this.nom = nom;
        this.requisitos = requisitos;
        this.conocimientosNecesarios =conocimientosNecesarios;
        this.estudiosNecesarios = estudiosNecesarios;
        this.descripcion = descripcion;
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

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public String getConocimientosNecesarios() {
        return conocimientosNecesarios;
    }

    public void setConocimientosNecesarios(String conocimientosNecesarios) {
        this.conocimientosNecesarios = conocimientosNecesarios;
    }

    public String getEstudiosNecesarios() {
        return estudiosNecesarios;
    }

    public void setEstudiosNecesarios(String estudiosNecesarios) {
        this.estudiosNecesarios = estudiosNecesarios;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

}