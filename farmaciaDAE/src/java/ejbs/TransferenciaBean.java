/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import Entidades.Farmacia;
import Entidades.Produto;
import Entidades.ProdutoCatalogo;
import Entidades.Stock;
import Entidades.Transferencia;
import dtos.ProdutoDTO;
import dtos.TransferenciaDTO;
import excecoes.EntidadeExistenteException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJBException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ruben
 */
public class TransferenciaBean {

    @PersistenceContext
    private EntityManager em;

    public void criarStock(int id, Farmacia farmaciaFornecedora, Farmacia farmacia) throws EntidadeExistenteException {
        try {
            if (existeTransferencia(id)) {
                throw new EntidadeExistenteException("Transferencia já foi efetuada!");
            }
            em.persist(new Transferencia(farmaciaFornecedora, farmacia));
        } catch (EntidadeExistenteException e) {
            throw e;
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
        List<TransferenciaDTO> dtos = new ArrayList<>();
        for (Transferencia transferencia : transferencias) {
            dtos.add(new TransferenciaDTO(transferencia.getFarmaciaFornecedora().getIdFarmacia(), transferencia.getFarmacia().getIdFarmacia()));
        }
        return dtos;
    }

}
