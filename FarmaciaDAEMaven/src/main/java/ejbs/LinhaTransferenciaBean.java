/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import Entidades.Transferencia;
import Entidades.LinhaTransferencia;
import Entidades.LinhaTransferenciaKey;
import Entidades.ProdutoCatalogo;
import dtos.LinhaTransferenciaDTO;
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
public class LinhaTransferenciaBean {
    @PersistenceContext
    private EntityManager em;
    
    public void criarLinhaTransferencia(Long idTransferencia, int idProdutoCatalogo, int quantidade) throws EntidadeExistenteException{
        try {
            
            Transferencia transferencia = em.find(Transferencia.class, idTransferencia);
            ProdutoCatalogo produtoCatalogo = em.find(ProdutoCatalogo.class, idProdutoCatalogo);
            
            if(existeLinhaTransferencia(transferencia,produtoCatalogo)){
                throw new EntidadeExistenteException("Já existe uma linha relativa a este produto");
            }            
            
            LinhaTransferencia linhaTransferencia = new LinhaTransferencia(transferencia, produtoCatalogo, quantidade);
            
            em.persist(linhaTransferencia);
            transferencia.addLinhaTransferencia(linhaTransferencia);
        } catch (EntidadeExistenteException e) {
            throw e;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    public boolean existeLinhaTransferencia(Transferencia transferencia, ProdutoCatalogo produtoCatalogo){
        
        Query queryExisteLinhaTransferencia = em.createNamedQuery(
            "findExisteLinhaTransferenciaProduto"
        );
        queryExisteLinhaTransferencia.setParameter("transferencia", transferencia);
        queryExisteLinhaTransferencia.setParameter("produtoCatalogo", produtoCatalogo);
        int numResults = queryExisteLinhaTransferencia.getResultList().size();
        
        if(numResults > 0){
            return true;
        }
        return false;
    }
    
    public List<LinhaTransferenciaDTO> getLinhasDeUmaTransferencia(Long codigoTransferencia) throws EntidadeNaoExistenteException{
        try {
            Transferencia transferencia = em.find(Transferencia.class, codigoTransferencia);
            if(transferencia == null){
                throw new EntidadeNaoExistenteException("Transferencia não existente!");
            }
            List<LinhaTransferencia> les = (List<LinhaTransferencia>) transferencia.getLinhasTransferencia();
            return copiarLinhasTransferenciaParaDTOs(les);
        } catch (EntidadeNaoExistenteException e) {
            throw e;            
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    public void removerLinhaTransferencia(Long codigoTransferencia, int codigoProdutoCatalogo) throws EntidadeNaoExistenteException {
        try {
            if(em.find(Transferencia.class, codigoTransferencia) == null){
                throw new EntidadeNaoExistenteException("Transferencia não existente!");
            }
            
            LinhaTransferenciaKey chave = new LinhaTransferenciaKey(codigoProdutoCatalogo, (long) codigoTransferencia);
            LinhaTransferencia le = em.find(LinhaTransferencia.class, chave);
            if(le == null){
                throw new EntidadeNaoExistenteException("Linha Transferencia não existente!");
            }
            
            le.getTransferencia().removeLinhaTransferencia(le);

            em.remove(le);

        } catch (EntidadeNaoExistenteException e) {
            throw e;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    
    public void alterarQuantidadeLinhaTransferencia(int codigoTransferencia, int codigoProdutoCatalogo, int quantidade) throws EntidadeNaoExistenteException {
        try {
            if(em.find(Transferencia.class, codigoTransferencia) == null){
                throw new EntidadeNaoExistenteException("UC não existente!");
            }
            
            LinhaTransferenciaKey chave = new LinhaTransferenciaKey(codigoProdutoCatalogo, (long) codigoTransferencia);
            LinhaTransferencia le = em.find(LinhaTransferencia.class, chave);
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
    
     public List<LinhaTransferenciaDTO> getAllLinhasTransferenciaDeUmaTransferencia(Transferencia transferencia) {
        try {
             Query queryExisteLinhaTransferencia = em.createNamedQuery(
                "findAllLinhasTransferenciaDeUmaTransferencia"
            );
            queryExisteLinhaTransferencia.setParameter("transferencia", transferencia.getIdTransferencia());
            List<LinhaTransferencia> linhasTransferencia = (List<LinhaTransferencia>) queryExisteLinhaTransferencia.getResultList();
            return copiarLinhasTransferenciaParaDTOs(linhasTransferencia);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    private LinhaTransferenciaDTO copiarLinhaTransferenciaParaDTO(LinhaTransferencia linhaTransferencia) {
        return new LinhaTransferenciaDTO(
                linhaTransferencia.getProdutoCatalogo().getReferencia(),
                linhaTransferencia.getTransferencia().getIdTransferencia(),
                linhaTransferencia.getQuantidade());
    }
    
    private List<LinhaTransferenciaDTO> copiarLinhasTransferenciaParaDTOs(List<LinhaTransferencia> linhasTransferencia) {
        List<LinhaTransferenciaDTO> dtos = new ArrayList<>();
        for (LinhaTransferencia linhaTransferencia : linhasTransferencia) {
            dtos.add(copiarLinhaTransferenciaParaDTO(linhaTransferencia));
        }
        return dtos;
    }
    
    
}
