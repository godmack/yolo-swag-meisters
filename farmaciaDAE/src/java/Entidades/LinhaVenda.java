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
public class LinhaVenda extends Linhas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @ManyToOne
    @JoinColumn(name="ID_VENDA")
    @NotNull
    private Venda venda;
    @NotNull
<<<<<<< .mine
    private ProdutoCatalogo catalogo;
    @NotNull
=======
>>>>>>> .r28
    private float preco;

    public LinhaVenda() {
    }

    public LinhaVenda(Venda venda, ProdutoCatalogo catalogo, float preco, int quantidade) {
        super(catalogo, quantidade);
        this.venda = venda;
        this.preco = preco;
    }


    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

<<<<<<< .mine
    public ProdutoCatalogo getCatalogo() {
        return catalogo;
    }
=======
>>>>>>> .r28

<<<<<<< .mine
    public void setCatalogo(ProdutoCatalogo catalogo) {
        this.catalogo = catalogo;
    }

=======
>>>>>>> .r28
    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    


}
