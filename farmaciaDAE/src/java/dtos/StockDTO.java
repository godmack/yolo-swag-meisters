/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import Entidades.Farmacia;
import Entidades.ProdutoCatalogo;
import java.io.Serializable;

/**
 *
 * @author Ruben
 */
public class StockDTO implements Serializable {

    private int id;
    private int stockActual;
    private int stockMinimo;
    private ProdutoCatalogo catalogo;
    private Farmacia farmacia;

    public StockDTO(int id, int stockActual, int stockMinimo, ProdutoCatalogo catalogo, Farmacia farmacia) {
        this.id = id;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
        this.catalogo = catalogo;
        this.farmacia = farmacia;
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

    public ProdutoCatalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(ProdutoCatalogo catalogo) {
        this.catalogo = catalogo;
    }

    public Farmacia getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }

}
