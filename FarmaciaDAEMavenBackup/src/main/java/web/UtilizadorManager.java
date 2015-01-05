package web;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class UtilizadorManager implements Serializable {

    public UtilizadorManager() {
    }

    /**
     * Verifica se existe algum utilizador autenticado.
     *
     * @return true se há algum utilizador autenticado e, falso em caso
     * contrário.
     */
    public boolean isSomeUserAuthenticated() {
        return FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal() != null;
    }

    /**
     * Verifica se o utilizador atual pertence a determinado role. Não é
     * utilizado neste projeto.
     *
     * @param role a verificar
     * @return boolean true se o utilizador atual pertencer ao role e false em
     * caso contrário.
     */
    public boolean isUserInRole(String role) {
        return (isSomeUserAuthenticated()
                && FacesContext.getCurrentInstance().getExternalContext().isUserInRole(role));
    }

    public String tratarLoginErrado() {
        if (isSomeUserAuthenticated()) {
            logout();
        }
        return "index.xhtml?faces-redirect=true";
    }

    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();

        // remove data from beans:
        for (String bean : context.getExternalContext().getSessionMap().keySet()) {
            context.getExternalContext().getSessionMap().remove(bean);
        }

        // destroy session:
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        session.invalidate();

        // using faces-redirect to initiate a new request:
        return "/index.xhtml?faces-redirect=true";
    }
}
