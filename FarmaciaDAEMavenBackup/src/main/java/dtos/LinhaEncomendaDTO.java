package dtos;

import java.io.Serializable;

public class LinhaEncomendaDTO  implements Serializable{

    private int codigoProdutoCatalogo;
    private Long codigoEncomenda;
    private int quantidade;
    

    public LinhaEncomendaDTO() {
    }    
    
    public LinhaEncomendaDTO(int codigoProdutoCatalogo, Long codigoEncomenda, int quantidade) {
        this.codigoProdutoCatalogo = codigoProdutoCatalogo;     
        this.codigoEncomenda = codigoEncomenda;
        this.quantidade = quantidade;
    }

    public int getCodigoProdutoCatalogo() {
        return codigoProdutoCatalogo;
    }

    public void setCodigoProdutoCatalogo(int codigoProdutoCatalogo) {
        this.codigoProdutoCatalogo = codigoProdutoCatalogo;
    }

    public Long getCodigoEncomenda() {
        return codigoEncomenda;
    }

    public void setCodigoEncomenda(Long codigoEncomenda) {
        this.codigoEncomenda = codigoEncomenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
  
    

}
