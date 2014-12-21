package web;


import dtos.FarmaciaDTO;
import dtos.FuncionarioDTO;
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
            

    @EJB
    FarmaciaBean farmaciaBean;
    @EJB
    private UtilizadorBean utilizadorBean;
    @EJB
    private FuncionarioBean funcionarioBean;
    private static final Logger logger = Logger.getLogger("web.AdministradorManager");
    private UIComponent componente;


    public AdministradorManager() {

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
    
     public String criarFuncionario() {
        try {
            funcionarioBean.criarFuncionario(
                    funcionarioNovo.getUsername(),
                    funcionarioNovo.getPassword(),
                    funcionarioNovo.getNome(),
                    funcionarioNovo.getEmail(),
                    funcionarioNovo.getEFuncBalcao());
            funcionarioNovo.reiniciar();
            return "admin_estudantes_listar?faces-redirect=true";
        } catch (EntidadeExistenteException | EntidadeNaoExistenteException e) {
            FacesExceptionHandler.tratarExcecaoBinding(e, e.getMessage(), componente, logger);
        } catch (Exception e) {
            FacesExceptionHandler.tratarExcecao(e, "Erro do sistema.", logger);
        }
        return "admin_funcionarios_criar";
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
