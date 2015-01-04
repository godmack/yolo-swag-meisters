/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Entidades.GrupoUtilizador.GRUPO;
import java.io.Serializable;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author Cristiano
 */
@Entity
@NamedQueries({
@NamedQuery(name = "findAllUtilizadores", query = "SELECT d FROM Utilizador d"),
@NamedQuery(name = "findUtilizador", query = "SELECT d FROM Utilizador d WHERE d.username = :username AND d.password = :password ")})
@Table(name="UTILIZADOR")
public class Utilizador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String username;
    @NotNull
    private String password;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "utilizador")
    protected GrupoUtilizador grupo; 
    @NotNull
    protected String nome;
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            + "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
            message = "{invalid.email}")
    @NotNull
    protected String email;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ID_FARMACIA")
    private Farmacia farmacia;
    
    public Utilizador(){
        
    }

    public Utilizador(String username, String password, GRUPO grupo, String nome, String email, Farmacia farmacia) {
        this.username = username;
        this.password = hashPassword(password);
        this.grupo = new GrupoUtilizador(grupo, this);
        this.nome = nome;
        this.email = email;
        this.farmacia = farmacia;
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
        this.password = hashPassword(password);
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

    public GrupoUtilizador getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoUtilizador grupo) {
        this.grupo = grupo;
        grupo.setUtilizador(this);
    }
    
        @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Utilizador other = (Utilizador) obj;
        if ((this.username == null) ? (other.username != null) : !this.username.equals(other.username)) {
            return false;
        }
        return true;
    }
 
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.username != null ? this.username.hashCode() : 0);
        return hash;
    }
 
    @Override
    public String toString() {
        return "Utilizador: " + username;
    }
 
    private String hashPassword(String password) {
        char[] encoded = null;
        try {
            ByteBuffer passwdBuffer = Charset.defaultCharset().encode(CharBuffer.wrap(password));
            byte[] passwdBytes = passwdBuffer.array();
            MessageDigest mdEnc = MessageDigest.getInstance("SHA-256");
            mdEnc.update(passwdBytes, 0, password.toCharArray().length);
            encoded = new BigInteger(1, mdEnc.digest()).toString(16).toCharArray();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Utilizador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new String(encoded);
    }
    
    
    
    
    
}
