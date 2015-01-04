package Entidades;

import Entidades.Estado;
import Entidades.Farmacia;
import Entidades.LinhaTransferencia;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-04T17:24:04")
@StaticMetamodel(Transferencia.class)
public class Transferencia_ { 

    public static volatile SingularAttribute<Transferencia, Farmacia> farmaciaFornecedora;
    public static volatile SingularAttribute<Transferencia, Estado> estado;
    public static volatile SingularAttribute<Transferencia, Date> data;
    public static volatile SingularAttribute<Transferencia, Farmacia> farmacia;
    public static volatile SingularAttribute<Transferencia, Long> idTransferencia;
    public static volatile ListAttribute<Transferencia, LinhaTransferencia> linhasTransferencia;

}