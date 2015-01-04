package utils;

import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

public class FacesExceptionHandler {

    public static void tratarExcecao(Exception e, String mensagemUI, Logger logger) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagemUI, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
        if(logger != null){
            logger.warning(e.getMessage());
        }
    }
    
    public static void tratarExcecaoBinding(Exception e, String mensagemUI, UIComponent componente, Logger logger) {
        FacesMessage message = new FacesMessage(mensagemUI);
        message.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(componente.getClientId(context), message);
        if(logger != null){
            logger.warning(e.getMessage());   
        }
    }
}
