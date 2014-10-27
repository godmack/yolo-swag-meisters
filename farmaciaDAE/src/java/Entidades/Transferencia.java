/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Cristiano
 */
@Entity
public class Transferencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableGenerator(
        name="transferenciaGen",
        table="PERSISTENCE_ORDER_SEQUENCE_GENERATOR",
        pkColumnName="GEN_KEY",
        valueColumnName="GEN_VALUE",
        pkColumnValue="TRANSFERENCIA_ID",
        allocationSize=10)
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="transferenciaGen")
    private Long idTransferencia;

    @ManyToOne
    @JoinColumn(name="ID_FARMACIA_FORNECEDORA")
    @NotNull
    private Farmacia farmaciaFornecedora;
    
    private Estado estado;

    @OneToMany (mappedBy = "transferencia", cascade = CascadeType.REMOVE)
    private List<LinhaTransferencia> linhasTransferencia;
    
    @ManyToOne
    @JoinColumn(name="ID_FARMACIA")
    private Farmacia farmacia;

    public Transferencia() {
        this.linhasTransferencia = new LinkedList();
        estado = Estado.Rascunho;
    }

    public Transferencia(Farmacia farmaciaFornecedora, Farmacia farmacia) {
        this.farmaciaFornecedora = farmacia;
        this.linhasTransferencia = new LinkedList();
        this.farmacia = farmacia;
        estado = Estado.Rascunho;
    }

    public Farmacia getFornecedor() {
        return farmaciaFornecedora;
    }

    public void setFornecedor(Farmacia farmaciaFornecedora) {
        this.farmaciaFornecedora = farmaciaFornecedora;
    }

    public Farmacia getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }

    public Long getIdTransferencia() {
        return idTransferencia;
    }

    
    
    
}
