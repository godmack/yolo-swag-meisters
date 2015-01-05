package ejbs;


import Entidades.Cliente;
import Entidades.Funcionario;
import dtos.ClienteDTO;
import dtos.FuncionarioDTO;
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
public class ClienteBean {

    @PersistenceContext
    private EntityManager em;
    @EJB
    ClienteBean clienteBean;
    
    public ClienteBean() {
    }
        
    public ClienteBean(EntityManager em) {
        this.em = em;
    }

    public void criarCliente(String nome, String email, int contacto) throws EntidadeExistenteException, EntidadeNaoExistenteException {
        try {
            if (existeContacto(contacto)) {
                throw new EntidadeExistenteException("Contacto já associado a outro cliente!");
            }
            
            Cliente cliente = new Cliente(nome, email, contacto);
            em.persist(cliente);
        } catch (EntidadeExistenteException e) {
            throw e;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    public List<ClienteDTO> getAllClientes(){
        try {
            List<Cliente> clientes = (List<Cliente>) em.createNamedQuery("findAllClientes").getResultList();
            return copiarClientesParaDTOs(clientes);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
     private ClienteDTO copiarClienteParaDTO(Cliente cliente) {
        return new ClienteDTO(
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getContacto()
        );
    }
     
     private List<ClienteDTO> copiarClientesParaDTOs(List<Cliente> clientes) {
        List<ClienteDTO> dtos = new ArrayList<>();
        for (Cliente cliente : clientes) {
            dtos.add(copiarClienteParaDTO(cliente));
        }
        return dtos;
    }

    public boolean existeContacto(int contacto) {
        return em.find(Cliente.class, contacto) != null;
    }

    public void atualizar(String nome, int contacto, String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
