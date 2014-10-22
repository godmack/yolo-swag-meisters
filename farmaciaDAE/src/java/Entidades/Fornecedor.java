/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Cristiano
 */
@Entity
public class Fornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String laboratorio;
    private String email;
    private int telemovel;
    private String morada;
    private List<Farmacia> farmacias;

    public Fornecedor() {
    }

    public Fornecedor(String laboratorio, String email, int telemovel, String morada, List<Farmacia> farmacias) {
        this.laboratorio = laboratorio;
        this.email = email;
        this.telemovel = telemovel;
        this.morada = morada;
        this.farmacias = farmacias;
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

    public void setFarmacias(List<Farmacia> farmacias) {
        this.farmacias = farmacias;
    }


    
}
