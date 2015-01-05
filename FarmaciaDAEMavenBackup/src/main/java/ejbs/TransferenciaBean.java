/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import Entidades.Estado;
import Entidades.Farmacia;
import Entidades.Produto;
import Entidades.ProdutoCatalogo;
import Entidades.Stock;
import Entidades.Transferencia;
import dtos.ProdutoDTO;
import dtos.TransferenciaDTO;
import excecoes.EntidadeExistenteException;
import excecoes.EntidadeNaoExistenteException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ruben
 */
@Stateless
public class TransferenciaBean {

    @PersistenceContext
    private EntityManager em;

    public void criarTransferencia(Long farmaciaFornecedora, Long farmacia) {
        try {
            
            Farmacia fornecedora = em.find(Farmacia.class, farmaciaFornecedora);
            Farmacia receptora = em.find(Farmacia.class, farmacia);
            
            em.persist(new Transferencia(fornecedora, receptora));
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    private boolean existeTransferencia(int id) {
        return em.find(Transferencia.class, id) != null;
    }

    public List<TransferenciaDTO> getAllTransferencias() {
        try {
            List<Transferencia> transferencias = (List<Transferencia>) em.createNamedQuery("findAllTransferencias").getResultList();
            return copiarTransferenciasParaDTOs(transferencias);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    //TODO getTransferencia por estados?

    private List<TransferenciaDTO> copiarTransferenciasParaDTOs(List<Transferencia> transferencias) {
        List<TransferenciaDTO> dtos = new ArrayList();
        for (Transferencia transferencia : transferencias) {
            dtos.add(new TransferenciaDTO(  transferencia.getIdTransferencia(),
                                            transferencia.getFarmaciaFornecedora().getIdFarmacia(), 
                                            transferencia.getFarmacia().getIdFarmacia(), 
                                            transferencia.getEstado(),
                                            transferencia.getData()));
        }
        return dtos;
    }
    
    public void confirmar(Long idTransferencia) throws EntidadeNaoExistenteException{
         try {
            Transferencia transferencia = em.find(Transferencia.class, idTransferencia);
            
            if (transferencia == null) {
                throw new EntidadeNaoExistenteException("Transferencia não existente!");
            }
            
            transferencia.setEstado(Estado.Enviado);
            em.persist(transferencia);
                    
        } catch (EntidadeNaoExistenteException e) {
            throw e;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
     
     }
	 
	  public void enviarMail(Long idTransferencia) throws MessagingException, EntidadeNaoExistenteException {
        try {
            Transferencia transferencia = em.find(Transferencia.class, idTransferencia);

            if (transferencia == null) {
                throw new EntidadeNaoExistenteException("Encomenda não existente!");
            }
            String em = " ";
            List<LinhaTransferencia> les = (List<LinhaTransferencia>) transferencia.getLinhasTransferencia();
            for (LinhaTransferencia li : les) {
                em = ("Referencia Produto: " + li.getProdutoCatalogo().getReferencia() + " - Produto: " + li.getProdutoCatalogo().getNome() + " - Quantidade: " + li.getQuantidade() + "\n");
            }
//            String email = transferencia.getFornecedor().getEmail();
//            emailBean.send(
//                    email,
//                    "Encomenda  ",
//                    "Foram encomendados os seguintes produtos "
//                    + em
//                    + "\n\nCom os melhores cumprimentos\n" + transferencia.getFarmacia().getNome());

        } catch (/*MessagingException |*/EntidadeNaoExistenteException e) {
            throw e;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

}
