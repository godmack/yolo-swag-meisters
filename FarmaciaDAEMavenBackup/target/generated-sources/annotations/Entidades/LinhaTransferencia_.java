package Entidades;

import Entidades.Transferencia;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-05T08:33:15")
@StaticMetamodel(LinhaTransferencia.class)
public class LinhaTransferencia_ extends Linhas_ {

    public static volatile SingularAttribute<LinhaTransferencia, Integer> quantidadeRecebida;
    public static volatile SingularAttribute<LinhaTransferencia, Transferencia> transferencia;

}