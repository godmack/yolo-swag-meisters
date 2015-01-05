/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Ruben
 */
public class ProdutoCatalogoDTO implements Serializable{
    private int referencia;
    private String nome;
    private String laboratorio;
    private Double preco;

    public ProdutoCatalogoDTO() {
    }

    public ProdutoCatalogoDTO(int referencia, String nome, String laboratorio, Double preco) {
        this.referencia = referencia;
        this.nome = nome;
        this.laboratorio = laboratorio;
        this.preco = preco;
    }

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void reiniciar(){
        this.setLaboratorio(null);
        this.setNome(null);
        this.setReferencia(-1);
        this.setPreco(null);
    }
    
    
    
}
