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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Cristiano
 */
@Entity
public class Recepcao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRecepcao;
    @ManyToMany
    @JoinTable(
            name = "RECEPCAO_ENCOMENDA",
            joinColumns
            = @JoinColumn(name = "RECEPCAO_ID", referencedColumnName = "IDRECEPCAO"),
            inverseJoinColumns
            = @JoinColumn(name = "ENCOMENDA_ID", referencedColumnName = "IDENCOMENDA"-)
    )
    private List<Encomenda> encomendas;
    @OneToMany
    @JoinColumn(name="PRODUTO_ID")
    private List<Produto> produtos;


    public Recepcao() {
        this.encomendas = new LinkedList<>();
        this.produtos = new LinkedList<>();
    }

    public Long getIdRecepcao() {
        return idRecepcao;
    }


    public List<Encomenda> getEncomendas() {
        return encomendas;
    }

    public void addEncomenda(Encomenda encomenda) {
        this.encomendas.add(encomenda);
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



    
}
