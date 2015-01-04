package Entidades;

import Entidades.Farmacia;
import Entidades.Produto;
import Entidades.ProdutoCatalogo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-04T17:24:04")
@StaticMetamodel(Stock.class)
public class Stock_ { 

    public static volatile SingularAttribute<Stock, Integer> stockMinimo;
    public static volatile ListAttribute<Stock, Produto> produtos;
    public static volatile SingularAttribute<Stock, Integer> stockActual;
    public static volatile SingularAttribute<Stock, ProdutoCatalogo> produtoCatalogo;
    public static volatile SingularAttribute<Stock, Farmacia> farmacia;
    public static volatile SingularAttribute<Stock, Integer> id;

}