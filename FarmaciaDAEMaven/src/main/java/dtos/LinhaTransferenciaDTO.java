package dtos;

import java.io.Serializable;

public class LinhaTransferenciaDTO  implements Serializable{

    private int codigoProdutoCatalogo;
    private Long codigoTransferencia;
    private int quantidade;
    

    public LinhaTransferenciaDTO() {
    }    
    
    public LinhaTransferenciaDTO(int codigoProdutoCatalogo, Long codigoTransferencia, int quantidade) {
        this.codigoProdutoCatalogo = codigoProdutoCatalogo;     
        this.codigoTransferencia = codigoTransferencia;
        this.quantidade = quantidade;
    }

    public int getCodigoProdutoCatalogo() {
        return codigoProdutoCatalogo;
    }

    public void setCodigoProdutoCatalogo(int codigoProdutoCatalogo) {
        this.codigoProdutoCatalogo = codigoProdutoCatalogo;
    }

    public Long getCodigoTransferencia() {
        return codigoTransferencia;
    }

    public void setCodigoTransferencia(Long codigoTransferencia) {
        this.codigoTransferencia = codigoTransferencia;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
  
    

}
