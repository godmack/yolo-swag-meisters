package ejbs;

import Entidades.Produto;
import dtos.ProdutoDTO;
import excecoes.EntidadeExistenteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJBException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ruben
 */
public class ProdutoBean {

    @PersistenceContext
    private EntityManager em;

    public void criarProduto(int lote, Date dataValidade) throws EntidadeExistenteException {
        try {
            if (existeProduto(lote)) {
                throw new EntidadeExistenteException("Produto já existente!");
            }
            em.persist(new Produto(lote, dataValidade));
        } catch (EntidadeExistenteException e) {
            throw e;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    public List<ProdutoDTO> getAllProdutos() {
        try {
            List<Produto> produtos = (List<Produto>) em.createNamedQuery("findAllProdutos").getResultList();
            return copiarProdutosParaDTOs(produtos);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    private boolean existeProduto(int lote) {
        return em.find(Produto.class, lote) != null;
    }
    
     private List<ProdutoDTO> copiarProdutosParaDTOs(List<Produto> produtos) {

        List<ProdutoDTO> dtos = new ArrayList<>();

        for (Produto produto : produtos) {
            dtos.add(new ProdutoDTO(produto.getLote(), produto.getDataValidade()));
        }
        return dtos;
    }

}
