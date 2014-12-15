package dtos;


import java.io.Serializable;

public class FornecedorDTO  implements Serializable{

    private String laboratorio;
    private String email;
    private int telemovel;
    private String morada;

    public FornecedorDTO() {
    }

    public FornecedorDTO(String laboratorio, String email, int telemovel, String morada) {
        this.laboratorio = laboratorio;
        this.email = email;
        this.telemovel = telemovel;
        this.morada = morada;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(int telemovel) {
        this.telemovel = telemovel;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }
    
}
