package ejbs;

import Entidades.Farmacia;
import dtos.FarmaciaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import excecoes.EntidadeExistenteException;
import excecoes.EntidadeNaoExistenteException;

@Stateless
public class FarmaciaBean {

    @PersistenceContext
    private EntityManager em;

    public void criarFarmacia( String nome) throws EntidadeExistenteException{
        try {          
            em.persist(new Farmacia(nome));
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    public List<FarmaciaDTO> getAllFarmacias() {
        try {
            List<Farmacia> farmacias = (List<Farmacia>) em.createNamedQuery("findAllFarmacias").getResultList();
            return copiarFarmaciasParaDTOs(farmacias);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
       
    public boolean existeFarmacia(Long id){
        return em.find(Farmacia.class, id) != null;
    }    

    private List<FarmaciaDTO> copiarFarmaciasParaDTOs(List<Farmacia> farmacias) {

        List<FarmaciaDTO> dtos = new ArrayList<>();

        for (Farmacia farmacia : farmacias) {
            System.out.println(farmacia.getIdFarmacia());
            System.out.println(farmacia.getNome());
                    
            dtos.add(new FarmaciaDTO(farmacia.getIdFarmacia(), farmacia.getNome()));
        }
        return dtos;
    }
       
    
    public void atualizar(Long id, String nome) throws EntidadeNaoExistenteException{
        try {
            Farmacia farmacia = em.find(Farmacia.class, id);
            if(farmacia == null){
                throw new EntidadeNaoExistenteException("Farmacia nao existente!");
            }
            farmacia.setNome(nome);
            em.merge(farmacia);
        } catch (EntidadeNaoExistenteException e) {
            throw e;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
}
