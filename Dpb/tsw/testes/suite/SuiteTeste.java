package testes.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testes.unidade.CategoriaRNTest;
import testes.unidade.ClienteRNTest;
import testes.unidade.PedidoItensRNTest;
import testes.unidade.PedidoRNTest;
import testes.unidade.ProdutoRNTest;
import testes.unidade.StatusPedidoRNTest;
import testes.unidade.VendedorRNTest;

@RunWith(Suite.class)
@SuiteClasses({CategoriaRNTest.class, 
			   ClienteRNTest.class, 
			   PedidoRNTest.class, 
			   PedidoItensRNTest.class,
			   ProdutoRNTest.class,
			   StatusPedidoRNTest.class,
			   VendedorRNTest.class
	})
public class SuiteTeste {
}
