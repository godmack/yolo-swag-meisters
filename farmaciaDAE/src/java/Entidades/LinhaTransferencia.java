/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Andre
 */
@Entity
@NamedQueries({
@NamedQuery(name = "findAllLinhasTransferencia", query = "SELECT d FROM LinhaTransferencia d"),
@NamedQuery(name="findExisteLinhaTransferenciaProduto",query="SELECT le FROM LinhaTransferencia le WHERE (le.transferencia = :transferencia AND le.produtoCatalogo = :produtoCatalogo)")
})

@IdClass(LinhaTransferenciaKey.class)
public class LinhaTransferencia extends Linhas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @ManyToOne
    @JoinColumn(name="ID_TRANSFENCIA")
    @NotNull
    private Transferencia transferencia;
    private int quantidadeRecebida;
    
    public LinhaTransferencia() {
    }

    public LinhaTransferencia(Transferencia transferencia, ProdutoCatalogo catalogo, int quantidade) {
        super(catalogo,quantidade);
        this.transferencia = transferencia;
        this.quantidadeRecebida = 0;
    }


    public Transferencia getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(Transferencia transferencia) {
        this.transferencia = transferencia;
    }

    
    

    
}
