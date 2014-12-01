/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;
import javax.validation.constraints.NotNull;


/**
 *
 * @author Cristiano
 */
@Entity
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @TableGenerator(
        name="produtoGen",
        table="PERSISTENCE_ORDER_SEQUENCE_GENERATOR",
        pkColumnName="GEN_KEY",
        valueColumnName="GEN_VALUE",
        pkColumnValue="PRODUTO_ID",
        allocationSize=10)
    @GeneratedValue(strategy=GenerationType.TABLE, generator="produtoGen")
    private Long idProduto;

    @NotNull
    private int lote;
    @Temporal(DATE)
    @NotNull
    private Date dataValidade;
    @ManyToOne
    @JoinColumn(name = "REFERENCIA_CATALOGO")
    private ProdutoCatalogo catalogo;
    @ManyToOne
    @JoinColumn(name = "ID_FARMACIA")
    private Farmacia farmacia;
    @ManyToOne
    @JoinColumn(name = "ID_STOCK")
    private Stock stock;

    public Produto(){
        
    }

    public Produto(int lote, Date dataValidade) {
        this.lote = lote;
        this.dataValidade = dataValidade;
    }

    public Long getIdProduto() {
        return idProduto;
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


    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
    

    
    
    
}
