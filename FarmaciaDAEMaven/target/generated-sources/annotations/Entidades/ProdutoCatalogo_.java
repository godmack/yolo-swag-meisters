package Entidades;

import Entidades.Fornecedor;
import Entidades.Produto;
import Entidades.Stock;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-04T21:02:59")
@StaticMetamodel(ProdutoCatalogo.class)
public class ProdutoCatalogo_ { 

    public static volatile SingularAttribute<ProdutoCatalogo, Double> preco;
    public static volatile SingularAttribute<ProdutoCatalogo, String> emailFornAlternativo;
    public static volatile SingularAttribute<ProdutoCatalogo, String> emailFornEleicao;
    public static volatile ListAttribute<ProdutoCatalogo, Produto> produtos;
    public static volatile ListAttribute<ProdutoCatalogo, Fornecedor> fornecedores;
    public static volatile SingularAttribute<ProdutoCatalogo, String> nome;
    public static volatile SingularAttribute<ProdutoCatalogo, String> laboratorio;
    public static volatile SingularAttribute<ProdutoCatalogo, Integer> referencia;
    public static volatile ListAttribute<ProdutoCatalogo, Stock> stocks;

}