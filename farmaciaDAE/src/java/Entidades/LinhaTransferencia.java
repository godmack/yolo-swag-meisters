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
public class LinhaTransferencia extends Linhas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @ManyToOne
    @JoinColumn(name="ID_TRANSFENCIA")
    @NotNull
    private Transferencia transferencia;

    public LinhaTransferencia() {
    }

    public LinhaTransferencia(Transferencia transferencia, Catalogo catalogo, int quantidade) {
        super(catalogo,quantidade);
        this.transferencia = transferencia;
    }


    public Transferencia getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(Transferencia transferencia) {
        this.transferencia = transferencia;
    }

    
    

    
}
