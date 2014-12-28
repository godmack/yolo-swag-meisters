package web;


import dtos.FarmaciaDTO;
import dtos.FuncionarioDTO;
import dtos.UtilizadorDTO;
import ejbs.FarmaciaBean;
import ejbs.FuncionarioBean;
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
public class AdministradorManager implements Serializable{
    
    private FuncionarioDTO funcionarioNovo;
    private FuncionarioDTO funcionarioAtual;
    
    private FarmaciaDTO farmaciaNovo;
    private FarmaciaDTO farmaciaAtual;
    
    @EJB
    FarmaciaBean farmaciaBean;
    @EJB
    private UtilizadorBean utilizadorBean;
    @EJB
    private FuncionarioBean funcionarioBean;
    private static final Logger logger = Logger.getLogger("web.AdministradorManager");
    private UIComponent componente;


    public AdministradorManager() {
        this.funcionarioNovo = new FuncionarioDTO();
        this.farmaciaNovo = new FarmaciaDTO();
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
            farmaciaBean.criarFarmacia( farmaciaNovo.getNome() );
            
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
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema.", logger);
        }
        return null;
    }

    public List<UtilizadorDTO> getUtilizadoresNaoPertencemFarmacia() {
        try {
            return utilizadorBean.getUtilizadoresNaoPertencemFarmacia(farmaciaAtual.getIdFarmacia());
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema.", logger);
        }
        return null;
    }

    public void atribuirUtilizadorFarmacia(ActionEvent event) {
        try {
            UIParameter param = (UIParameter) event.getComponent().findComponent("usernameUtilizador");
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

    
}
