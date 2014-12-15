package web;


import dtos.FarmaciaDTO;
import ejbs.FarmaciaBean;
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

    @EJB
    FarmaciaBean farmaciaBean;
    @EJB
    private UtilizadorBean utilizadorBean;
    private static final Logger logger = Logger.getLogger("web.AdministradorManager");


    public AdministradorManager() {

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

    
}
