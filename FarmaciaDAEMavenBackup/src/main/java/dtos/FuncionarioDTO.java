package dtos;

import Entidades.Farmacia;
import ejbs.FarmaciaBean;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.ejb.EJB;

public class FuncionarioDTO  implements Serializable{

    private String username;
    private String password;
    private String nome;
    private String email;
    private boolean eFuncBalcao;
    private Long idFarmacia;
    private String farmaciaNome;

    public FuncionarioDTO() {
    }    
    
    public FuncionarioDTO(String username, String nome, String email, boolean eFuncBalcao, Long idFarmacia, String farmaciaNome) {
        this.username = username;     
        this.nome = nome;
        this.email = email;
        this.eFuncBalcao = eFuncBalcao;
        this.idFarmacia = idFarmacia;
        this.farmaciaNome = farmaciaNome;
    }
    
    public void reiniciar(){
        setUsername(null);
        setPassword(null);
        setEmail(null);
        setNome(null);
        setEFuncBalcao(true);
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

    public Long getIdFarmacia() {
        return idFarmacia;
    }

    public void setIdFarmacia(Long idFarmacia) {
        this.idFarmacia = idFarmacia;
    }

    public String getFarmaciaNome() {
        return farmaciaNome;
    }

    public void setFarmaciaNome(String farmaciaNome) {
        this.farmaciaNome = farmaciaNome;
    }
    

}
