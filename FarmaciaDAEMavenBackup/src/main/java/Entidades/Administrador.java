/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Entidades.GrupoUtilizador.GRUPO;
import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author Cristiano
 */
@Entity
public class Administrador extends Utilizador  implements Serializable {
  
    
    public Administrador(){
        
    }
    
    public Administrador(String userName, String password, String nome, String email, Farmacia farmacia){
       super(userName, password, GRUPO.Administrador, nome, email, farmacia);
    }
    
}
