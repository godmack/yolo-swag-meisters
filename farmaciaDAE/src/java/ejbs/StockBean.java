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
import dtos.ProdutoDTO;
import dtos.StockDTO;
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
public class StockBean {
    @PersistenceContext
    private EntityManager em;
    
    public void criarStock(int id, int stockActual, int stockMinimo, ProdutoCatalogo produtoCatalogo, Farmacia farmacia) throws EntidadeExistenteException {
        try {
            if (existeStock(id)) {
                throw new EntidadeExistenteException("Produto já existente!");
            }
            em.persist(new Stock(id, stockActual, stockMinimo, produtoCatalogo, farmacia));
        } catch (EntidadeExistenteException e) {
            throw e;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    public List<StockDTO> getAllStocks() {
        try {
            List<Stock> stocks = (List<Stock>) em.createNamedQuery("findAllStocks").getResultList();
            return copiarStockParaDTOs(stocks);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    private boolean existeStock(int id) {
         return em.find(Stock.class, id) != null;
   }
    
     private List<StockDTO> copiarStockParaDTOs(List<Stock> stocks) {

        List<StockDTO> dtos = new ArrayList<>();

        for (Stock stock : stocks) {
            dtos.add(new StockDTO(stock.getId(), stock.getStockActual(), stock.getStockMinimo(), stock.getProdutoCatalogo(), stock.getFarmacia()));
        }
        return dtos;
    }
}
