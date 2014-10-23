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
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Cristiano
 */
@Entity
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    
    @NotNull
    private String nome;
    @NotNull
    private String email;
    @NotNull
    private int contacto;
    @ManyToOne
    @NotNull
    private List<Venda> vendas;

    public Cliente() {
        this.vendas = new LinkedList();
    }

    public Cliente(String nome, String email, int contacto) {
        this.nome = nome;
        this.email = email;
        this.contacto = contacto;
        this.vendas = new LinkedList();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void addVendas(Venda venda) {
        this.vendas.add(venda);
    }
    
    public void removeVendas(Venda venda) {
        this.vendas.remove(venda);
    }

    

    
    
}
