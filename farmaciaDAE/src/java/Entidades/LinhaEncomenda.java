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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andre
 */

//WHERE (le.encomenda = :encomenda AND le.produtoCatalogo = :produtoCatalogo)
@Entity
@IdClass(LinhaEncomendaKey.class)
@NamedQueries({
@NamedQuery(name = "findExistentEncomenda", query = "SELECT le FROM LinhaEncomenda le "),
@NamedQuery(name="findAllLinhasEncomendaDeUmaEncomenda",query="SELECT le FROM LinhaEncomenda le WHERE le.encomenda = :encomenda"),
@NamedQuery(name="findExisteLinhaEncomendaProduto",query="SELECT le FROM LinhaEncomenda le WHERE (le.encomenda = :encomenda AND le.produtoCatalogo = :produtoCatalogo)")
})
@XmlRootElement
public class LinhaEncomenda extends Linhas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @ManyToOne
    @JoinColumn(name="ID_ENCOMENDA")
    @NotNull
    private Encomenda encomenda;
    
    private int quantidadeRecebida;

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

    public int getQuantidadeRecebida() {
        return quantidadeRecebida;
    }

    public void setQuantidadeRecebida(int quantidadeRecebida) {
        this.quantidadeRecebida = quantidadeRecebida;
    }


    
    

    
}
