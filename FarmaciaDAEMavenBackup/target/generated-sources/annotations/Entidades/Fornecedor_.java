package Entidades;

import Entidades.Farmacia;
import Entidades.ProdutoCatalogo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-05T08:33:15")
@StaticMetamodel(Fornecedor.class)
public class Fornecedor_ { 

    public static volatile ListAttribute<Fornecedor, ProdutoCatalogo> produtosCatalogo;
    public static volatile SingularAttribute<Fornecedor, Integer> telemovel;
    public static volatile SingularAttribute<Fornecedor, String> laboratorio;
    public static volatile SingularAttribute<Fornecedor, String> morada;
    public static volatile SingularAttribute<Fornecedor, String> email;
    public static volatile ListAttribute<Fornecedor, Farmacia> farmacias;

}