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
import javax.persistence.OneToMany;

/**
 *
 * @author Cristiano
 */
@Entity
public class Catalogo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private int referencia;
    
    private Produto produto;
    @OneToMany(cascade=ALL, mappedBy="catalogo")
    private List<Stock> stocks;
    private List<Fornecedor> fornecedores;
    private String nome;
    private String laboratorio;
    private String emailFornEleicao;
    private String emailFornAlternativo;
    private float preco;

    public Catalogo() {
        this.stocks = new ArrayList();
        this.fornecedores = new ArrayList();
    }

    public Catalogo(int referencia, Produto produto, String nome, String laboratorio, String emailFornEleicao, String emailFornAlternativo, float preco) {
        this.referencia = referencia;
        this.produto = produto;
        this.stocks = new ArrayList();
        this.fornecedores = new ArrayList();
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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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
