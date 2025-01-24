package kaique.luan.dev;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ ClienteServiceTest.class, ClienteDAOTest.class,
        ProdutoDAOTest.class, ProdutoDAOTest.class,
        VendaDAOTest.class})
public class AllTests {

}