package dtos;

import java.io.Serializable;

public class UtilizadorDTO  implements Serializable{

    private String username;
    private String password;
    private String nome;
    private String email;
    private boolean eFuncBalcao;

    public UtilizadorDTO() {
    }    
    
    public UtilizadorDTO(String username, String nome, String email, boolean eFuncBalcao) {
        this.username = username;     
        this.nome = nome;
        this.email = email;
        this.eFuncBalcao = eFuncBalcao;
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

    public boolean getEFuncBalcao() {
        return eFuncBalcao;
    }

    public void setEFuncBalcao(boolean eFuncBalcao) {
        this.eFuncBalcao = eFuncBalcao;
    }
}
