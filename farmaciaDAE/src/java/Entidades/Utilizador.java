/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author Cristiano
 */
@Entity
@NamedQuery(name = "findAllUtilizadores", query = "SELECT d FROM Utilizador d ORDER BY d.username")
@Table(name="UTILIZADORES")
public class Utilizador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String username;
    @NotNull
    private String password;
    @NotNull
    protected String nome;
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            + "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
            message = "{invalid.email}")
    @NotNull
    protected String email;
    @ManyToOne
    @JoinColumn(name="ID_FARMACIA")
    private Farmacia farmacia;
    
    public Utilizador(){
        
    }

    public Utilizador(String username, String password, String nome, String email) {
        this.username = username;
        this.password = password;
        this.nome = nome;
        this.email = email;
    }

    public Farmacia getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
