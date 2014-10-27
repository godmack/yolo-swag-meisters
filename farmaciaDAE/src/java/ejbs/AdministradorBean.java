/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Cristiano
 */
@Stateless
public class AdministradorBean {
    @PersistenceContext (name="farmaciaDAEPU")
    private EntityManager em;

    public AdministradorBean() {
    }
        
    public AdministradorBean(EntityManager em) {
        this.em = em;
    }
    
    public void criarAdministrador(){
        
    }
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
