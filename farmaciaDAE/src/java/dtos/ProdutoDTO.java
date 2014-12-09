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
public class ProdutoDTO implements Serializable{
    private int lote;
    private Date dataValidade;

    public ProdutoDTO() {
    }

    public ProdutoDTO(int lote, Date dataValidade) {
        this.lote = lote;
        this.dataValidade = dataValidade;
    }

    public Integer getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }
    
    
    
}
