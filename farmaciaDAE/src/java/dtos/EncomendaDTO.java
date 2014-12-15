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
    private Fornecedor fornecedor;
    private Estado estado;
    private List<LinhaEncomendaDTO> linhasEncomenda;
    private Farmacia farmacia;
    private Date data;

    public EncomendaDTO() {
        this.linhasEncomenda = new LinkedList();
        estado = Estado.Rascunho;
    }

    public EncomendaDTO(Fornecedor fornecedor, Farmacia farmacia) {
        this.fornecedor = fornecedor;
        this.linhasEncomenda = new LinkedList();
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

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<LinhaEncomendaDTO> getLinhasEncomenda() {
        return linhasEncomenda;
    }

    public void setLinhasEncomenda(List<LinhaEncomendaDTO> linhasEncomenda) {
        this.linhasEncomenda = linhasEncomenda;
    }

    public Farmacia getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    
    
}
