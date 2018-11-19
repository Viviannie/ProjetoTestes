package testes.unidade;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.classesbasicas.Vendedor;
import model.excecoes.RegraException;
import model.regra.RNVendedor;

public class VendedorRNTest {

	public Vendedor vend;
	public RNVendedor rnVend;
	Integer idNull = null;

	@Before
	public void init() {

		this.vend = new Vendedor();
		this.rnVend = new RNVendedor();

	}

	@Test
	public void testValidarNome() {

		vend.setNome("Annie Viviane Lessa da Cunha Santana Bezerra da Silva");

		boolean retorno = rnVend.validarNome(vend);
		assertTrue(retorno);

	}

	@Test(expected = RegraException.class)
	public void testValidarCpf() throws RegraException {

		vend.setCpf("123456789523");

		rnVend.validarCpf(vend);

	}

	@Test(expected = RegraException.class)
	public void testValidarEmail() throws RegraException {

		vend.setEmail("annievivianelessadacunhasantanabezerradasilva@gmail.com");

		rnVend.validarEmail(vend);

	}

	@Test(expected = RegraException.class)
	public void testValidarSenha() throws RegraException {

		vend.setSenha("1234567891234dasdasdhasiuhadsahdsauhsdoiuahsddiuh564");

		rnVend.validarSenha(vend);

	}

	@Test(expected = NullPointerException.class)
	public void testeVendedorNullPointerException() throws RegraException {

		vend.setCpf(null);
		vend.setNome(null);
		vend.setSenha(null);
		vend.setLogradouro(null);
		vend.setNumero(null);
		vend.setBairro(null);
		vend.setCidade(null);
		vend.setEstado(null);
		vend.setEmail(null);

		rnVend.incluir(vend);

	}

	@After
	public void limparCliente() {

		vend = new Vendedor();

	}
}
