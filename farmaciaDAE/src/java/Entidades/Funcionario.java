/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Entidades.GrupoUtilizador.GRUPO;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

/**
 *
 * @author Cristiano
 */
@Entity
@NamedQuery(name = "findAllFuncionarios", query = "SELECT d FROM Funcionario d ORDER BY d.nome")
public class Funcionario extends Utilizador implements Serializable {

    private boolean FuncBalcao;
    
    public Funcionario(){

    }    
    
    public Funcionario(String nome, String username,String password, String email, boolean eFuncBalcao, Farmacia farmacia){
        super(username, password, GRUPO.Funcionario, nome, email, farmacia);
        this.FuncBalcao = eFuncBalcao;
    }

    public boolean isFuncBalcao() {
        return FuncBalcao;
    }

    public void setFuncBalcao(boolean FuncBalcao) {
        this.FuncBalcao = FuncBalcao;
    }
    
}
