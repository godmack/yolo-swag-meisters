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
public class Farmacia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    
    private List<Produto> produtos;
    private List<Utilizador> utilizadores;
    private List<Venda> vendas;
    private List<Encomenda> encomendas;
    private List<Stock> stocks;
    private List<Fornecedor> fornecedores;

    public Farmacia() {
    }

    public Farmacia(List<Produto> produtos, List<Utilizador> utilizadores, List<Venda> vendas, List<Encomenda> encomendas, List<Stock> stocks, List<Fornecedor> fornecedores) {
        this.produtos = produtos;
        this.utilizadores = utilizadores;
        this.vendas = vendas;
        this.encomendas = encomendas;
        this.stocks = stocks;
        this.fornecedores = fornecedores;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Utilizador> getUtilizadores() {
        return utilizadores;
    }

    public void setUtilizadores(List<Utilizador> utilizadores) {
        this.utilizadores = utilizadores;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public List<Encomenda> getEncomendas() {
        return encomendas;
    }

    public void setEncomendas(List<Encomenda> encomendas) {
        this.encomendas = encomendas;
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
