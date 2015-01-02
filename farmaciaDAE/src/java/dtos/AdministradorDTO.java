package dtos;

import java.io.Serializable;

public class AdministradorDTO  implements Serializable{

    private String username;
    private String password;
    private String nome;
    private String email;

    public AdministradorDTO() {
    }    
    
    public AdministradorDTO(String username, String nome, String email) {
        this.username = username;     
        this.nome = nome;
        this.email = email;
    }
    
    public void reiniciar(){
        setUsername(null);
        setPassword(null);
        setEmail(null);
        setNome(null);
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

}
