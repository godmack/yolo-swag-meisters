package dtos;

import Entidades.Venda;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class VendaDTO  implements Serializable{

    private Long idVenda;
    private int cliente;
    private Long farmacia;
    private List<LinhaVendaDTO> linhasVenda;
    private Date data;
        
    public VendaDTO() {
    }

    public VendaDTO(int clienteID, Long farmaciaID) {
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

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public Long getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Long farmacia) {
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
    
    public void reiniciar(){
        this.setCliente(0);
        this.setFarmacia(null);
        this.setLinhasVenda(null);
        this.setData(null);
        this.setIdVenda(null);
        
    }
    
    
    
}
