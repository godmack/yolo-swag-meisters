package dtos;

import Entidades.Venda;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class FarmaciaDTO  implements Serializable{

    private Long idFarmacia;
    
    private String nome;
    private List<ProdutoDTO> produtos;
    private List<UtilizadorDTO> utilizadores;
    private List<Venda> vendas;
    private List<EncomendaDTO> encomendas;
    private List<StockDTO> stocks;
    private List<FornecedorDTO> fornecedores;
    private List<TransferenciaDTO> transferenciasEnviadas;
    private List<TransferenciaDTO> transferenciasRecebidas;

    public FarmaciaDTO() {
        this.produtos = new LinkedList();
        this.utilizadores = new LinkedList();
        this.vendas = new LinkedList();
        this.encomendas = new LinkedList();
        this.stocks = new LinkedList();
        this.fornecedores = new LinkedList();
        this.transferenciasEnviadas = new LinkedList();
        this.transferenciasRecebidas = new LinkedList();
    }

    public FarmaciaDTO(String nome) {
        this.nome = nome;
        this.produtos = new LinkedList();
        this.utilizadores = new LinkedList();
        this.vendas = new LinkedList();
        this.encomendas = new LinkedList();
        this.stocks = new LinkedList();
        this.fornecedores = new LinkedList();
        this.transferenciasEnviadas = new LinkedList();
        this.transferenciasRecebidas = new LinkedList();
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

    public List<ProdutoDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoDTO> produtos) {
        this.produtos = produtos;
    }

    public List<UtilizadorDTO> getUtilizadores() {
        return utilizadores;
    }

    public void setUtilizadores(List<UtilizadorDTO> utilizadores) {
        this.utilizadores = utilizadores;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public List<EncomendaDTO> getEncomendas() {
        return encomendas;
    }

    public void setEncomendas(List<EncomendaDTO> encomendas) {
        this.encomendas = encomendas;
    }

    public List<StockDTO> getStocks() {
        return stocks;
    }

    public void setStocks(List<StockDTO> stocks) {
        this.stocks = stocks;
    }

    public List<FornecedorDTO> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(List<FornecedorDTO> fornecedores) {
        this.fornecedores = fornecedores;
    }

    public List<TransferenciaDTO> getTransferenciasEnviadas() {
        return transferenciasEnviadas;
    }

    public void setTransferenciasEnviadas(List<TransferenciaDTO> transferenciasEnviadas) {
        this.transferenciasEnviadas = transferenciasEnviadas;
    }

    public List<TransferenciaDTO> getTransferenciasRecebidas() {
        return transferenciasRecebidas;
    }

    public void setTransferenciasRecebidas(List<TransferenciaDTO> transferenciasRecebidas) {
        this.transferenciasRecebidas = transferenciasRecebidas;
    }

    
    
    
}
