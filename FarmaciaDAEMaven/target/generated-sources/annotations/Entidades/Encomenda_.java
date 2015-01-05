package Entidades;

import Entidades.Estado;
import Entidades.Farmacia;
import Entidades.Fornecedor;
import Entidades.LinhaEncomenda;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-05T00:19:52")
@StaticMetamodel(Encomenda.class)
public class Encomenda_ { 

    public static volatile SingularAttribute<Encomenda, Long> idEncomenda;
    public static volatile SingularAttribute<Encomenda, Estado> estado;
    public static volatile SingularAttribute<Encomenda, Date> data;
    public static volatile SingularAttribute<Encomenda, Farmacia> farmacia;
    public static volatile SingularAttribute<Encomenda, Fornecedor> fornecedor;
    public static volatile ListAttribute<Encomenda, LinhaEncomenda> linhasEncomenda;

}