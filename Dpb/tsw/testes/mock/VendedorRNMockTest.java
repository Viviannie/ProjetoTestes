package testes.mock;

import java.util.ArrayList;
import java.util.List;

import model.classesbasicas.Vendedor;

public class VendedorRNMockTest {
	
	private IVendedorMockTest iVendedorMockTest;

	public VendedorRNMockTest(IVendedorMockTest iVendedorMockTest) {

		this.iVendedorMockTest = iVendedorMockTest;

	}

	public List<Vendedor> allVend(Vendedor vendedor) {

		List<Vendedor> filtrarTodos = new ArrayList<Vendedor>();
		List<Vendedor> alls = iVendedorMockTest.AllVend(vendedor);

		for (Vendedor all : alls) {

			if (all.equals(vendedor)) {

				filtrarTodos.add(all);

			}
		}

		return filtrarTodos;

	}
}
