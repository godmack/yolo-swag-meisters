package dtos;

import Entidades.Venda;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class ClienteDTO  implements Serializable{

    private int contacto;
    private String nome;
    private String email;
    private List<VendaDTO> vendas;

    public ClienteDTO() {
    }    
    
    public ClienteDTO(String nome, String email, int contacto) {
        this.nome = nome;
        this.email = email;
        this.contacto = contacto;
        this.vendas = new LinkedList();
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
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

    public List<VendaDTO> getVendas() {
        return vendas;
    }

    public void setVendas(List<VendaDTO> vendas) {
        this.vendas = vendas;
    }
    
    
}
