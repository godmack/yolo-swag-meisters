/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice.service;

import ejbs.UtilizadorBean;
import java.util.List;
import javafx.scene.media.Media;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Ivo
 */
@Stateless
@Path("/farmacias")
public class FarmaciaWebserviceREST {

    @Inject
    UtilizadorBean utilizadorBean;
    
    public FarmaciaWebserviceREST() {
        super();
    }

    @POST
    @Path("/login")
    public String searchRecipes(@FormParam("username") String username, @FormParam("password") String password) {
        utilizadorBean.loginWebservice(username, password);
        return null;
    }
//    @POST
//    @Path("/login")
//    @Produces({"application/json"})
//    public String searchRecipes(@FormParam("username") String username, @FormParam("password") String password) {
//        utilizadorBean.loginWebservice(username, password);
//        return null;
//    }
}
