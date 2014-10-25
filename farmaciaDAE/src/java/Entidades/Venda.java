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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Cristiano
 */
@Entity
public class Venda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    
    private Produto produto;
    @ManyToOne
    @JoinColumn(name="_CLIENTE"-)
    private Cliente cliente;
    private float preco;
    @OneToMany(mappedBy="vendas")
    private Farmacia farmacia;
    @ManyToOne
    @JoinColumn(name="ID_LINHAVENDA")
    private List<LinhaVenda> linhasVenda;

    public Venda() {
    }

    public Venda(Produto produto, Cliente cliente, float preco, Farmacia farmacia) {
        this.produto = produto;
        this.cliente = cliente;
        this.preco = preco;
        this.farmacia = farmacia;
        this.linhasVenda = new LinkedList();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Farmacia getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }

    public List<LinhaVenda> getLinhasVenda() {
        return linhasVenda;
    }

    public void addLinhaVenda(LinhaVenda linhaVenda) {
        this.linhasVenda.add(linhaVenda);
    }
    
     public void removeLinhaVenda(LinhaVenda linhaVenda) {
        this.linhasVenda.remove(linhaVenda);
    }

    
  
    
    
    
}
