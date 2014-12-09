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
    Farmacia farmacia;
    Farmacia farmaciaFornecedora;

    public TransferenciaDTO(Farmacia farmacia, Farmacia farmaciaFornecedora) {
        this.farmacia = farmacia;
        this.farmaciaFornecedora = farmaciaFornecedora;
    }

    public Farmacia getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }

    public Farmacia getFarmaciaFornecedora() {
        return farmaciaFornecedora;
    }

    public void setFarmaciaFornecedora(Farmacia farmaciaFornecedora) {
        this.farmaciaFornecedora = farmaciaFornecedora;
    }
    
    
    
}
