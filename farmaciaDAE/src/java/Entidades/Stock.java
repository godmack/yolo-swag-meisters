/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Cristiano
 */
@Entity
public class Stock implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    
    @NotNull
    private int id;
    @NotNull
    private int stockActual;
    @NotNull
    private int stockMinimo;
    @ManyToOne
    @JoinColumn(name="REFERENCIA_CATALOGO")
    @NotNull
    private Catalogo catalogo;
    @ManyToOne
    @JoinColumn(name="ID_FARMACIA")
    @NotNull
    private Farmacia farmacia;

    public Stock() {
    }

    public Stock(int id, int stockActual, int stockMinimo, Catalogo catalogo, Farmacia farmacia) {
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

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public Farmacia getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }
    
}
