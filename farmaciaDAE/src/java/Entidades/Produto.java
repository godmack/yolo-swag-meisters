/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Cristiano
 */
@Entity
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private int referencia;
    private String nome;
    private String laboratorio;
    private String emailFornEleicao;
    private String emailFornAlternativo;
    private float preco;

    public Produto(){
        
    }
    
    public Produto(int referencia, String nome, String laboratorio, String emailFornEleicao, String emailFornAlternativo, float preco) {
        this.referencia = referencia;
        this.nome = nome;
        this.laboratorio = laboratorio;
        this.emailFornEleicao = emailFornEleicao;
        this.emailFornAlternativo = emailFornAlternativo;
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

    public String getEmailFornEleicao() {
        return emailFornEleicao;
    }

    public void setEmailFornEleicao(String emailFornEleicao) {
        this.emailFornEleicao = emailFornEleicao;
    }

    public String getEmailFornAlternativo() {
        return emailFornAlternativo;
    }

    public void setEmailFornAlternativo(String emailFornAlternativo) {
        this.emailFornAlternativo = emailFornAlternativo;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    
    
    
}
