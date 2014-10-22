/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Cristiano
 */
@Entity
public class Catalogo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    
    private Produto produto;
    private List<Stock> stocks;
    private List<Fornecedor> fornecedores;

    public Catalogo() {
    }

    public Catalogo(Produto produto, List<Stock> stocks, List<Fornecedor> fornecedores) {
        this.produto = produto;
        this.stocks = stocks;
        this.fornecedores = fornecedores;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(List<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }


    
}
