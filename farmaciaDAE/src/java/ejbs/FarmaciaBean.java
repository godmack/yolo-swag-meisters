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

@Stateless
public class FarmaciaBean {

    @PersistenceContext
    private EntityManager em;

    public void criarFarmacia(String nome) throws EntidadeExistenteException{
        try {
            if(existeFarmacia(nome)){
                throw new EntidadeExistenteException("Farmacia já existente!");
            }            
            em.persist(new Farmacia(nome));
        } catch (EntidadeExistenteException e) {
            throw e;
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
       
    public boolean existeFarmacia(String nome){
        return em.find(Farmacia.class, nome) != null;
    }    

    private List<FarmaciaDTO> copiarFarmaciasParaDTOs(List<Farmacia> farmacias) {

        List<FarmaciaDTO> dtos = new ArrayList<>();

        for (Farmacia farmacia : farmacias) {
            dtos.add(new FarmaciaDTO(farmacia.getNome()));
        }
        return dtos;
    }
}
