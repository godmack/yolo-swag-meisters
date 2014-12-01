/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import Entidades.Funcionario;
import excecoes.EntidadeExistenteException;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Andre
 */

@Stateless
public class FuncionarioBean {
    
    @PersistenceContext (name="farmaciaDAEPU")
    private EntityManager em;
    @EJB
    UtilizadorBean uBean;
    
    
     public FuncionarioBean() {
    }
        
    public FuncionarioBean(EntityManager em) {
        this.em = em;
    }
    
    public void criarFuncionario(String nome, String username,String password, String email, boolean eFuncBalcao) throws EntidadeExistenteException{
        
        try {
            if (uBean.existeUsername(username)) {
                throw new EntidadeExistenteException("Utilizador já existente!");
            }
            em.persist(new Funcionario(username, password, nome, email, eFuncBalcao));
        } catch (EntidadeExistenteException e) {
            throw e;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
        
    }
    
}
