package web;

import Entidades.ProdutoCatalogo;

import dtos.EncomendaDTO;
import dtos.AdministradorDTO;
import dtos.FarmaciaDTO;
import dtos.FornecedorDTO;
import dtos.FuncionarioDTO;
import dtos.LinhaEncomendaDTO;
import dtos.ProdutoCatalogoDTO;
import dtos.UtilizadorDTO;
import ejbs.AdministradorBean;
import ejbs.EncomendaBean;
import ejbs.FarmaciaBean;
import ejbs.FornecedorBean;
import ejbs.FuncionarioBean;
import ejbs.LinhaEncomendaBean;
import ejbs.ProdutoCatalogoBean;
import ejbs.UtilizadorBean;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import excecoes.EntidadeExistenteException;
import excecoes.EntidadeNaoExistenteException;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utils.FacesExceptionHandler;

@ManagedBean
@SessionScoped
public class AdministradorManager implements Serializable {

    private FuncionarioDTO funcionarioNovo;
    private FuncionarioDTO funcionarioAtual;

    private FarmaciaDTO farmaciaNovo;
    private FarmaciaDTO farmaciaAtual;

    private FornecedorDTO fornecedorNovo;
    private FornecedorDTO fornecedorAtual;

    private ProdutoCatalogoDTO pCatalogoNovo;
    private ProdutoCatalogoDTO pCatalogoAtual;

    private EncomendaDTO encomendaNova;
    private EncomendaDTO encomendaAtual;

    private AdministradorDTO administradorNovo;
    
    private LinhaEncomendaDTO linhaEncomendaNovo;
    
    
    @EJB
    FarmaciaBean farmaciaBean;
    @EJB
    private UtilizadorBean utilizadorBean;
    @EJB
    private FuncionarioBean funcionarioBean;
    @EJB
    private EncomendaBean encomendaBean;
    @EJB
    private FornecedorBean fornecedorBean;
    @EJB
    private AdministradorBean administradorBean;
    @EJB
    private ProdutoCatalogoBean produtoCatalogoBean;
    @EJB
    private LinhaEncomendaBean linhaEncomendaBean;
    private static final Logger logger = Logger.getLogger("web.AdministradorManager");
    private UIComponent componente;

    public AdministradorManager() {
        this.funcionarioNovo = new FuncionarioDTO();
        this.farmaciaNovo = new FarmaciaDTO();
        this.fornecedorNovo = new FornecedorDTO();
        this.pCatalogoNovo = new ProdutoCatalogoDTO();
        this.administradorNovo = new AdministradorDTO();
        this.linhaEncomendaNovo = new LinhaEncomendaDTO();
        this.encomendaNova = new EncomendaDTO();
    }

    public UIComponent getComponente() {
        return componente;
    }

    public void setComponente(UIComponent componente) {
        this.componente = componente;
    }

    ////////////// FARMACIAS ///////////////////
    public List<FarmaciaDTO> getFarmacias() {
        try {
            return farmaciaBean.getAllFarmacias();
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema: Não foi possível devolver a lista de farmacias.", logger);
            return null;
        }
    }

    public String criarFarmacia() {
        try {
            farmaciaBean.criarFarmacia(farmaciaNovo.getNome());

            farmaciaNovo.reiniciar();
            return "admin_farmacias_listar?faces-redirect=true";
        } catch (EntidadeExistenteException e) {
            FacesExceptionHandler.tratarExcecaoBinding(e, e.getMessage(), componente, logger);
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema.", logger);
        }
        return "admin_farmacias_criar";
    }

    public String atualizarFarmacia() {
        try {
            farmaciaBean.atualizar(farmaciaAtual.getIdFarmacia(), farmaciaAtual.getNome());
            return "admin_farmacias_listar?faces-redirect=true";
        } catch (EntidadeNaoExistenteException e) {
            FacesExceptionHandler.tratarExcecaoBinding(e, e.getMessage(), componente, logger);
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema.", logger);
        }
        return "admin_farmacias_editar";
    }

    public List<UtilizadorDTO> getUtilizadoresPertencemFarmacia() {
        try {
            return utilizadorBean.getUtilizadoresPertencemFarmacia(farmaciaAtual.getIdFarmacia());
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema LOL.", logger);
        }
        return null;
    }

    public List<UtilizadorDTO> getUtilizadoresNaoPertencemFarmacia() {
        try {
            return utilizadorBean.getUtilizadoresNaoPertencemFarmacia();
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema.", logger);
        }
        return null;
    }

    public void atribuirUtilizadorFarmacia(ActionEvent event) {
        try {
            System.out.println("entrou atribuirUtilizadorFarmacia");
            UIParameter param = (UIParameter) event.getComponent().findComponent("usernameFarmacia");
            System.out.println("Passou o component");
            String usernameUtilizador = param.getValue().toString();

            utilizadorBean.atribuirUtilizadorFarmacia(farmaciaAtual.getIdFarmacia(), usernameUtilizador);
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema.", logger);
        }
    }

    public void retirarUtilizadorFarmacia(ActionEvent event) {
        try {
            UIParameter param = (UIParameter) event.getComponent().findComponent("usernameUtilizador");
            String usernameUtilizador = param.getValue().toString();
            utilizadorBean.retirarUtilizadorFarmacia(farmaciaAtual.getIdFarmacia(), usernameUtilizador);
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema.", logger);
        }
    }

    public FarmaciaDTO getFarmaciaNovo() {
        return farmaciaNovo;
    }

    public void setFarmaciaNovo(FarmaciaDTO farmaciaNovo) {
        this.farmaciaNovo = farmaciaNovo;
    }

    public FarmaciaDTO getFarmaciaAtual() {
        return farmaciaAtual;
    }

    public void setFarmaciaAtual(FarmaciaDTO farmaciaAtual) {
        this.farmaciaAtual = farmaciaAtual;
    }

    ////////////// FUNCIONARIOS ///////////////////
    public List<FuncionarioDTO> getFuncionarios() {
        try {
            return funcionarioBean.getAllFuncionario();
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema: Não foi possível devolver a lista de utilizadores.", logger);
            return null;
        }
    }

    public FuncionarioDTO getFuncionarioNovo() {
        return funcionarioNovo;
    }

    public void setFuncionarioNovo(FuncionarioDTO funcionarioNovo) {
        this.funcionarioNovo = funcionarioNovo;
    }

    public FuncionarioDTO getFuncionarioAtual() {
        return funcionarioAtual;
    }

    public void setFuncionarioAtual(FuncionarioDTO funcionarioAtual) {
        this.funcionarioAtual = funcionarioAtual;
    }

    public String criarFuncionario() {
        try {
            funcionarioBean.criarFuncionario(
                    funcionarioNovo.getNome(),
                    funcionarioNovo.getUsername(),
                    funcionarioNovo.getEmail(),
                    funcionarioNovo.getPassword(),
                    funcionarioNovo.getEFuncBalcao());
            funcionarioNovo.reiniciar();
            return "admin_funcionarios_listar?faces-redirect=true";
        } catch (EntidadeExistenteException e) {
            FacesExceptionHandler.tratarExcecaoBinding(e, e.getMessage(), componente, logger);
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema.", logger);
        }
        return "admin_funcionarios_criar";
    }

    public String atualizarFuncionario() {
        try {
            funcionarioBean.atualizar(
                    funcionarioAtual.getUsername(),
                    funcionarioAtual.getNome(),
                    funcionarioAtual.getEmail());
            return "admin_funcionarios_listar?faces-redirect=true";
        } catch (EntidadeNaoExistenteException e) {
            FacesExceptionHandler.tratarExcecaoBinding(e, e.getMessage(), componente, logger);
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema.", logger);
        }
        return "admin_funcionarios_editar";
    }

    public void validarUsername(FacesContext context, UIComponent toValidate, Object value) {
        try {
            String username = (String) value;
            if (utilizadorBean.existeUsername(username)) {
                FacesMessage message = new FacesMessage("Erro: Já existe um utilizador com esse username.");
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                context.addMessage(toValidate.getClientId(context), message);
                ((UIInput) toValidate).setValid(false);
            }
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema.", logger);
        }
    }

    public String criarAdministrador() {
        try {
            administradorBean.criarAdministrador(
                     administradorNovo.getUsername(),
                    administradorNovo.getPassword(),
                    administradorNovo.getNome(),
                    administradorNovo.getEmail());
            administradorNovo.reiniciar();
            return "admin_funcionarios_listar?faces-redirect=true";
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema.", logger);
        }
        return "admin_administradores_criar";
    }

    public AdministradorDTO getAdministradorNovo() {
        return administradorNovo;
    }

    public void setAdministradorNovo(AdministradorDTO administradorNovo) {
        this.administradorNovo = administradorNovo;
    }
      
      
     
      ////////////// Fornecedores ///////////////////
    public List<FornecedorDTO> getFornecedores() {
        try {
            return fornecedorBean.getAllFornecedores();
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema: Não foi possível devolver a lista de fornecedores.", logger);
            return null;
        }
    }

    public String criarFornecedor() {
        try {

            fornecedorBean.criarFornecedor(fornecedorNovo.getLaboratorio(), fornecedorNovo.getEmail(), fornecedorNovo.getTelemovel(), fornecedorNovo.getMorada());
            fornecedorNovo.reiniciar();
            return "admin_index?faces-redirect=true";
        } catch (EntidadeExistenteException e) {
            FacesExceptionHandler.tratarExcecaoBinding(e, e.getMessage(), componente, logger);
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema.", logger);
        }
        return "admin_fornecedores_criar";
    }

    public String atualizarFornecedor() {
        try {
            fornecedorBean.atualizar(
                    fornecedorAtual.getLaboratorio(),
                    fornecedorAtual.getEmail(),
                    fornecedorAtual.getTelemovel(),
                    fornecedorAtual.getMorada());
            return "admin_fornecedores_listar?faces-redirect=true";
        } catch (EntidadeNaoExistenteException e) {
            FacesExceptionHandler.tratarExcecaoBinding(e, e.getMessage(), componente, logger);
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema.", logger);
        }
        return "admin_funcionarios_editar";
    }

    public FornecedorDTO getFornecedorNovo() {
        return fornecedorNovo;
    }

    public void setFornecedorNovo(FornecedorDTO fornecedorNovo) {
        this.fornecedorNovo = fornecedorNovo;
    }

    public FornecedorDTO getFornecedorAtual() {
        return fornecedorAtual;
    }

    public void setFornecedorAtual(FornecedorDTO fornecedorAtual) {
        this.fornecedorAtual = fornecedorAtual;
    }

    
    
    
    /************PRODUTO CATALOGO*****************/
    
    public List<ProdutoCatalogoDTO> getProdutosCatalogo() {
        try {
            return produtoCatalogoBean.getAllProdutoCatalogo();
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema: Não foi possível devolver a lista de produtos no catalogo.", logger);
            return null;
        }
    }
    
     public String criarProdutoCatalogo() {
        try {
            produtoCatalogoBean.criarProdutoCatalogo(
                    pCatalogoNovo.getReferencia(),
                    pCatalogoNovo.getNome(),
                    pCatalogoNovo.getLaboratorio(),
                    pCatalogoNovo.getPreco());
            pCatalogoNovo.reiniciar();
            return "admin_produtocatalogo_listar?faces-redirect=true";
        } catch (EntidadeExistenteException e) {
            FacesExceptionHandler.tratarExcecaoBinding(e, e.getMessage(), componente, logger);
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema.", logger);
        }
        return "admin_produtoCatalogo_criar";
    }

    public String atualizarProdutoCatalogo() {
        try {
            produtoCatalogoBean.atualizar(
                    pCatalogoAtual.getReferencia(),
                    pCatalogoAtual.getNome(),
                    pCatalogoAtual.getLaboratorio(),
                    pCatalogoAtual.getPreco());
            return "admin_produtocatalogo_listar?faces-redirect=true";
        } catch (EntidadeNaoExistenteException e) {
            FacesExceptionHandler.tratarExcecaoBinding(e, e.getMessage(), componente, logger);
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema.", logger);
        }
        return "admin_produtocatalogo_editar";
    }


    /**
     * **********ENCOMENDAS***************
     */
    public List<EncomendaDTO> getEncomendas() {
        try {
            return encomendaBean.getAllEncomendas();
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema.", logger);
            return null;
        }
    }

    public String criarEncomenda() {
        try {
            encomendaBean.criarEncomenda(encomendaNova.getFornecedor(), encomendaNova.getFarmacia());
            encomendaNova.reiniciar();
            return "admin_encomendas_listar?faces-redirect=true";
        } catch (EntidadeExistenteException e) {
            FacesExceptionHandler.tratarExcecaoBinding(e, e.getMessage(), componente, logger);
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema.", logger);
        }
        return "admin_encomendas_criar";
    }
    
     public EncomendaDTO getEncomendaNova() {
        return encomendaNova;
    }

    public void setEncomendaDTO(EncomendaDTO encomendaNova) {
        this.encomendaNova = encomendaNova;
    }
    

    public String atualizarEncomenda() {
        try {
            encomendaBean.atualizar(encomendaAtual.getFornecedor(), encomendaAtual.getFarmacia(), encomendaAtual.getIdEncomenda());

            return "admin_encomendas_listar?faces-redirect=true";
        } catch (EntidadeNaoExistenteException e) {
            FacesExceptionHandler.tratarExcecaoBinding(e, e.getMessage(), componente, logger);
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema.", logger);
        }
        return "admin_encomendas_editar";
        
    }

    public EncomendaDTO getEncomendaAtual() {
        return encomendaAtual;
    }

    public void setEncomendaAtual(EncomendaDTO encomendaAtual) {
        this.encomendaAtual = encomendaAtual;
    }
    
    
    


    public ProdutoCatalogoDTO getpCatalogoNovo() {
        return pCatalogoNovo;
    }

    public void setpCatalogoNovo(ProdutoCatalogoDTO pCatalogoNovo) {
        this.pCatalogoNovo = pCatalogoNovo;
    }

    public ProdutoCatalogoDTO getpCatalogoAtual() {
        return pCatalogoAtual;
    }

    public void setpCatalogoAtual(ProdutoCatalogoDTO pCatalogoAtual) {
        this.pCatalogoAtual = pCatalogoAtual;
    }

    /*********LINHA ENCOMENDA**************/
    
    public String criarLinhaEncomenda() {
        try {
            linhaEncomendaBean.criarLinhaEncomenda(encomendaAtual.getIdEncomenda(), linhaEncomendaNovo.getCodigoProdutoCatalogo(), linhaEncomendaNovo.getQuantidade());
            
            farmaciaNovo.reiniciar();
            return "admin_encomendas_editar?faces-redirect=true";
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema.", logger);
        }
        return "admin_linhaencomenda_criar";
    }
    
    public List<LinhaEncomendaDTO> getLinhasPertencemEncomenda() {
        try {
            return linhaEncomendaBean.getLinhasDeUmaEncomenda(encomendaAtual.getIdEncomenda());
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema.", logger);
        }
        return null;
    }
    
        public void retirarLinhaEncomenda(ActionEvent event) {
        try {
            UIParameter param = (UIParameter) event.getComponent().findComponent("linhaEncomenda2");
            int codigoProduto = Integer.valueOf(param.getValue().toString());
            linhaEncomendaBean.removerLinhaEncomenda(encomendaAtual.getIdEncomenda(), codigoProduto);
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema.", logger);
        }
    }

    public LinhaEncomendaDTO getLinhaEncomendaNovo() {
        return linhaEncomendaNovo;
    }

    public void setLinhaEncomendaNovo(LinhaEncomendaDTO linhaEncomendaNovo) {
        this.linhaEncomendaNovo = linhaEncomendaNovo;
    }
  
 
}
