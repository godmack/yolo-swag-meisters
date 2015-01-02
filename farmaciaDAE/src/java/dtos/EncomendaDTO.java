package dtos;

import Entidades.Estado;
import Entidades.Farmacia;
import Entidades.Fornecedor;
import Entidades.LinhaEncomenda;
import Entidades.Venda;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class EncomendaDTO  implements Serializable{

    private Long idEncomenda;
    private Long fornecedor;
    private Estado estado;
    private int farmacia;
    private Date data;

    public EncomendaDTO() {
        estado = Estado.Rascunho;
    }

    public EncomendaDTO(String fornecedorID, Long farmaciaID) {
        this.fornecedor = fornecedor;
        this.farmacia = farmacia;
        estado = Estado.Rascunho;
        this.data = new Date();
    }

    public Long getIdEncomenda() {
        return idEncomenda;
    }

    public void setIdEncomenda(Long idEncomenda) {
        this.idEncomenda = idEncomenda;
    }

    public Long getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Long fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }


    public int getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(int farmacia) {
        this.farmacia = farmacia;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    
    
}
