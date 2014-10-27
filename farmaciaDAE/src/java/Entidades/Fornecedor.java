/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Cristiano
 */
@Entity
public class Fornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    private String laboratorio;
    @NotNull
    private String email;
    @NotNull
    private int telemovel;
    @NotNull
    private String morada;
    @ManyToMany
    @JoinTable(
            name = "FORNECEDOR_FARMACIA",
            joinColumns
            = @JoinColumn(name = "FORNECEDOR_ID", referencedColumnName = "LABORATORIO"),
            inverseJoinColumns
            = @JoinColumn(name = "FARMACIA_ID", referencedColumnName = "ID")
    )
    private List<Farmacia> farmacias;
    @ManyToMany
        @JoinTable(
            name = "FORNECEDOR_CATALOGO",
            joinColumns
            = @JoinColumn(name = "FORNECEDOR_ID", referencedColumnName = "LABORATORIO"),
            inverseJoinColumns
            = @JoinColumn(name = "CATALOGO_ID", referencedColumnName = "REFERENCIA")
    )
    @NotNull
    private List<Catalogo> catalogos;
    

    public Fornecedor() {
        this.farmacias = new LinkedList();
    }

    public Fornecedor(String laboratorio, String email, int telemovel, String morada) {
        this.laboratorio = laboratorio;
        this.email = email;
        this.telemovel = telemovel;
        this.morada = morada;
        this.farmacias = new LinkedList();
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(int telemovel) {
        this.telemovel = telemovel;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public List<Farmacia> getFarmacias() {
        return farmacias;
    }

    public void addFarmacia(Farmacia farmacia) {
        this.farmacias.add(farmacia);
    }

    public void removeFarmacia(Farmacia farmacia) {
        this.farmacias.remove(farmacia);
    }
    

    
}
