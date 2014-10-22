/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Cristiano
 */
@Entity
public class Stock implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    
    private int id;
    private int stockActual;
    private int stockMinimo;

    public Stock() {
    }

    public Stock(int id, int stockActual, int stockMinimo) {
        this.id = id;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
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
    
}
