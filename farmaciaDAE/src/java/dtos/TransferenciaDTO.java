/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import Entidades.Estado;
import Entidades.Farmacia;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Ruben
 */
public class TransferenciaDTO implements Serializable{
    private Long idTransferencia;
    private Long farmacia;
    private Long farmaciaFornecedora;
    private Estado estado;
    private Date data;
    

    public TransferenciaDTO() {
    }
    
    public TransferenciaDTO(Long idTransferencia, Long farmaciaID, Long farmaciaFornecedoraID, Estado estado, Date data) {
        this.idTransferencia = idTransferencia;
        this.farmacia = farmaciaID;
        this.farmaciaFornecedora = farmaciaFornecedoraID;
        this.estado = estado;
        this.data = data;
    }

    public Long getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Long farmacia) {
        this.farmacia = farmacia;
    }

    public Long getFarmaciaFornecedora() {
        return farmaciaFornecedora;
    }

    public void setFarmaciaFornecedora(Long farmaciaFornecedora) {
        this.farmaciaFornecedora = farmaciaFornecedora;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Long getIdTransferencia() {
        return idTransferencia;
    }

    public void setIdTransferencia(Long idTransferencia) {
        this.idTransferencia = idTransferencia;
    }
    
    
    
    public void reiniciar(){
        this.setIdTransferencia(null);
        this.setFarmacia(null);
        this.setFarmaciaFornecedora(null);
        this.setEstado(null);
        this.setData(null);
    }
    
    
    
}
