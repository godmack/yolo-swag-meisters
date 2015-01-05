package ejbs;


import Entidades.Cliente;
import Entidades.Estado;
import Entidades.Farmacia;
import Entidades.Funcionario;
import Entidades.LinhaVenda;
import Entidades.Utilizador;
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
import javax.ejb.SessionContext;
import javax.faces.context.FacesContext;

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

    public void criarVenda(int clienteID) throws EntidadeExistenteException, EntidadeNaoExistenteException {
        try {
            
            String name = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
            
            Utilizador utilizador = em.find(Utilizador.class, name);
            if(name == null){
                throw new EntidadeNaoExistenteException("Utilizador não existente!");
            }
            
            Cliente client = em.find(Cliente.class, clienteID);
            if(client == null){
                throw new EntidadeNaoExistenteException("Cliente não existente!");
            }
            
            Farmacia farm = em.find(Farmacia.class, utilizador.getFarmacia().getIdFarmacia());
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
    
     private VendaDTO copiarVendaParaDTO(Venda venda) {
        return new VendaDTO(
                venda.getIdVenda(),
                venda.getCliente().getContacto(),
                venda.getFarmacia().getIdFarmacia(),
                venda.getEstado()
                );
    }

    private List<VendaDTO> copiarVendasParaDTOs(List<Venda> vendas) {
        List<VendaDTO> dtos = new ArrayList<>();
        for (Venda venda : vendas) {
            dtos.add(copiarVendaParaDTO(venda));
        }
        return dtos;
    }
    
    public void confirmar(Long idVenda) throws EntidadeNaoExistenteException {
        try {
            
            Venda venda = em.find(Venda.class, idVenda);

            if (venda == null) {
                throw new EntidadeNaoExistenteException("Encomenda não existente!");
            }

            venda.setEstado(Estado.Confirmado);
            
            
            em.persist(venda);

        } catch (EntidadeNaoExistenteException e) {
            throw e;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }

    }

}
