/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import Entidades.Farmacia;
import java.io.Serializable;

/**
 *
 * @author Ruben
 */
public class TransferenciaDTO implements Serializable{
    Long farmacia;
    Long farmaciaFornecedora;

    public TransferenciaDTO(Long farmaciaID, Long farmaciaFornecedoraID) {
        this.farmacia = farmacia;
        this.farmaciaFornecedora = farmaciaFornecedora;
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
    
    
    
}
