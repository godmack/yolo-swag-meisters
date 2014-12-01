/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import Entidades.Utilizador;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Cristiano
 */
@Stateless
public class UtilizadorBean {
    @PersistenceContext (name="farmaciaDAEPU")
    private EntityManager em;

    public UtilizadorBean() {
    }

    public UtilizadorBean(EntityManager em) {
        this.em = em;
    }
    
    
    public void UtilizadorBean(){
        
    }
    
    
    public boolean existeUsername(String username) {
        try {
            return em.find(Utilizador.class, username) != null;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    } 
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
