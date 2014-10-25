/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Cristiano
 */
@Entity
public class Encomenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id

    @ManyToOne
    @JoinColumn(name="ID_FORNECEDOR"-)
    @NotNull
    private Fornecedor fornecedor;
    @OneToMany(mappedBy = "encomenda", cascade = CascadeType.REMOVE)
    @NotNull
    private List<Produto> produtos;
    //será que este estado esta bem?
    private enum estado{Rascunho, Enviado, RecebidoIncompleto, RecebidoCompleto};
    @ManyToMany(mappedBy="encomendas")
    private List<Recepcao> recepcoes;
    @OneToMany (mappedBy = "encomenda", cascade = CascadeType.REMOVE)
    private List<LinhaEncomenda> linhasEncomenda;
    
    @ManyToOne
    @JoinColumn(name="ID_FARMACIA")
    private Farmacia farmacia;

    public Encomenda() {
        this.produtos = new LinkedList<Produto>();
        this.recepcoes = new LinkedList<Recepcao>();
        this.linhasEncomenda = new LinkedList();
    }

    public Encomenda(Fornecedor fornecedor, Farmacia farmacia) {
        this.fornecedor = fornecedor;
        this.produtos = new LinkedList<Produto>();
        this.recepcoes = new LinkedList<Recepcao>();
        this.linhasEncomenda = new LinkedList();
        this.farmacia = farmacia;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
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

    public List<Recepcao> getRecepcoes() {
        return recepcoes;
    }

    public void addRecepcao(Recepcao recepcao) {
        this.recepcoes.add(recepcao);
    }
    
    public void removeRecepcao(Recepcao recepcao) {
        this.recepcoes.remove(recepcao);
    }

    public Farmacia getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }

    
    
    
}
