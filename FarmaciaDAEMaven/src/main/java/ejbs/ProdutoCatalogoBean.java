/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import Entidades.Farmacia;
import Entidades.ProdutoCatalogo;
import Entidades.ProdutoCatalogo;
import dtos.ProdutoCatalogoDTO;
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
public class ProdutoCatalogoBean {
    
    @PersistenceContext (name="produtoCatalogoDAEPU")
    private EntityManager em;
    
    
     public ProdutoCatalogoBean() {
    }
        
    public ProdutoCatalogoBean(EntityManager em) {
        this.em = em;
    }
    
    public void criarProdutoCatalogo(int referencia, String nome, String laboratorio, Double preco) throws EntidadeExistenteException{
        
        try {
            if (existeProdutoCatalogo(referencia)) {
                throw new EntidadeExistenteException("Utilizador já existente!");
            }
            em.persist(new ProdutoCatalogo(referencia, nome, laboratorio, preco));
        } catch (EntidadeExistenteException e) {
            throw e;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
        
    }
    
    public List<ProdutoCatalogoDTO> getAllProdutoCatalogo(){
        try {
            List<ProdutoCatalogo> pCatalogos = (List<ProdutoCatalogo>) em.createNamedQuery("findAllProdutoCatalogos").getResultList();
            return copiarProdutoCatalogosParaDTOs(pCatalogos);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
     private ProdutoCatalogoDTO copiarProdutoCatalogoParaDTO(ProdutoCatalogo pCatalogo) {
        return new ProdutoCatalogoDTO(
                pCatalogo.getReferencia(),
                pCatalogo.getNome(),
                pCatalogo.getLaboratorio(),
                pCatalogo.getPreco()
        );
    }
     
     private List<ProdutoCatalogoDTO> copiarProdutoCatalogosParaDTOs(List<ProdutoCatalogo> ProdutoCatalogos) {
        List<ProdutoCatalogoDTO> dtos = new ArrayList<>();
        for (ProdutoCatalogo docente : ProdutoCatalogos) {
            dtos.add(copiarProdutoCatalogoParaDTO(docente));
        }
        return dtos;
    }
     
     public void atualizar(int referencia, String nome, String laboratorio, Double preco) throws EntidadeNaoExistenteException{
        try {
            ProdutoCatalogo pCatalogo = em.find(ProdutoCatalogo.class, referencia);
            if(pCatalogo == null){
                throw new EntidadeNaoExistenteException("Produto de Catalogo nao existente!");
            }
            pCatalogo.setNome(nome);
            pCatalogo.setReferencia(referencia);
            pCatalogo.setLaboratorio(laboratorio);
            pCatalogo.setPreco(preco);
            em.merge(pCatalogo);
        } catch (EntidadeNaoExistenteException e) {
            throw e;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
     
    public boolean existeProdutoCatalogo(int referencia) {
        return em.find(ProdutoCatalogo.class, referencia) != null;
    }
     
    
    
}
