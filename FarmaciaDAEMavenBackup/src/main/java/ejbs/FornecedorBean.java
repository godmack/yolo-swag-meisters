package ejbs;


import Entidades.Cliente;
import Entidades.Fornecedor;
import Entidades.Fornecedor;
import dtos.FornecedorDTO;
import dtos.FornecedorDTO;
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
public class FornecedorBean {

    @PersistenceContext
    private EntityManager em;
    @EJB
    FornecedorBean fornecedorBean;
    
    public FornecedorBean() {
    }
        
    public FornecedorBean(EntityManager em) {
        this.em = em;
    }

    public void criarFornecedor(String laboratorio, String email, int telemovel, String morada) throws EntidadeExistenteException, EntidadeNaoExistenteException {
        try {
            if (existeLaboratorio(laboratorio)) {
                throw new EntidadeExistenteException("Laboratorio já associado a outro fornecedor!");
            }
            System.out.println("FOCK");
            
            Fornecedor fornecedor = new Fornecedor(laboratorio, email, telemovel, morada);
            em.persist(fornecedor);
        } catch (EntidadeExistenteException e) {
            throw e;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    public List<FornecedorDTO> getAllFornecedores(){
        try {
            List<Fornecedor> fornecedores = (List<Fornecedor>) em.createNamedQuery("findAllFornecedores").getResultList();
            return copiarFornecedoresParaDTOs(fornecedores);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
     private FornecedorDTO copiarFornecedorParaDTO(Fornecedor fornecedor) {
        return new FornecedorDTO(
                fornecedor.getLaboratorio(),
                fornecedor.getEmail(),
                fornecedor.getTelemovel(),
                fornecedor.getMorada()
        );
    }
     
     private List<FornecedorDTO> copiarFornecedoresParaDTOs(List<Fornecedor> fornecedores) {
        List<FornecedorDTO> dtos = new ArrayList<>();
        for (Fornecedor fornecedor : fornecedores) {
            dtos.add(copiarFornecedorParaDTO(fornecedor));
        }
        return dtos;
    }

    public boolean existeLaboratorio(String laboratorio) {
        return em.find(Fornecedor.class, laboratorio) != null;
    }
    
     public void atualizar(String laboratorio, String email, int telemovel, String morada) throws EntidadeNaoExistenteException{
        try {
            Fornecedor fornecedor = em.find(Fornecedor.class, laboratorio);
            if(fornecedor == null){
                throw new EntidadeNaoExistenteException("Fornecedor nao existente!");
            }
            fornecedor.setLaboratorio(laboratorio);
            fornecedor.setEmail(email);
            fornecedor.setTelemovel(telemovel);
            fornecedor.setMorada(morada);
            em.merge(fornecedor);
        } catch (EntidadeNaoExistenteException e) {
            throw e;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

}
