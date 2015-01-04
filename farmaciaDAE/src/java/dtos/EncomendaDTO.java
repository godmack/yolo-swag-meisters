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
    private String fornecedor;

    private Estado estado;

    private Long farmacia;

    private Date data;

    public EncomendaDTO() {

    }

    public EncomendaDTO(Long idEncomenda, String fornecedorID, Long farmaciaID, Estado estado) {
        
        this.idEncomenda = idEncomenda;
        this.fornecedor = fornecedorID;
        this.farmacia = farmaciaID;
        this.estado = estado;
        this.data = new Date();
    }

    public Long getIdEncomenda() {
        return idEncomenda;
    }

    public void setIdEncomenda(Long idEncomenda) {
        this.idEncomenda = idEncomenda;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }



    public Long getFarmacia() {
        return farmacia;
    }


    public void setFarmacia(Long farmacia) {
        this.farmacia = farmacia;

    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void reiniciar(){
        this.setData(null);
        this.setEstado(null);
        this.setFarmacia(null);
        this.setFornecedor(null);
        this.setIdEncomenda(null);
    }

    
    
}
