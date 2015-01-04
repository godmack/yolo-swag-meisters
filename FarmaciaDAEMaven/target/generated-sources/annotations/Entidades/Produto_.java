package Entidades;

import Entidades.Farmacia;
import Entidades.ProdutoCatalogo;
import Entidades.Stock;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-04T21:02:59")
@StaticMetamodel(Produto.class)
public class Produto_ { 

    public static volatile SingularAttribute<Produto, Long> idProduto;
    public static volatile SingularAttribute<Produto, Date> dataValidade;
    public static volatile SingularAttribute<Produto, Integer> lote;
    public static volatile SingularAttribute<Produto, ProdutoCatalogo> produtoCatalogo;
    public static volatile SingularAttribute<Produto, Farmacia> farmacia;
    public static volatile SingularAttribute<Produto, Stock> stock;

}