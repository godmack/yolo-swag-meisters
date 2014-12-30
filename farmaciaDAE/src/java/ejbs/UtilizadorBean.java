/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import Entidades.Farmacia;
import Entidades.Utilizador;
import dtos.UtilizadorDTO;
import excecoes.EntidadeNaoExistenteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
    
     public List<UtilizadorDTO> getUtilizadoresPertencemFarmacia(Long idFarmacia) throws EntidadeNaoExistenteException{
        try {
            Farmacia farmacia = em.find(Farmacia.class, idFarmacia);
            if(farmacia == null){
                throw new EntidadeNaoExistenteException("Farmacia não existente!");
            }
            List<Utilizador> utilizadores = (List<Utilizador>) farmacia.getUtilizadores();
            return copiarUtilizadoresParaDTOs(utilizadores);
        } catch (EntidadeNaoExistenteException e) {
            throw e;            
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
     public List<UtilizadorDTO> getUtilizadoresNaoPertencemFarmacia() throws EntidadeNaoExistenteException{
        try {
            List<Farmacia> farmacias = (List<Farmacia>) em.createNamedQuery("findAllFarmacias").getResultList();
            if(farmacias == null){
                throw new EntidadeNaoExistenteException("Farmacia não existente!");
            }  
            System.out.println("antes query users");
            List<Utilizador> utilizadores = (List<Utilizador>) em.createNamedQuery("findAllUtilizadores").getResultList();
            System.out.println("depois query users");
            for (Farmacia farmacia : farmacias) { 
                List<Utilizador> pertencem = farmacia.getUtilizadores();
                utilizadores.removeAll(pertencem);
            }
            System.out.println("depois do for each");
            
            return copiarUtilizadoresParaDTOs(utilizadores);
        } catch (EntidadeNaoExistenteException e) {
            throw e;              
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    public void atribuirUtilizadorFarmacia(Long codigoFarmacia, String username) throws EntidadeNaoExistenteException{
        try {
            System.out.println("entrou atribuirUtilizadorFarmacia");
            Farmacia farmacia = em.find(Farmacia.class, codigoFarmacia);
            if(farmacia == null){
                throw new EntidadeNaoExistenteException("Farmacia não existente!");
            }            
            Utilizador utilizador = em.find(Utilizador.class, username);
            if(utilizador == null){
                throw new EntidadeNaoExistenteException("Utilizador não existente!");
            }
           System.out.println("entrou farmacia.addUtilizador(utilizador)");
            farmacia.addUtilizador(utilizador);
            System.out.println("entrou utilizador.setFarmacia(farmacia);");
            utilizador.setFarmacia(farmacia);
            System.out.println("saiu utilizador.setFarmacia(farmacia);");
        } catch (EntidadeNaoExistenteException e) {
            throw e;             
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    public void retirarUtilizadorFarmacia(Long codigoFarmacia, String username) throws EntidadeNaoExistenteException{
        try {
            Farmacia farmacia = em.find(Farmacia.class, codigoFarmacia);
            if(farmacia == null){
                throw new EntidadeNaoExistenteException("Farmacia não existente!");
            }            
            Utilizador utilizador = em.find(Utilizador.class, username);
            if(utilizador == null){
                throw new EntidadeNaoExistenteException("Utilizador não existente!");
            }
            farmacia.removeUtilizador(utilizador);
            utilizador.setFarmacia(null);
        } catch (EntidadeNaoExistenteException e) {
            throw e;              
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
     
      private UtilizadorDTO copiarUtilizadorParaDTO(Utilizador utilizador) {
          System.out.println("Entrou no DTO");
          
        return new UtilizadorDTO(
                utilizador.getUsername(),
                utilizador.getNome(),
                utilizador.getEmail(),
                "NEIN");
    }

    private List<UtilizadorDTO> copiarUtilizadoresParaDTOs(List<Utilizador> utilizadores) {
        System.out.println("entrou nos dtos");
        List<UtilizadorDTO> dtos = new ArrayList<>();
        for (Utilizador utilizador : utilizadores) {
            dtos.add(copiarUtilizadorParaDTO(utilizador));
        }
        System.out.println("return dtos");
        return dtos;
    }
}
