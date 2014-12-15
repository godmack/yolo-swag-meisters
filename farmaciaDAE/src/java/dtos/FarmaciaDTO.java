package dtos;

import java.io.Serializable;

public class FarmaciaDTO  implements Serializable{

    private Long idFarmacia;
    
    private String nome;

    public FarmaciaDTO() {
    }

    public FarmaciaDTO(String nome) {
        this.nome = nome;
    }

    public Long getIdFarmacia() {
        return idFarmacia;
    }

    public void setIdFarmacia(Long idFarmacia) {
        this.idFarmacia = idFarmacia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
