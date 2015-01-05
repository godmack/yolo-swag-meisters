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
    private String nomeProduto;
    private double preco;

    public StockDTO(int id, int stockActual, int stockMinimo, int produtoCatalogoID, Long farmaciaID, String nomeProduto, double preco) {
        this.id = id;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
        this.catalogo = produtoCatalogoID;
        this.farmacia = farmaciaID;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
    }

    public StockDTO() {
        
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

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    
    
    
    
    public void reiniciar(){
        setCatalogo(0);
        setFarmacia(null);
        setId(0);
        setStockActual(0);
        setStockMinimo(0);
        setNomeProduto("");
    }

}
