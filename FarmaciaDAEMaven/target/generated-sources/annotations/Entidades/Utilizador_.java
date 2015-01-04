package Entidades;

import Entidades.Farmacia;
import Entidades.GrupoUtilizador;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-04T21:02:59")
@StaticMetamodel(Utilizador.class)
public class Utilizador_ { 

    public static volatile SingularAttribute<Utilizador, String> password;
    public static volatile SingularAttribute<Utilizador, GrupoUtilizador> grupo;
    public static volatile SingularAttribute<Utilizador, String> nome;
    public static volatile SingularAttribute<Utilizador, Farmacia> farmacia;
    public static volatile SingularAttribute<Utilizador, String> email;
    public static volatile SingularAttribute<Utilizador, String> username;

}