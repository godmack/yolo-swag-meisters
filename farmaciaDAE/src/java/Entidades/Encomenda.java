/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Cristiano
 */
@Entity
public class Encomenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableGenerator(
        name="encomendaGen",
        table="PERSISTENCE_ORDER_SEQUENCE_GENERATOR",
        pkColumnName="GEN_KEY",
        valueColumnName="GEN_VALUE",
        pkColumnValue="ENCOMENDA_ID",
        allocationSize=10)
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="encomendaGen")
    private Long idEncomenda;

    @ManyToOne
    @JoinColumn(name="ID_FORNECEDOR")
    @NotNull
    private Fornecedor fornecedor;
    private Estado estado;

    @OneToMany (mappedBy = "encomenda", cascade = CascadeType.REMOVE)
    private List<LinhaEncomenda> linhasEncomenda;
    
    @ManyToOne
    @JoinColumn(name="ID_FARMACIA")
    private Farmacia farmacia;
    
    @Temporal(DATE)
    private Date data;

    public Encomenda() {
        this.linhasEncomenda = new LinkedList();
        estado = Estado.Rascunho;
    }

    public Encomenda(Fornecedor fornecedor, Farmacia farmacia) {
        this.fornecedor = fornecedor;
        this.linhasEncomenda = new LinkedList();
        this.farmacia = farmacia;
        estado = Estado.Rascunho;
        this.data = new Date();
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Farmacia getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }

    
    
    
}
