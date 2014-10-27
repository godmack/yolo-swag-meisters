/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author Cristiano
 */
@Entity
public class Funcionario extends Utilizador implements Serializable {

    private boolean FuncBalcao;
    
    public Funcionario(){

    }    
    
    public Funcionario(String nome, String username,String password, String email, boolean eFuncBalcao){
        super(username, password, nome, email);
        this.FuncBalcao = eFuncBalcao;
    }

    public boolean isFuncBalcao() {
        return FuncBalcao;
    }

    public void setFuncBalcao(boolean FuncBalcao) {
        this.FuncBalcao = FuncBalcao;
    }
    
}
