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
 * @author Andre
 */
@Entity
public class LinhaEncomenda extends Linhas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @ManyToOne
    @JoinColumn(name="ID_ENCOMENDA")
    @NotNull
    private Encomenda encomenda;
<<<<<<< .mine
    @ManyToOne
    @JoinColumn(name="REFERENCIA_CATALOGO")
    @NotNull
    private ProdutoCatalogo catalogo;
    @NotNull
    private int quantidade;
=======
    
    private int quantidadeRecebida;
>>>>>>> .r28

    public LinhaEncomenda() {
    }

    public LinhaEncomenda(Encomenda encomenda, ProdutoCatalogo catalogo, int quantidade) {
        super(catalogo, quantidade);
        this.encomenda = encomenda;
        this.quantidadeRecebida = 0;

    }

    

    public Encomenda getEncomenda() {
        return encomenda;
    }

    public void setEncomenda(Encomenda encomenda) {
        this.encomenda = encomenda;
    }

<<<<<<< .mine
    public ProdutoCatalogo getCatalogo() {
        return catalogo;
=======
    public int getQuantidadeRecebida() {
        return quantidadeRecebida;
>>>>>>> .r28
    }

<<<<<<< .mine
    public void setCatalogo(ProdutoCatalogo catalogo) {
        this.catalogo = catalogo;
=======
    public void setQuantidadeRecebida(int quantidadeRecebida) {
        this.quantidadeRecebida = quantidadeRecebida;
>>>>>>> .r28
    }


    
    

    
}
