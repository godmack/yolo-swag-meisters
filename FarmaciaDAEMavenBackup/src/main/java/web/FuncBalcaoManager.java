/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import Entidades.Estado;
import Entidades.LinhaVenda;
import dtos.ClienteDTO;
import dtos.EncomendaDTO;
import dtos.LinhaVendaDTO;
import dtos.ProdutoCatalogoDTO;
import dtos.StockDTO;
import dtos.VendaDTO;
import ejbs.ClienteBean;
import ejbs.EncomendaBean;
import ejbs.LinhaVendaBean;
import ejbs.ProdutoCatalogoBean;
import ejbs.StockBean;
import ejbs.VendaBean;
import excecoes.EntidadeExistenteException;
import excecoes.EntidadeNaoExistenteException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import utils.FacesExceptionHandler;

/**
 *
 * @author Ruben
 */
@ManagedBean
@SessionScoped
public class FuncBalcaoManager implements Serializable {
    

    
    @EJB
    private EncomendaBean encomendaBean;
    
    @EJB
    private VendaBean vendaBean;
    private VendaDTO vendaNovo;
    private VendaDTO vendaAtual;
    
    @EJB
    private ClienteBean clienteBean;
    private ClienteDTO clienteNovo;
    private ClienteDTO clienteAtual;
    
    @EJB
    private LinhaVendaBean linhaVendaBean;
    
    @EJB
    private StockBean stockBean;
    
    @EJB
    private ProdutoCatalogoBean produtoCatalogoBean;
    
    private LinhaVendaDTO linhaVendaNovo;
    private VendaDTO VendaAtual;
    private static final Logger logger = Logger.getLogger("web.FuncBalcaoManager");
   
    
     private UIComponent componente;

    public UIComponent getComponente() {
        return componente;
    }

    public void setComponente(UIComponent componente) {
        this.componente = componente;
    }
     
     

    public FuncBalcaoManager() {
        this.vendaNovo = new VendaDTO();
        this.linhaVendaNovo = new LinhaVendaDTO();
    }
    
    public String criarVenda() {
        try {
            
            vendaBean.criarVenda(vendaNovo.getCliente());
            vendaNovo.reiniciar();
            return "vendas_listar?faces-redirect=true";
        } catch (EntidadeExistenteException e) {
            FacesExceptionHandler.tratarExcecaoBinding(e, e.getMessage(), componente, logger);
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema.", logger);
        }
        return "vendas_criar";
    }
    
    public List<VendaDTO> getVendas() {
        try {
            return vendaBean.getAllVendas();
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema.", logger);
            return null;
        }
    }
    

    
    public String confirmarVenda(){
        try {
                vendaBean.confirmar(vendaAtual.getIdVenda());
                List<LinhaVendaDTO> lvs = vendaAtual.getLinhasVenda();
            for (LinhaVendaDTO lv : lvs) {
                stockBean.atualizarVenda(lv.getCodigoProdutoCatalogo(),lv.getQuantidade(),lv.getCodigoVenda(), vendaAtual.getFarmacia());
            }
            } catch (EntidadeNaoExistenteException e) {
                FacesExceptionHandler.tratarExcecaoBinding(e, e.getMessage(), componente, logger);
            } catch (Exception e) {
                FacesExceptionHandler.tratarExcecao(e, "Erro do sistema.", logger);
            }
        return "vendas_listar?faces-redirect=true";
    
    }

    public VendaDTO getVendaNovo() {
        return vendaNovo;
    }

    public void setVendaNovo(VendaDTO vendaNovo) {
        this.vendaNovo = vendaNovo;
    }

    public VendaDTO getVendaAtual() {
        return vendaAtual;
    }

    public void setVendaAtual(VendaDTO vendaAtual) {
        this.vendaAtual = vendaAtual;
    }
    
    
    
    /********* LINHA VENDA ***************/
    
    public String criarLinhaVenda() {
        try {
            if(vendaAtual.getEstado() != Estado.Rascunho){
                throw new Exception("Já não é possivel alterar a encomenda");
            }
            linhaVendaBean.criarLinhaVenda(vendaAtual.getIdVenda(), linhaVendaNovo.getCodigoProdutoCatalogo(),linhaVendaNovo.getQuantidade());
            return "vendas_editar?faces-redirect=true";
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, e.getMessage(), logger);
        }
        return "linhavenda_criar";
    }
    
    public List<LinhaVendaDTO> getLinhasPertencemVenda() {
        try {
            return linhaVendaBean.getLinhasDeUmaVenda(vendaAtual.getIdVenda());
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema.", logger);
        }
        return null;
    }
    
        public void retirarLinhaVenda(ActionEvent event) {
        try {
            UIParameter param = (UIParameter) event.getComponent().findComponent("linhaVenda2");
            int codigoProduto = Integer.valueOf(param.getValue().toString());
            linhaVendaBean.removerLinhaVenda(vendaAtual.getIdVenda(), codigoProduto);
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema.", logger);
        }
    }
        
        public List<StockDTO> getProdutosCatalogoEmStock(){
        try {
            List<StockDTO> stocks = stockBean.getAllStocksFarmacia(vendaAtual.getFarmacia());
            
                
            return stocks;
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema: Não foi possível devolver a lista de produtos no catalogo.", logger);
            return null;
        }
        
        }

    public LinhaVendaDTO getLinhaVendaNovo() {
        return linhaVendaNovo;
    }

    public void setLinhaVendaNovo(LinhaVendaDTO linhaVendaNovo) {
        this.linhaVendaNovo = linhaVendaNovo;
    }
    
    
         ////////////// Clientes ///////////////////
    public List<ClienteDTO> getClientes() {
        try {
            return clienteBean.getAllClientes();
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema.", logger);
            return null;
        }
    }

    public String criarCliente() {
        try {

            clienteBean.criarCliente(clienteNovo.getEmail(), clienteNovo.getNome(), clienteNovo.getContacto());
            clienteNovo.reiniciar();
            return "balcao_index?faces-redirect=true";
        } catch (EntidadeExistenteException e) {
            FacesExceptionHandler.tratarExcecaoBinding(e, e.getMessage(), componente, logger);
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema.", logger);
        }
        return "admin_fornecedores_criar";
    }

    public String atualizarCliente() {
        try {
            clienteBean.atualizar(
                    clienteNovo.getNome(),
                    clienteNovo.getContacto(),
                    clienteNovo.getEmail());
            clienteNovo.reiniciar();
            return "clientes_listar?faces-redirect=true";
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema.", logger);
        }
        return "clientes_editar";
    }

    public ClienteDTO getClienteNovo() {
        return clienteNovo;
    }

    public void setClienteNovo(ClienteDTO clienteNovo) {
        this.clienteNovo = clienteNovo;
    }

    public ClienteDTO getClienteAtual() {
        return clienteAtual;
    }

    public void setClienteAtual(ClienteDTO clienteAtual) {
        this.clienteAtual = clienteAtual;
    }


    
    
    
    public void showUser(){
        System.out.println(FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName());
        System.out.println(FacesContext.getCurrentInstance().getExternalContext().getRemoteUser());
    }
    
    
    
}
