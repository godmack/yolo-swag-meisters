/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import Entidades.Farmacia;
import Entidades.Fornecedor;
import excecoes.EntidadeExistenteException;
import excecoes.EntidadeNaoExistenteException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Ruben
 */
@Singleton
@Startup
public class ConfigBean implements Serializable {
    
    @EJB
    private EncomendaBean encomendaBean;

    @PostConstruct
    public void popularBD() {
        
        try {
            Farmacia farmacia = new Farmacia("rubacia");
            Fornecedor fornecedor = new Fornecedor("ruboratorio", null, 917121212, null);
            encomendaBean.criarEncomenda(fornecedor, farmacia);
        } catch (Exception e) {
        }
        
        
    }
    
}
