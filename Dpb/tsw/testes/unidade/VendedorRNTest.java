package testes.unidade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.classesbasicas.Vendedor;
import model.excecoes.RegraException;
import model.regra.RNVendedor;

//@DisplayName("Testes de assertions para VendedorRN")
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

		try {

			assertTrue("Exceção validar Nome vendedor OK!", rnVend.validarNome(vend));

		} catch (RegraException e) {

			e.printStackTrace();

		}
	}

	@Test
	public void testValidarCpf() {

		vend.setCpf("123456789523");

		try {

			assertTrue("Exceção validar CPF vendedor OK!", rnVend.validarCpf(vend));

		} catch (RegraException e) {

			e.printStackTrace();

		}
	}

	@Test
	public void testValidarEmail() {

		vend.setEmail("annievivianelessadacunhasantanabezerradasilva@gmail.com");

		try {

			assertTrue("Exceção validar E-mail vendedor OK!", rnVend.validarEmail(vend));

		} catch (RegraException e) {

			e.printStackTrace();

		}
	}

	@Test
	public void testValidarSenha() {

		vend.setSenha("1234567891234dasdasdhasiuhadsahdsauhsdoiuahsddiuh564");

		try {

			assertTrue("Exceção validar Senha vendedor OK!", rnVend.validarSenha(vend));

		} catch (RegraException e) {

			e.printStackTrace();

		}
	}

	@Test(expected = NullPointerException.class)
	public void testeVendedorNullPointerException() {

		try {

			vend.setCpf(null);
			vend.setNome(null);
			vend.setSenha(null);
			vend.setLogradouro(null);
			vend.setNumero(null);
			vend.setBairro(null);
			vend.setCidade(null);
			vend.setEstado(null);
			vend.setEmail(null);
			vend.setId(idNull);

			rnVend.incluir(vend);

		} catch (RegraException e) {

			e.printStackTrace();

		}
	}

	@Test
	public void testValidarDuplicidadeCnpj() {

		Vendedor vend1 = new Vendedor();
		Vendedor vend2 = new Vendedor();

		vend1.setId(1);
		vend2.setId(1);

		try {

			rnVend.incluir(vend1);
			rnVend.incluir(vend2);

			assertEquals("Exceção validar Duplicidade CNPJ vendedor OK!", rnVend.verificaDuplicidade(vend1),
					rnVend.verificaDuplicidade(vend2));

		} catch (RegraException e) {

			e.printStackTrace();

		}
	}

	@Test(expected = NullPointerException.class)
	public void testValidarIdNull() {

		try {

			vend.setId(idNull);

			rnVend.validaIdNull(vend.getId());

		} catch (RegraException e) {

			e.printStackTrace();

		}
	}

	@After
	public void limparCliente() {

		vend = new Vendedor();

	}
}
