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
import excecoes.EntidadeNaoExistenteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Ruben
 */

@Stateless
public class StockBean {
    @PersistenceContext
    private EntityManager em;
    
    public void criarStock(int stockActual, int stockMinimo, int idProdutoCatalogo, Long idFarmacia) throws EntidadeExistenteException {
        try {

            Farmacia farmacia = em.find(Farmacia.class, idFarmacia);
            ProdutoCatalogo produtoCatalogo = em.find(ProdutoCatalogo.class, idProdutoCatalogo);
            
            if(existeStockFarmaciaProduto(farmacia,produtoCatalogo)){
                throw new EntidadeExistenteException("Já existe um stock nesta farmácia, deste produto");
            }
            
            Stock stock = new Stock(stockActual, stockMinimo, produtoCatalogo, farmacia);
            farmacia.addStock(stock);
            produtoCatalogo.addStock(stock);
            em.persist(stock);
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
    
    public List<StockDTO> getAllStocksFarmacia(Long farmaciaId) {
        try {
            Farmacia farmacia = em.find(Farmacia.class, farmaciaId);
            Query queryStocks = em.createNamedQuery(
            "findAllStocksFarmacia"
        );
        queryStocks.setParameter("farmacia", farmacia);
        List<Stock> stocks = queryStocks.getResultList();
            return copiarStockParaDTOs(stocks);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    private boolean existeStock(int id) {
         return em.find(Stock.class, id) != null;
   }
    
     private List<StockDTO> copiarStockParaDTOs(List<Stock> stocks) {

        List<StockDTO> dtos = new ArrayList();

        for (Stock stock : stocks) {
            dtos.add(new StockDTO(stock.getId(), stock.getStockActual(), stock.getStockMinimo(), stock.getProdutoCatalogo().getReferencia(), stock.getFarmacia().getIdFarmacia(), stock.getProdutoCatalogo().getNome(), stock.getProdutoCatalogo().getPreco()));
        }
        return dtos;
    }
     
      public void atualizar(int id, int stockAtual, int stockMinimo) throws EntidadeNaoExistenteException{
        try {
            Stock stock = em.find(Stock.class, id);
            if(stock == null){
                throw new EntidadeNaoExistenteException("Produto de Catalogo nao existente!");
            }
            stock.setStockActual(stockAtual);
            stock.setStockMinimo(stockMinimo);
            em.merge(stock);
        } catch (EntidadeNaoExistenteException e) {
            throw e;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
      
      private boolean existeStockFarmaciaProduto(Farmacia farmacia, ProdutoCatalogo produtoCatalogo){
        Query queryExisteStock = em.createNamedQuery(
            "findExisteStockFarmaciaProduto"
        );
        queryExisteStock.setParameter("farmacia", farmacia);
        queryExisteStock.setParameter("produtoCatalogo", produtoCatalogo);
        int numResults = queryExisteStock.getResultList().size();
        
        if(numResults > 0){
            return true;
        }
        return false;
      }
      
      public void atualizarVenda(int referenciaProdutoCatalogo, int quantidade, Long idVenda, Long idFarmacia){
          Farmacia farmacia = em.find(Farmacia.class, idFarmacia);
          ProdutoCatalogo produtoCatalogo = em.find(ProdutoCatalogo.class, idVenda);
          Query queryExisteStock = em.createNamedQuery(
            "findExisteStockFarmaciaProduto"
        );
        queryExisteStock.setParameter("farmacia", farmacia);
        queryExisteStock.setParameter("produtoCatalogo", produtoCatalogo);
        
        Stock stock = (Stock)queryExisteStock.getSingleResult();
        stock.setStockActual(stock.getStockActual()-quantidade);
      }
}
