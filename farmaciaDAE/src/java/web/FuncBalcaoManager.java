/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dtos.EncomendaDTO;
import ejbs.EncomendaBean;
import ejbs.ProdutoBean;
import ejbs.StockBean;
import ejbs.TransferenciaBean;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import utils.FacesExceptionHandler;

/**
 *
 * @author Ruben
 */
public class FuncBalcaoManager {
    
    @EJB
    private EncomendaBean encomendaBean;
    
    @EJB
    private StockBean stockBean;
    
    @EJB
    private ProdutoBean produtoBean;
    
    @EJB
    private TransferenciaBean transferenciaBean;
    private static final Logger logger = Logger.getLogger("web.FuncBalcaoManager");

    public FuncBalcaoManager() {
    }
    
    public List<EncomendaDTO> getAllEncomendas() {
        try {
            return encomendaBean.getAllEncomendas();
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema.", logger);
            return null;
        }
    }   
    
}
