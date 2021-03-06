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
public class LinhaVendaKey implements Serializable{

    private Long venda;
    private int produtoCatalogo;

    public LinhaVendaKey() {
    }

    public LinhaVendaKey(Long venda, int produtoCatalogo) {
        this.venda = venda;
        this.produtoCatalogo = produtoCatalogo;
    }

    public int getCatalogo() {
        return produtoCatalogo;
    }

    public void setCatalogo(int produtoCatalogo) {
        this.produtoCatalogo = produtoCatalogo;
 
    }

    public Long getVenda() {
        return venda;
    }

    public void setVenda(Long venda) {
        this.venda = venda;
    }

  

    @Override
       public int hashCode() {
        return ((this.getVenda() == null
                ? 0 : this.getVenda().hashCode())
                ^ ((int) this.getCatalogo()));
    }

    @Override
    public boolean equals(Object otherOb) {

        if (this == otherOb) {
            return true;
        }
        if (!(otherOb instanceof LinhaVendaKey)) {
            return false;
        }
        LinhaVendaKey other = (LinhaVendaKey) otherOb;
        return ((this.getVenda() == null
                ? other.getVenda() == null : this.getVenda()
                .equals(other.getVenda()))
                && (this.getCatalogo() == other.getCatalogo()));
    }

    @Override
    public String toString() {
        return "" + getVenda() + "-" + getCatalogo();
    }
    
}
