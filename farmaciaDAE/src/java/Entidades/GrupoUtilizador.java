package Entidades;
 
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
 
@Entity(name = "GRUPOS_UTILIZADORES")
public class GrupoUtilizador implements Serializable {
 
    public static enum GRUPO {
        Administrador, Funcionario
    }
 
    @Id
    @Enumerated(EnumType.STRING)
    private GRUPO nomeGrupo;
 
    @Id
    @OneToOne
    @JoinColumn(name = "USERNAME")
    private Utilizador utilizador;
 
    public GrupoUtilizador() {
    }
 
    public GrupoUtilizador(GRUPO grupo, Utilizador utilizador) {
        this.nomeGrupo = grupo;
        this.utilizador = utilizador;
    }
 
 
    public GRUPO getNomeGrupo() {
        return nomeGrupo;
    }
 
    public void setNomeGrupo(GRUPO nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }
 
    public Utilizador getUtilizador() {
        return utilizador;
    }
 
    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GrupoUtilizador other = (GrupoUtilizador) obj;
        if (this.nomeGrupo != other.nomeGrupo) {
            return false;
        }
        if (this.utilizador != other.utilizador && (this.utilizador == null
        || !this.utilizador.equals(other.utilizador))) {
            return false;
        }
        return true;
    }
 
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (this.nomeGrupo != null ? this.nomeGrupo.hashCode() : 0);
        hash = 89 * hash + (this.utilizador != null ? this.utilizador.hashCode() : 0);
        return hash;
    }
 
    @Override
    public String toString() {
        return nomeGrupo.toString();
    }
}