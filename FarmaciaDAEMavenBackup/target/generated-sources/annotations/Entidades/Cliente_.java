package Entidades;

import Entidades.Venda;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-05T08:33:15")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, Integer> contacto;
    public static volatile SingularAttribute<Cliente, String> email;
    public static volatile ListAttribute<Cliente, Venda> vendas;
    public static volatile SingularAttribute<Cliente, String> nome;

}