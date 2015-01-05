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

    @EJB
    private ProdutoCatalogoBean pCatalogoBean;
    
    @EJB
    private ClienteBean clienteBean;

    @PostConstruct
    public void popularBD() {

        try {

            //PERSISTIR
            farmaciaBean.criarFarmacia("rubacia");
            farmaciaBean.criarFarmacia("farmacia2");
            farmaciaBean.criarFarmacia("farmacia3");
            //funcionarioBean.criarFuncionario("Andre Rosado", "andrerosado", "andrerosado@maildae.com", "123", true, null);
            //funcionarioBean.criarFuncionario("Ruben Nunes", "rubennunes", "rubennunes@maildae.com", "123", false, null);
            //funcionarioBean.criarFuncionario("Andre Cristiano", "andrecristiano", "andrecristiano@maildae.com", "123", true, null);
            fornecedorBean.criarFornecedor("ruboratorio", "ruboratorio@gmail.com", 917121212, "rua das pinhas");
            fornecedorBean.criarFornecedor("andrisFêos", "ruben.n147@gmail.com", 917121212, "rua das pinhas");
            administradorBean.criarAdministrador("admin", "admin123", "Admin", "rubacia@gmail.com", (long) 1);
            pCatalogoBean.criarProdutoCatalogo(123, "ben u ron", "Bayer", 5.0);
            pCatalogoBean.criarProdutoCatalogo(456, "voltaren", "Lab Medicamentos", 7.5);
            clienteBean.criarCliente("Anónimo", "", 000000000);
            clienteBean.criarCliente("Joao", "", 000000001);

        } catch (EntidadeExistenteException | EntidadeNaoExistenteException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
