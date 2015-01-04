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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cristiano
 */
@Entity
@NamedQuery(name = "findAllFarmacias", query = "SELECT d FROM Farmacia d ORDER BY d.nome")
@XmlRootElement
public class Farmacia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFarmacia;
    
    private String nome;
    @OneToMany(cascade=ALL, mappedBy="farmacia")
    private List<Produto> produtos;
    @OneToMany(cascade=ALL, mappedBy="farmacia")
    private List<Utilizador> utilizadores;
    @OneToMany(cascade=ALL, mappedBy="farmacia")
    private List<Funcionario> funcionarios;
    @OneToMany(cascade=ALL, mappedBy="farmacia")
    private List<Venda> vendas;
    @OneToMany(cascade=ALL, mappedBy="farmacia")
    private List<Encomenda> encomendas;
    @OneToMany(cascade=ALL, mappedBy="farmacia")
    private List<Stock> stocks;
    @ManyToMany(mappedBy="farmacias")
    private List<Fornecedor> fornecedores;
    
    @OneToMany(cascade = ALL, mappedBy = "farmacia")
    private List<Transferencia> transferenciasEnviadas;
    
    @OneToMany(cascade = ALL, mappedBy = "farmaciaFornecedora")
    private List<Transferencia> transferenciasRecebidas;
    
    

    public Farmacia() {
        this.produtos = new LinkedList();
        this.utilizadores = new LinkedList();
        this.vendas = new LinkedList();
        this.encomendas = new LinkedList();
        this.stocks = new LinkedList();
        this.fornecedores = new LinkedList();
        this.transferenciasEnviadas = new LinkedList();
        this.transferenciasRecebidas = new LinkedList();
    }

    public Farmacia(String nome) {
        this.nome = nome;
        this.produtos = new LinkedList();
        this.utilizadores = new LinkedList();
        this.vendas = new LinkedList();
        this.encomendas = new LinkedList();
        this.stocks = new LinkedList();
        this.fornecedores = new LinkedList();
        this.transferenciasEnviadas = new LinkedList();
        this.transferenciasRecebidas = new LinkedList();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<Transferencia> getTransferenciasEnviadas() {
        return transferenciasEnviadas;
    }
    


    public void addTransferenciaEnviada(Transferencia transferencia) {
        this.transferenciasEnviadas.add(transferencia);
    }
    
    public void removeTransferenciaEnviada(Transferencia transferencia) {
        this.transferenciasEnviadas.remove(transferencia);
    }
    
    

    @XmlTransient
    public List<Transferencia> getTransferenciasRecebidas() {
        return transferenciasRecebidas;
    }

     public void addTransferenciaRecebida(Transferencia transferencia) {
        this.transferenciasRecebidas.add(transferencia);
    }
    
    public void removeTransferenciaRecebida(Transferencia transferencia) {
        this.transferenciasRecebidas.remove(transferencia);
    }

    
    

    public Long getIdFarmacia() {
        return idFarmacia;
    }

    @XmlTransient
    public List<Produto> getProdutos() {
        return produtos;
    }

    public void addProduto(Produto produto) {
        this.produtos.add(produto);
    }
    
    public void removeProduto(Produto produto) {
        this.produtos.remove(produto);
    }

    @XmlTransient
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

    @XmlTransient
    public List<Venda> getVendas() {
        return vendas;
    }

    public void addVenda(Venda venda) {
        this.vendas.add(venda);
    }
    
    public void removeVenda(Venda venda) {
        this.vendas.remove(venda);
    }

    @XmlTransient
    public List<Encomenda> getEncomendas() {
        return encomendas;
    }

    public void addEncomenda(Encomenda encomenda) {
        this.encomendas.add(encomenda);
    }
    
    public void removeEncomenda(Encomenda encomenda) {
        this.encomendas.remove(encomenda);
    }

    @XmlTransient
    public List<Stock> getStocks() {
        return stocks;
    }

    public void addStock(Stock stock) {
        this.stocks.add(stock);
    }
    
    public void removeStock(Stock stock) {
        this.stocks.remove(stock);
    }

    @XmlTransient
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
