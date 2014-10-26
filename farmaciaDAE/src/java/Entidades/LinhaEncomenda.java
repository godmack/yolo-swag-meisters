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
import javax.validation.constraints.NotNull;

/**
 *
 * @author Andre
 */
@IdClass(LinhaEncomendaKey.class)
@Entity
public class LinhaEncomenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @ManyToOne
    @JoinColumn(name="ID_ENCOMENDA")
    @NotNull
    private Encomenda encomenda;
    @Id
    @ManyToOne
    @JoinColumn(name="REFERENCIA_CATALOGO")
    @NotNull
    private Catalogo catalogo;
    @NotNull
    private int quantidade;

    public LinhaEncomenda() {
    }

    public LinhaEncomenda(Encomenda encomenda, Catalogo catalogo, int quantidade) {
        this.encomenda = encomenda;
        this.catalogo = catalogo;
        this.quantidade = quantidade;
    }

    

    public Encomenda getEncomenda() {
        return encomenda;
    }

    public void setEncomenda(Encomenda encomenda) {
        this.encomenda = encomenda;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    

    
}
