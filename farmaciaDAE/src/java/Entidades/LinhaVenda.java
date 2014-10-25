/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Andre
 */
@Entity
public class LinhaVenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;
    @ManyToOne
    @JoinColumn(name="ID_VENDA"-)
    @NotNull
    private Venda venda;
    @ManyToOne
    @JoinColumn(name="REFERENCIA_CATALOGO")
    @NotNull
    private Catalogo catalogo;
    @NotNull
    private float preco;
    @NotNull
    private int quantidade;

    public LinhaVenda() {
    }

    public LinhaVenda(Long id, Venda venda, Catalogo catalogo, float preco, int quantidade) {
        this.id = id;
        this.venda = venda;
        this.catalogo = catalogo;
        this.preco = preco;
        this.quantidade = quantidade;
    }

  
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
      public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
