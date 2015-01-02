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

    public void criarEncomenda(String fornecedor, Long farmacia) throws EntidadeExistenteException, EntidadeNaoExistenteException {
        try {
            Fornecedor forn = em.find(Fornecedor.class, fornecedor);
            if(forn == null){
                throw new EntidadeNaoExistenteException("Fornecedor não existente!");
            }
            Farmacia farm = em.find(Farmacia.class, farmacia);
            if(farm == null){
                throw new EntidadeNaoExistenteException("Farmacia não existente!");
            }
            
            Encomenda encomenda = new Encomenda(forn, farm);
            em.persist(encomenda);
            farm.addEncomenda(encomenda);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    public List<EncomendaDTO> getAllEncomendas() {
        try {
            List<Encomenda> encomendas = (List<Encomenda>) em.createNamedQuery("findAllEncomendas").getResultList();
            return copiarEncomendasParaDTOs(encomendas);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
     private EncomendaDTO copiarEncomendaParaDTO(Encomenda encomenda) {
        return new EncomendaDTO(
                encomenda.getFornecedor().getLaboratorio(),
                encomenda.getFarmacia().getIdFarmacia());
    }
     
     private List<EncomendaDTO> copiarEncomendasParaDTOs(List<Encomenda> encomendas) {
        List<EncomendaDTO> dtos = new ArrayList<>();
        for (Encomenda encomenda : encomendas) {
            dtos.add(copiarEncomendaParaDTO(encomenda));
        }
        return dtos;
    }
     
     public void atualizar(String fornecedor, Long farmacia, int idEncomenda) throws EntidadeExistenteException, EntidadeNaoExistenteException {
        try {
            Encomenda encomenda = em.find(Encomenda.class, idEncomenda);
            if(encomenda == null){
                throw new EntidadeNaoExistenteException("Encomenda não existente!");
            }
            
            Fornecedor forn = em.find(Fornecedor.class, fornecedor);
            if(forn == null){
                throw new EntidadeNaoExistenteException("Fornecedor não existente!");
            }
            Farmacia farm = em.find(Farmacia.class, farmacia);
            if(farm == null){
                throw new EntidadeNaoExistenteException("Farmacia não existente!");
            }
            
            encomenda.setFornecedor(forn);
            encomenda.setFarmacia(farm);
            em.persist(encomenda);
       } catch (EntidadeNaoExistenteException e) {
            throw e;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
}
