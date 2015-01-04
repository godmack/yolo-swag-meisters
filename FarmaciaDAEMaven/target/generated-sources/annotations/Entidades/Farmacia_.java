package Entidades;

import Entidades.Encomenda;
import Entidades.Fornecedor;
import Entidades.Funcionario;
import Entidades.Produto;
import Entidades.Stock;
import Entidades.Transferencia;
import Entidades.Utilizador;
import Entidades.Venda;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-04T17:24:04")
@StaticMetamodel(Farmacia.class)
public class Farmacia_ { 

    public static volatile ListAttribute<Farmacia, Transferencia> transferenciasRecebidas;
    public static volatile SingularAttribute<Farmacia, Long> idFarmacia;
    public static volatile ListAttribute<Farmacia, Produto> produtos;
    public static volatile ListAttribute<Farmacia, Fornecedor> fornecedores;
    public static volatile ListAttribute<Farmacia, Transferencia> transferenciasEnviadas;
    public static volatile ListAttribute<Farmacia, Utilizador> utilizadores;
    public static volatile ListAttribute<Farmacia, Venda> vendas;
    public static volatile ListAttribute<Farmacia, Encomenda> encomendas;
    public static volatile SingularAttribute<Farmacia, String> nome;
    public static volatile ListAttribute<Farmacia, Funcionario> funcionarios;
    public static volatile ListAttribute<Farmacia, Stock> stocks;

}