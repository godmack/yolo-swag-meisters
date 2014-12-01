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
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Cristiano
 */
@Entity
public class ProdutoCatalogo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    private int referencia;
    @OneToMany(cascade = ALL, mappedBy = "catalogo")
    private List<Produto> produtos;
    @OneToMany(cascade=ALL, mappedBy="catalogo")
    @NotNull
    private List<Stock> stocks;
    
    @ManyToMany(mappedBy = "catalogos")
    private List<Fornecedor> fornecedores;
    @NotNull
    private String nome;
    @NotNull
    private String laboratorio;
    @NotNull
    private String emailFornEleicao;
    @NotNull
    private String emailFornAlternativo;
    @NotNull
    private float preco;

    public ProdutoCatalogo() {
        this.stocks = new ArrayList();
        this.fornecedores = new ArrayList();
    }

    public ProdutoCatalogo(int referencia, List<Produto> produtos, List<Stock> stocks, List<Fornecedor> fornecedores, String nome, String laboratorio, String emailFornEleicao, String emailFornAlternativo, float preco) {
        this.referencia = referencia;
        this.produtos = produtos;
        this.stocks = stocks;
        this.fornecedores = fornecedores;
        this.nome = nome;
        this.laboratorio = laboratorio;
        this.emailFornEleicao = emailFornEleicao;
        this.emailFornAlternativo = emailFornAlternativo;
        this.preco = preco;
    }



    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

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

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

   


    
}