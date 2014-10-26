/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Andre
 */
@Entity
@IdClass(LinhaVendaKey.class)
public class LinhaVenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableGenerator(
        name="linhaVendaGen",
        table="PERSISTENCE_ORDER_SEQUENCE_GENERATOR",
        pkColumnName="GEN_KEY",
        valueColumnName="GEN_VALUE",
        pkColumnValue="LINHA_VENDA_ID",
        allocationSize=10)
    @Id
    @ManyToOne
    @JoinColumn(name="ID_VENDA")
    @NotNull
    private Venda venda;
    @Id
    @ManyToOne
    @JoinColumn(name="REFERENCIA_CATALOGO")
    @NotNull
    private Catalogo catalogo;
    @NotNull
    private float preco;
    @NotNull
    private int quantidade;

    public LinhaVenda() {
    }

    public LinhaVenda(Venda venda, Catalogo catalogo, float preco, int quantidade) {
        this.venda = venda;
        this.catalogo = catalogo;
        this.preco = preco;
        this.quantidade = quantidade;
    }


    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
      public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
