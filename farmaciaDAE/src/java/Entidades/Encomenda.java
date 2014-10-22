/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Cristiano
 */
@Entity
public class Encomenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id

    private Fornecedor fornecedor;
    private List<Produto> produtos;
    private enum estado{Rascunho, Enviado, RecebidoIncompleto, RecebidoCompleto};
    private List<Recepcao> recepcoes;
    private List<LinhaEncomenda> linhasEncomenda;

    public Encomenda() {
        this.produtos = new LinkedList<Produto>();
        this.recepcoes = new LinkedList<Recepcao>();
        this.linhasEncomenda = new LinkedList();
    }

    public Encomenda(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
        this.produtos = new LinkedList<Produto>();
        this.recepcoes = new LinkedList<Recepcao>();
        this.linhasEncomenda = new LinkedList();
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

    
    
    
}
