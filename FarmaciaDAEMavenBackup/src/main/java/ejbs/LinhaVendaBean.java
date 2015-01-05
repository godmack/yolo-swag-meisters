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
    
    public void criarLinhaVenda(Long idVenda, int referenciaProdutoCatalogo, int quantidade) throws EntidadeExistenteException{
        try {
            ProdutoCatalogo produtoCatalogo = em.find(ProdutoCatalogo.class, referenciaProdutoCatalogo);
            Venda venda = em.find(Venda.class, idVenda);
            if(existeLinhaVenda(venda,produtoCatalogo)){
                throw new EntidadeExistenteException("Já existe uma linha relativa a este produto");
            }
            
            Double preco = produtoCatalogo.getPreco();
            
            preco = preco*quantidade;
            
            LinhaVenda linha = new LinhaVenda(venda, produtoCatalogo, preco, quantidade);
            
            venda.addLinhaVenda(linha);
            
            em.persist(linha);
        } catch (EntidadeExistenteException e) {
            throw e;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    public boolean existeLinhaVenda(Venda venda, ProdutoCatalogo produtoCatalogo){
        
        Query queryExisteLinhaVenda = em.createNamedQuery(
            "findLinhaVenda"
        );
        queryExisteLinhaVenda.setParameter("venda", venda);
        queryExisteLinhaVenda.setParameter("produtoCatalogo", produtoCatalogo);
        int numResults = queryExisteLinhaVenda.getResultList().size();
        
        if(numResults > 0){
            return true;
        }
        return false;
    }
    
    public List<LinhaVendaDTO> getLinhasDeUmaVenda(Long codigoVenda) throws EntidadeNaoExistenteException{
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
                throw new EntidadeNaoExistenteException("Venda não existente!");
            }
            
            LinhaVendaKey chave = new LinhaVendaKey(codigoVenda, codigoProdutoCatalogo);
            LinhaVenda le = em.find(LinhaVenda.class, chave);
            if(le == null){
                throw new EntidadeNaoExistenteException("Linha de Venda não existente!");
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
                throw new EntidadeNaoExistenteException("Venda não existente!");
            }
            
            LinhaVendaKey chave = new LinhaVendaKey(codigoVenda, codigoProdutoCatalogo);
            LinhaVenda le = em.find(LinhaVenda.class, chave);
            if(le == null){
                throw new EntidadeNaoExistenteException("Linha de Venda não existente!");
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
            queryExisteLinhaVenda.setParameter("venda", venda);
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
                linhaVenda.getQuantidade(),
                linhaVenda.getPreco());
    }
    
    private List<LinhaVendaDTO> copiarLinhasVendaParaDTOs(List<LinhaVenda> linhasVenda) {
        List<LinhaVendaDTO> dtos = new ArrayList();
        for (LinhaVenda linhaVenda : linhasVenda) {
            dtos.add(copiarLinhaVendaParaDTO(linhaVenda));
        }
        return dtos;
    }
    
    
}
