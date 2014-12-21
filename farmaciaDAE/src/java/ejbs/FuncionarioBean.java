/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import Entidades.Funcionario;
import dtos.FuncionarioDTO;
import excecoes.EntidadeExistenteException;
import excecoes.EntidadeNaoExistenteException;
import java.util.ArrayList;
import java.util.List;
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
    
    public void criarFuncionario(String nome, String username, String password, String email, boolean eFuncBalcao) throws EntidadeExistenteException, EntidadeNaoExistenteException{
        
        try {
            if (uBean.existeUsername(username)) {
                throw new EntidadeExistenteException("Utilizador já existente!");
            }
            em.persist(new Funcionario(nome, username, email, password,  eFuncBalcao));
        } catch (EntidadeExistenteException e) {
            throw e;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
        
    }
    
    public List<FuncionarioDTO> getAllFuncionario(){
        try {
            List<Funcionario> funcionarios = (List<Funcionario>) em.createNamedQuery("findAllFuncionarios").getResultList();
            return copiarFuncionariosParaDTOs(funcionarios);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
     private FuncionarioDTO copiarFuncionarioParaDTO(Funcionario funcionario) {
        return new FuncionarioDTO(
                funcionario.getUsername(),
                funcionario.getNome(),
                funcionario.getEmail(),
                funcionario.isFuncBalcao()
        );
    }
     
     private List<FuncionarioDTO> copiarFuncionariosParaDTOs(List<Funcionario> docentes) {
        List<FuncionarioDTO> dtos = new ArrayList<>();
        for (Funcionario docente : docentes) {
            dtos.add(copiarFuncionarioParaDTO(docente));
        }
        return dtos;
    }
    
}
