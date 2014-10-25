/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Cristiano
 */
@Entity
public class Farmacia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    Long id;
    
    @OneToMany(cascade=ALL, mappedBy="farmacia")
    private List<Produto> produtos;
    @OneToMany(cascade=ALL, mappedBy="farmacia")
    private List<Utilizador> utilizadores;
    @OneToMany(cascade=ALL, mappedBy="farmacia")
    private List<Venda> vendas;
    @OneToMany(cascade=ALL, mappedBy="farmacia")
    private List<Encomenda> encomendas;
    @OneToMany(cascade=ALL, mappedBy="farmacia")
    private List<Stock> stocks;
    @ManyToMany(mappedBy="farmacias")
    private List<Fornecedor> fornecedores;

    public Farmacia() {
        this.produtos = new LinkedList();
        this.utilizadores = new LinkedList();
        this.vendas = new LinkedList();
        this.encomendas = new LinkedList();
        this.stocks = new LinkedList();
        this.fornecedores = new LinkedList();
    }

    public Farmacia(long id) {
        this.id = id;
        this.produtos = new LinkedList();
        this.utilizadores = new LinkedList();
        this.vendas = new LinkedList();
        this.encomendas = new LinkedList();
        this.stocks = new LinkedList();
        this.fornecedores = new LinkedList();
    }

    public Long getId() {
        return id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void addProduto(Produto produto) {
        this.produtos.add(produto);
    }
    
    public void removeProduto(Produto produto) {
        this.produtos.remove(produto);
    }

    public List<Utilizador> getUtilizadores() {
        return utilizadores;
    }

    public void setUtilizadores(List<Utilizador> utilizadores) {
        this.utilizadores = utilizadores;
    }
    
     public void addUtilizador(Utilizador utilizador) {
        this.utilizadores.add(utilizador);
    }
    
    public void removeUtilizador(Utilizador utilizador) {
        this.utilizadores.remove(utilizador);
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void addVenda(Venda venda) {
        this.vendas.add(venda);
    }
    
    public void removeVenda(Venda venda) {
        this.vendas.remove(venda);
    }

    public List<Encomenda> getEncomendas() {
        return encomendas;
    }

    public void addEncomenda(Encomenda encomenda) {
        this.encomendas.add(encomenda);
    }
    
    public void removeEncomenda(Encomenda encomenda) {
        this.encomendas.remove(encomenda);
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void addStock(Stock stock) {
        this.stocks.add(stock);
    }
    
    public void removeStock(Stock stock) {
        this.stocks.remove(stock);
    }

    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public void addFornecedor(Fornecedor fornecedor) {
        this.fornecedores.add(fornecedor);
    }
    
     public void removeFornecedor(Fornecedor fornecedor) {
        this.fornecedores.remove(fornecedor);
    }

    
    
}
