/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import Entidades.Encomenda;
import Entidades.LinhaEncomenda;
import Entidades.LinhaEncomendaKey;
import Entidades.ProdutoCatalogo;
import dtos.LinhaEncomendaDTO;
import excecoes.EntidadeExistenteException;
import excecoes.EntidadeNaoExistenteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Andre
 */
@Stateless
public class LinhaEncomendaBean {
    @PersistenceContext
    private EntityManager em;
    
    public void criarLinhaEncomenda(Encomenda encomenda, ProdutoCatalogo produtoCatalogo, int quantidade) throws EntidadeExistenteException{
        try {
            if(existeLinhaEncomenda(encomenda,produtoCatalogo)){
                throw new EntidadeExistenteException("Já existe uma linha relativa a este produto");
            }            
            em.persist(new LinhaEncomenda(encomenda, produtoCatalogo, quantidade));
        } catch (EntidadeExistenteException e) {
            throw e;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    public boolean existeLinhaEncomenda(Encomenda encomenda, ProdutoCatalogo produtoCatalogo){
        
        Query queryExisteLinhaEncomenda = em.createNamedQuery(
            "findAllEmployeesByFirstName"
        );
        queryExisteLinhaEncomenda.setParameter("encomenda", encomenda.getIdEncomenda());
        queryExisteLinhaEncomenda.setParameter("produtoCatalogo", produtoCatalogo.getReferencia());
        int numResults = queryExisteLinhaEncomenda.getMaxResults();
        
        if(numResults != 0){
            return true;
        }
        return false;
    }
    
    public List<LinhaEncomendaDTO> getLinhasDeUmaEncomenda(int codigoEncomenda) throws EntidadeNaoExistenteException{
        try {
            Encomenda encomenda = em.find(Encomenda.class, codigoEncomenda);
            if(encomenda == null){
                throw new EntidadeNaoExistenteException("Encomenda não existente!");
            }
            List<LinhaEncomenda> les = (List<LinhaEncomenda>) encomenda.getLinhasEncomenda();
            return copiarLinhasEncomendaParaDTOs(les);
        } catch (EntidadeNaoExistenteException e) {
            throw e;            
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    public void removerLinhaEncomenda(int codigoEncomenda, int codigoProdutoCatalogo) throws EntidadeNaoExistenteException {
        try {
            if(em.find(Encomenda.class, codigoEncomenda) == null){
                throw new EntidadeNaoExistenteException("UC não existente!");
            }
            
            LinhaEncomendaKey chave = new LinhaEncomendaKey(codigoProdutoCatalogo, (long) codigoEncomenda);
            LinhaEncomenda le = em.find(LinhaEncomenda.class, chave);
            if(le == null){
                throw new EntidadeNaoExistenteException("Elemento de avaliação não existente!");
            }
            
            le.getEncomenda().removeLinhaEncomenda(le);

            em.remove(le);

        } catch (EntidadeNaoExistenteException e) {
            throw e;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    
    public void alterarQuantidadeLinhaEncomenda(int codigoEncomenda, int codigoProdutoCatalogo, int quantidade) throws EntidadeNaoExistenteException {
        try {
            if(em.find(Encomenda.class, codigoEncomenda) == null){
                throw new EntidadeNaoExistenteException("UC não existente!");
            }
            
            LinhaEncomendaKey chave = new LinhaEncomendaKey(codigoProdutoCatalogo, (long) codigoEncomenda);
            LinhaEncomenda le = em.find(LinhaEncomenda.class, chave);
            if(le == null){
                throw new EntidadeNaoExistenteException("Elemento de avaliação não existente!");
            }
            
            le.setQuantidade(quantidade);

        } catch (EntidadeNaoExistenteException e) {
            throw e;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
     public List<LinhaEncomendaDTO> getAllLinhasEncomendaDeUmaEncomenda(Encomenda encomenda) {
        try {
             Query queryExisteLinhaEncomenda = em.createNamedQuery(
                "findAllLinhasEncomendaDeUmaEncomenda"
            );
            queryExisteLinhaEncomenda.setParameter("encomenda", encomenda.getIdEncomenda());
            List<LinhaEncomenda> linhasEncomenda = (List<LinhaEncomenda>) queryExisteLinhaEncomenda.getResultList();
            return copiarLinhasEncomendaParaDTOs(linhasEncomenda);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    private LinhaEncomendaDTO copiarLinhaEncomendaParaDTO(LinhaEncomenda linhaEncomenda) {
        return new LinhaEncomendaDTO(
                linhaEncomenda.getProdutoCatalogo().getReferencia(),
                linhaEncomenda.getEncomenda().getIdEncomenda(),
                linhaEncomenda.getQuantidade());
    }
    
    private List<LinhaEncomendaDTO> copiarLinhasEncomendaParaDTOs(List<LinhaEncomenda> linhasEncomenda) {
        List<LinhaEncomendaDTO> dtos = new ArrayList<>();
        for (LinhaEncomenda linhaEncomenda : linhasEncomenda) {
            dtos.add(copiarLinhaEncomendaParaDTO(linhaEncomenda));
        }
        return dtos;
    }
    
    
}
