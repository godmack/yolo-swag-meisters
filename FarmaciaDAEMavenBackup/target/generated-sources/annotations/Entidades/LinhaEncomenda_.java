package Entidades;

import Entidades.Encomenda;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-05T08:33:15")
@StaticMetamodel(LinhaEncomenda.class)
public class LinhaEncomenda_ extends Linhas_ {

    public static volatile SingularAttribute<LinhaEncomenda, Integer> quantidadeRecebida;
    public static volatile SingularAttribute<LinhaEncomenda, Encomenda> encomenda;

}