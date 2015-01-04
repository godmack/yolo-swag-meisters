package Entidades;

import Entidades.Cliente;
import Entidades.Farmacia;
import Entidades.LinhaVenda;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-04T21:02:59")
@StaticMetamodel(Venda.class)
public class Venda_ { 

    public static volatile SingularAttribute<Venda, Cliente> cliente;
    public static volatile ListAttribute<Venda, LinhaVenda> linhasVenda;
    public static volatile SingularAttribute<Venda, Date> data;
    public static volatile SingularAttribute<Venda, Farmacia> farmacia;
    public static volatile SingularAttribute<Venda, Long> idVenda;

}