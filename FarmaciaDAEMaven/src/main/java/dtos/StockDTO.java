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
    private int catalogo;
    private Long farmacia;

    public StockDTO(int id, int stockActual, int stockMinimo, int produtoCatalogoID, Long farmaciaCatalogoID) {
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

    public int getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(int catalogo) {
        this.catalogo = catalogo;
    }

    public Long getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Long farmacia) {
        this.farmacia = farmacia;
    }

}
