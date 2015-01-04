/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cristiano
 */
@Entity
@NamedQuery(name = "findAllProdutoCatalogos", query = "SELECT d FROM ProdutoCatalogo d ORDER BY d.nome")
@XmlRootElement
public class ProdutoCatalogo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    private int referencia;
    @OneToMany(cascade = ALL, mappedBy = "produtoCatalogo")
    private List<Produto> produtos;
    @OneToMany(cascade=ALL, mappedBy="produtoCatalogo")
    private List<Stock> stocks;
    
    @ManyToMany(mappedBy = "produtosCatalogo")
    private List<Fornecedor> fornecedores;
    @NotNull
    private String nome;
    @NotNull
    private String laboratorio;
    private String emailFornEleicao;
    private String emailFornAlternativo;
    @NotNull
    private Double preco;

    public ProdutoCatalogo() {
        this.stocks = new ArrayList();
        this.fornecedores = new ArrayList();
    }

    public ProdutoCatalogo(int referencia, String nome, String laboratorio, Double preco) {
        this.referencia = referencia;
        this.produtos = new ArrayList();
        this.stocks = new ArrayList();
        this.fornecedores = new ArrayList();
        this.nome = nome;
        this.laboratorio = laboratorio;
        this.preco = preco;
    }



    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    @XmlTransient
    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void addProdutos(Produto produtos) {
        this.produtos.add(produtos);
    }
    
    public void removeProdutos(Produto produtos) {
        this.produtos.remove(produtos);
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

    public void addFornecedores(Fornecedor fornecedor) {
        this.fornecedores.add(fornecedor);
    }
    
    public void removeFornecedores(Fornecedor fornecedor) {
        this.fornecedores.remove(fornecedor);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getEmailFornEleicao() {
        return emailFornEleicao;
    }

    public void setEmailFornEleicao(String emailFornEleicao) {
        this.emailFornEleicao = emailFornEleicao;
    }

    public String getEmailFornAlternativo() {
        return emailFornAlternativo;
    }

    public void setEmailFornAlternativo(String emailFornAlternativo) {
        this.emailFornAlternativo = emailFornAlternativo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

   


    
}
