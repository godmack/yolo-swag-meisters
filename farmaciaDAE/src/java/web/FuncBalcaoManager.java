/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dtos.EncomendaDTO;
import dtos.VendaDTO;
import ejbs.EncomendaBean;
import ejbs.ProdutoBean;
import ejbs.StockBean;
import ejbs.TransferenciaBean;
import ejbs.VendaBean;
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
    private VendaBean vendaBean;
    
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
    
    public String criarVenda() {
        try {

            vendaBean.criarVenda(clienteID, farmaciaID, vendas);
            fornecedorNovo.reiniciar();
            return "admin_index?faces-redirect=true";
        } catch (EntidadeExistenteException e) {
            FacesExceptionHandler.tratarExcecaoBinding(e, e.getMessage(), componente, logger);
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema.", logger);
        }
        return "admin_fornecedores_criar";
    }
    
    public List<VendaDTO> getAllVendas() {
        try {
            return vendaBean.getAllVendas();
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema.", logger);
            return null;
        }
    }  
    
}
