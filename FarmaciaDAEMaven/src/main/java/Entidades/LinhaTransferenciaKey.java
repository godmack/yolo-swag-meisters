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
public class LinhaTransferenciaKey implements Serializable{
    private int produtoCatalogo;
    private Long transferencia;

    public LinhaTransferenciaKey() {
    }

    public LinhaTransferenciaKey(int produtoCatalogo, Long transferencia) {
        this.produtoCatalogo = produtoCatalogo;
        this.transferencia = transferencia;
    }

    public int getProduto() {
        return produtoCatalogo;
    }

    public void setProduto(int produtoCatalogo) {
        this.produtoCatalogo = produtoCatalogo;
    }

    public Long getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(Long transferencia) {
        this.transferencia = transferencia;
    }

  

    @Override
       public int hashCode() {
        return ((this.getTransferencia() == null
                ? 0 : this.getTransferencia().hashCode())
                ^ ((int) this.getProduto()));
    }

    @Override
    public boolean equals(Object otherOb) {

        if (this == otherOb) {
            return true;
        }
        if (!(otherOb instanceof LinhaTransferenciaKey)) {
            return false;
        }
        LinhaTransferenciaKey other = (LinhaTransferenciaKey) otherOb;
        return ((this.getTransferencia() == null
                ? other.getTransferencia() == null : this.getTransferencia()
                .equals(other.getTransferencia()))
                && (this.getProduto() == other.getProduto()));
    }

    @Override
    public String toString() {
        return "" + getTransferencia() + "-" + getProduto();
    }
    
}
