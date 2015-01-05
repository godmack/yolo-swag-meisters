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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Cristiano
 */
@Entity
@NamedQueries({
@NamedQuery(name = "findAllStocks", query = "SELECT d FROM Stock d ORDER BY d.farmacia"),
@NamedQuery(name="findExisteStockFarmaciaProduto",query="SELECT le FROM Stock le WHERE (le.farmacia = :farmacia AND le.produtoCatalogo = :produtoCatalogo)"),
@NamedQuery(name="findAllStocksFarmacia",query="SELECT le FROM Stock le WHERE (le.farmacia = :farmacia)")
})

public class Stock implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private int stockActual;
    @NotNull
    private int stockMinimo;
    @ManyToOne
    @JoinColumn(name="REFERENCIA_CATALOGO")
    @NotNull
    private ProdutoCatalogo produtoCatalogo;
    @ManyToOne
    @JoinColumn(name="ID_FARMACIA")
    @NotNull
    private Farmacia farmacia;
    @OneToMany(mappedBy="stock")
    private List<Produto> produtos;

    public Stock() {
        this.produtos = new LinkedList();
    }

    public Stock(int stockActual, int stockMinimo, ProdutoCatalogo produtoCatalogo, Farmacia farmacia) {
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
        this.produtoCatalogo = produtoCatalogo;
        this.farmacia = farmacia;
        this.produtos = new LinkedList();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public ProdutoCatalogo getProdutoCatalogo() {
        return produtoCatalogo;
    }

    public void setProdutoCatalogo(ProdutoCatalogo produtoCatalogo) {
        this.produtoCatalogo = produtoCatalogo;
    }

    public Farmacia getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }
    
}
