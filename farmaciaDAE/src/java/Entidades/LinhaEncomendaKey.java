/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Andre
 */
public class LinhaEncomendaKey implements Serializable{
    private int produtoCatalogo;
    private Long encomenda;

    public LinhaEncomendaKey() {
    }

    public LinhaEncomendaKey(int produtoCatalogo, Long encomenda) {
        this.produtoCatalogo = produtoCatalogo;
        this.encomenda = encomenda;
    }

    public int getProduto() {
        return produtoCatalogo;
    }

    public void setProduto(int produto) {
        this.produtoCatalogo = produto;
    }

    public Long getEncomenda() {
        return encomenda;
    }

    public void setEncomenda(Long encomenda) {
        this.encomenda = encomenda;
    }

  

    @Override
       public int hashCode() {
        return ((this.getEncomenda() == null
                ? 0 : this.getEncomenda().hashCode())
                ^ ((int) this.getProduto()));
    }

    @Override
    public boolean equals(Object otherOb) {

        if (this == otherOb) {
            return true;
        }
        if (!(otherOb instanceof LinhaEncomendaKey)) {
            return false;
        }
        LinhaEncomendaKey other = (LinhaEncomendaKey) otherOb;
        return ((this.getEncomenda() == null
                ? other.getEncomenda() == null : this.getEncomenda()
                .equals(other.getEncomenda()))
                && (this.getProduto() == other.getProduto()));
    }

    @Override
    public String toString() {
        return "" + getEncomenda() + "-" + getProduto();
    }
    
}
