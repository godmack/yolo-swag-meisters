package dtos;

import java.io.Serializable;

public class LinhaVendaDTO  implements Serializable{

    private int codigoProdutoCatalogo;
    private Long codigoVenda;
    private int quantidade;
    private double preco;
    

    public LinhaVendaDTO() {
    }    
    
    public LinhaVendaDTO(int codigoProdutoCatalogo, Long codigoVenda, int quantidade, double preco) {
        this.codigoProdutoCatalogo = codigoProdutoCatalogo;     
        this.codigoVenda = codigoVenda;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public int getCodigoProdutoCatalogo() {
        return codigoProdutoCatalogo;
    }

    public void setCodigoProdutoCatalogo(int codigoProdutoCatalogo) {
        this.codigoProdutoCatalogo = codigoProdutoCatalogo;
    }

    public Long getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(Long codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

   
  
    

}
