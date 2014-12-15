package ejbs;

import Entidades.Cliente;
import Entidades.Encomenda;
import Entidades.Farmacia;
import Entidades.Fornecedor;
import dtos.EncomendaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import excecoes.EntidadeExistenteException;
import excecoes.EntidadeNaoExistenteException;

@Stateless
public class EncomendaBean {

    @PersistenceContext
    private EntityManager em;
    @EJB
    FarmaciaBean farmaciaBean;

    public void criarEncomenda(Fornecedor fornecedor, Farmacia farmacia) throws EntidadeExistenteException, EntidadeNaoExistenteException {
        try {
            
            Encomenda encomenda = new Encomenda(fornecedor, farmacia);
            em.persist(encomenda);
            farmacia.addEncomenda(encomenda);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    public List<EncomendaDTO> getAllEncomendas() {
        try {
            List<Encomenda> ucs = (List<Encomenda>) em.createNamedQuery("findAllEncomendas").getResultList();
            return copiarEncomendasParaDTOs(ucs);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
     private EncomendaDTO copiarEncomendaParaDTO(Encomenda encomenda) {
        return new EncomendaDTO(
                encomenda.getFornecedor(),
                encomenda.getFarmacia()
        );
    }
     
     private List<EncomendaDTO> copiarEncomendasParaDTOs(List<Encomenda> encomendas) {
        List<EncomendaDTO> dtos = new ArrayList<>();
        for (Encomenda encomenda : encomendas) {
            dtos.add(copiarEncomendaParaDTO(encomenda));
        }
        return dtos;
    }
}
