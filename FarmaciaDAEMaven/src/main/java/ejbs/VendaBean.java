package ejbs;


import Entidades.Cliente;
import Entidades.Farmacia;
import Entidades.Funcionario;
import Entidades.Venda;
import dtos.ClienteDTO;
import dtos.FuncionarioDTO;
import dtos.VendaDTO;
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
public class VendaBean {

    @PersistenceContext
    private EntityManager em;
    @EJB
    VendaBean vendaBean;
    
    public VendaBean() {
    }
        
    public VendaBean(EntityManager em) {
        this.em = em;
    }

    public void criarVenda(int clienteID, Long farmaciaID) throws EntidadeExistenteException, EntidadeNaoExistenteException {
        try {
            Cliente client = em.find(Cliente.class, clienteID);
            if(client == null){
                throw new EntidadeNaoExistenteException("Cliente não existente!");
            }
            
            Farmacia farm = em.find(Farmacia.class, farmaciaID);
            if(client == null){
                throw new EntidadeNaoExistenteException("Farmacia não existente!");
            }
            
            Venda venda = new Venda(client, farm);
            em.persist(venda);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    public List<VendaDTO> getAllVendas(){
        try {
            List<Venda> vendas = (List<Venda>) em.createNamedQuery("findAllVendas").getResultList();
            return copiarVendasParaDTOs(vendas);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    private List<VendaDTO> copiarVendasParaDTOs(List<Venda> vendas) {

        List<VendaDTO> dtos = new ArrayList<>();

        for (Venda venda: vendas) {
            dtos.add(new VendaDTO(
                    venda.getCliente().getContacto(),
                    venda.getFarmacia().getIdFarmacia()));
        }
        return dtos;
    }

}
