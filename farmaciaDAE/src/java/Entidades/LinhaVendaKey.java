/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Objects;

/**
 *
 * @author Andre
 */
public class LinhaVendaKey {
    private int produto;
    private Integer venda;

    public LinhaVendaKey() {
    }

    public LinhaVendaKey(int produto, Integer venda) {
        this.produto = produto;
        this.venda = venda;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    public Integer getVenda() {
        return venda;
    }

    public void setVenda(Integer venda) {
        this.venda = venda;
    }

  

    @Override
       public int hashCode() {
        return ((this.getVenda() == null
                ? 0 : this.getVenda().hashCode())
                ^ ((int) this.getProduto()));
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
                && (this.getProduto() == other.getProduto()));
    }

    @Override
    public String toString() {
        return "" + getVenda() + "-" + getProduto();
    }
    
}
