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
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Andre
 */
@MappedSuperclass
public abstract class Linhas{

    @Id
    @ManyToOne
    @JoinColumn(name="REFERENCIA_CATALOGO")
    @NotNull
    private ProdutoCatalogo produtoCatalogo;
    @NotNull
    private int quantidade;

    public Linhas(ProdutoCatalogo produtoCatalogo, int quantidade) {
        this.produtoCatalogo = produtoCatalogo;
        this.quantidade = quantidade;
    }

    public Linhas() {
    }
    
    
        public ProdutoCatalogo getProdutoCatalogo() {
        return produtoCatalogo;
    }

    public void setCatalogo(ProdutoCatalogo produtoCatalogo) {
        this.produtoCatalogo = produtoCatalogo;
    }
    
          public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


   
    
}
