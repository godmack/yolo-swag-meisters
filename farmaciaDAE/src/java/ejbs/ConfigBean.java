package ejbs;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import excecoes.EntidadeExistenteException;
import excecoes.EntidadeNaoExistenteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import Entidades.Farmacia;
import Entidades.Fornecedor;
import dtos.FarmaciaDTO;
import dtos.FornecedorDTO;
import excecoes.EntidadeExistenteException;
import excecoes.EntidadeNaoExistenteException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Singleton
@Startup
public class ConfigBean implements Serializable {
    
    @EJB
    private EncomendaBean encomendaBean;
    @EJB
    private AdministradorBean administradorBean;
    
    @EJB
    private FarmaciaBean farmaciaBean;
    
    @EJB
    private FornecedorBean fornecedorBean;
    
    @EJB
    private UtilizadorBean uBean;

    @PostConstruct
    public void popularBD() {

        try {

            //PERSISTIR
            
            farmaciaBean.criarFarmacia("rubacia");
            farmaciaBean.criarFarmacia("farmacia2");
            farmaciaBean.criarFarmacia("farmacia3");
            //fornecedorBean.criarFornecedor("ruboratorio", "rua das pinhas", 917121212, "ruboratorio@gmail.com");

            administradorBean.criarAdministrador("admin", "admin123", "Admin", "rubacia@gmail.com");

           
        } catch (EntidadeExistenteException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}

