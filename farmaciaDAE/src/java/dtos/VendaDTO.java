package dtos;

import Entidades.Venda;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class VendaDTO  implements Serializable{

    private Long idVenda;
    private ClienteDTO cliente;
    private FarmaciaDTO farmacia;
    private List<LinhaVendaDTO> linhasVenda;
    private Date data;
        
    public VendaDTO() {
    }

    public VendaDTO(ClienteDTO cliente, FarmaciaDTO farmacia) {
        this.cliente = cliente;
        this.farmacia = farmacia;
        this.linhasVenda = new LinkedList();
        this.data = new Date();
    }

    public Long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Long idVenda) {
        this.idVenda = idVenda;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public FarmaciaDTO getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(FarmaciaDTO farmacia) {
        this.farmacia = farmacia;
    }

    public List<LinhaVendaDTO> getLinhasVenda() {
        return linhasVenda;
    }

    public void setLinhasVenda(List<LinhaVendaDTO> linhasVenda) {
        this.linhasVenda = linhasVenda;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
    
}
