/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;


/**
 *
 * @author Cristiano
 */
@Entity
@NamedQuery(name = "findAllVendas", query = "SELECT d FROM Venda d")
public class Venda implements Serializable {
    private static final long serialVersionUID = 1L;
        @TableGenerator(
        name="vendaGen",
        table="PERSISTENCE_ORDER_SEQUENCE_GENERATOR",
        pkColumnName="GEN_KEY",
        valueColumnName="GEN_VALUE",
        pkColumnValue="VENDA_ID",
        allocationSize=10)
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="vendaGen")
    private Long idVenda;
    
    @ManyToOne
    @JoinColumn(name="CONTATO_CLIENTE")
    private Cliente cliente;
    @NotNull
    @ManyToOne
    @JoinColumn(name="ID_FARMACIA")
    private Farmacia farmacia;
    @NotNull
    @OneToMany(mappedBy="venda")
    private List<LinhaVenda> linhasVenda;

    @Temporal(DATE)
    private Date data;
    
    private Estado estado;
        
    public Venda() {
        this.linhasVenda = new ArrayList();
    }

    public Venda(Cliente cliente, Farmacia farmacia) {
        this.cliente = cliente;
        this.farmacia = farmacia;
        this.linhasVenda = new ArrayList();
        this.data = new Date();
        this.estado = Estado.Rascunho;
    }
    
     public Long getIdVenda() {
        return idVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Farmacia getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }

    public List<LinhaVenda> getLinhasVenda() {
        return linhasVenda;
    }

    public void addLinhaVenda(LinhaVenda linhaVenda) {
        this.linhasVenda.add(linhaVenda);
    }
    
     public void removeLinhaVenda(LinhaVenda linhaVenda) {
        this.linhasVenda.remove(linhaVenda);
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

     
    
  
    
    
    
}
