package dtos;

import java.io.Serializable;

public class UtilizadorDTO  implements Serializable{

    private String username;
    private String password;
    private String nome;
    private String email;
    private String farmacia;

    public UtilizadorDTO() {
    }    
    
    public UtilizadorDTO(String username, String nome, String email, String Farmacia) {
        this.username = username;     
        this.nome = nome;
        this.email = email;
        this.farmacia = farmacia;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
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

    public String getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(String farmacia) {
        this.farmacia = farmacia;
    }

 
}
