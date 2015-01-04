/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import Entidades.Administrador;
import excecoes.EntidadeExistenteException;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import Entidades.Administrador;
import Entidades.Farmacia;
import Entidades.Utilizador;
import excecoes.EntidadeExistenteException;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Cristiano
 */
@Stateless
public class AdministradorBean {

    @PersistenceContext
    private EntityManager em;
    @EJB
    UtilizadorBean uBean;    

    public AdministradorBean() {
    }
        
    public AdministradorBean(EntityManager em) {
        this.em = em;
    }
    
    
    public void criarAdministrador(String username, String password, String nome, String email, Long idFarmacia) throws EntidadeExistenteException{
        try {
            if(uBean.existeUsername(username)){
                throw new EntidadeExistenteException("Utilizador já existente!");
            }
            Farmacia farmacia = em.find(Farmacia.class, idFarmacia);
            em.persist(new Administrador(username, password, nome, email, farmacia));
        } catch (EntidadeExistenteException e) {
            throw e;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }  
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
