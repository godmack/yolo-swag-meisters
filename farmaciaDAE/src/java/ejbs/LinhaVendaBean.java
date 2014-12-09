/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import Entidades.Venda;
import Entidades.LinhaVenda;
import Entidades.LinhaVendaKey;
import Entidades.LinhaVenda;
import Entidades.ProdutoCatalogo;
import Entidades.Venda;
import dtos.LinhaVendaDTO;
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
public class LinhaVendaBean {
    @PersistenceContext
    private EntityManager em;
    
    public void criarLinhaVenda(Venda venda, ProdutoCatalogo produtoCatalogo, int quantidade) throws EntidadeExistenteException{
        try {
            if(existeLinhaVenda(venda,produtoCatalogo)){
                throw new EntidadeExistenteException("Já existe uma linha relativa a este produto");
            }
            
            float preco = produtoCatalogo.getPreco();
            
            preco = preco*quantidade;
            
            em.persist(new LinhaVenda(venda, produtoCatalogo, preco, quantidade));
        } catch (EntidadeExistenteException e) {
            throw e;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    public boolean existeLinhaVenda(Venda venda, ProdutoCatalogo produtoCatalogo){
        
        Query queryExisteLinhaVenda = em.createNamedQuery(
            "findAllEmployeesByFirstName"
        );
        queryExisteLinhaVenda.setParameter("venda", venda.getLinhasVenda());
        queryExisteLinhaVenda.setParameter("produtoCatalogo", produtoCatalogo.getReferencia());
        int numResults = queryExisteLinhaVenda.getMaxResults();
        
        if(numResults != 0){
            return true;
        }
        return false;
    }
    
    public List<LinhaVendaDTO> getLinhasDeUmaVenda(int codigoVenda) throws EntidadeNaoExistenteException{
        try {
            Venda venda = em.find(Venda.class, codigoVenda);
            if(venda == null){
                throw new EntidadeNaoExistenteException("Venda não existente!");
            }
            List<LinhaVenda> lvs = (List<LinhaVenda>) venda.getLinhasVenda();
            return copiarLinhasVendaParaDTOs(lvs);
        } catch (EntidadeNaoExistenteException e) {
            throw e;            
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    public void removerLinhaVenda(Long codigoVenda, int codigoProdutoCatalogo) throws EntidadeNaoExistenteException {
        try {
            if(em.find(Venda.class, codigoVenda) == null){
                throw new EntidadeNaoExistenteException("UC não existente!");
            }
            
            LinhaVendaKey chave = new LinhaVendaKey(codigoVenda, codigoProdutoCatalogo);
            LinhaVenda le = em.find(LinhaVenda.class, chave);
            if(le == null){
                throw new EntidadeNaoExistenteException("Elemento de avaliação não existente!");
            }
            
            le.getVenda().removeLinhaVenda(le);

            em.remove(le);

        } catch (EntidadeNaoExistenteException e) {
            throw e;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    
    public void alterarQuantidadeLinhaVenda(Long codigoVenda, int codigoProdutoCatalogo, int quantidade) throws EntidadeNaoExistenteException {
        try {
            if(em.find(Venda.class, codigoVenda) == null){
                throw new EntidadeNaoExistenteException("UC não existente!");
            }
            
            LinhaVendaKey chave = new LinhaVendaKey(codigoVenda, codigoProdutoCatalogo);
            LinhaVenda le = em.find(LinhaVenda.class, chave);
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
    
     public List<LinhaVendaDTO> getAllLinhasVendaDeUmaVenda(Venda venda) {
        try {
             Query queryExisteLinhaVenda = em.createNamedQuery(
                "findAllLinhasVendaDeUmaVenda"
            );
            queryExisteLinhaVenda.setParameter("venda", venda.getIdVenda());
            List<LinhaVenda> linhasVenda = (List<LinhaVenda>) queryExisteLinhaVenda.getResultList();
            return copiarLinhasVendaParaDTOs(linhasVenda);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    private LinhaVendaDTO copiarLinhaVendaParaDTO(LinhaVenda linhaVenda) {
        return new LinhaVendaDTO(
                linhaVenda.getProdutoCatalogo().getReferencia(),
                linhaVenda.getVenda().getIdVenda(),
                linhaVenda.getQuantidade());
    }
    
    private List<LinhaVendaDTO> copiarLinhasVendaParaDTOs(List<LinhaVenda> linhasVenda) {
        List<LinhaVendaDTO> dtos = new ArrayList<>();
        for (LinhaVenda linhaVenda : linhasVenda) {
            dtos.add(copiarLinhaVendaParaDTO(linhaVenda));
        }
        return dtos;
    }
    
    
}
