package com.example.entidades;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "empresas")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String ubicacio;
    private String ciutat;
    private String pais;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Oferta> ofertas;

    // Constructor que permite inicializar la instancia Empresa
    public Empresa(String nom, String ubicacio, String ciutat, String pais){
        this.nom = nom;
        this.ubicacio = ubicacio;
        this.ciutat = ciutat;
        this.pais = pais;
    }

    // Constructor vacio útil en JPA
    public Empresa() {}

    //Getter y Setter para los campos creados anteriormente
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

    public String getUbicacio() {
        return ubicacio;
    }

    public void setUbicacio(String ubicacio) {
        this.ubicacio = ubicacio;
    }

    public String getCiutat(){ return ciutat; }

    public void setCiutat(String ciutat){ this.ciutat = ciutat; }
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    //
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Empresa empresa)) return false;
        return Objects.equals(getId(), empresa.getId()) && Objects.equals(getNom(),
                empresa.getNom()) && Objects.equals(getUbicacio(), empresa.getUbicacio()) &&
                Objects.equals(getCiutat(), empresa.getCiutat()) && Objects.equals(getPais(),
                empresa.getPais()) && Objects.equals(ofertas, empresa.ofertas);
    }

}