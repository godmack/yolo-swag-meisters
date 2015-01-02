package ejbs;

import Entidades.Farmacia;
import Entidades.Fornecedor;
import excecoes.EntidadeExistenteException;
import excecoes.EntidadeNaoExistenteException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;

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
    
    @EJB
    private FuncionarioBean funcionarioBean;
    
    @PostConstruct
    public void popularBD() {

        try {

            //PERSISTIR
            
           farmaciaBean.criarFarmacia("rubacia");
            farmaciaBean.criarFarmacia("farmacia2");
            farmaciaBean.criarFarmacia("farmacia3");
            funcionarioBean.criarFuncionario("Andre Rosado", "andrerosado", "andrerosado@maildae.com", "123", true);
            funcionarioBean.criarFuncionario("Ruben Nunes", "rubennunes", "rubennunes@maildae.com", "123", false);
            funcionarioBean.criarFuncionario("Andre Cristiano", "andrecristiano", "andrecristiano@maildae.com", "123", true);
            fornecedorBean.criarFornecedor("ruboratorio","ruboratorio@gmail.com" , 917121212, "rua das pinhas");
            administradorBean.criarAdministrador("admin", "admin123", "Admin", "rubacia@gmail.com");

           
        } catch (EntidadeExistenteException | EntidadeNaoExistenteException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}

