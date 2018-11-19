package testes.unidade;

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

	@Test(expected = RegraException.class)
	public void testValidarNome() throws RegraException {

		vend.setNome("Annie Viviane Lessa da Cunha Santana Bezerra da Silva");

		rnVend.validarNome(vend);

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

	@Test(expected = RegraException.class)
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
		vend.setId(idNull);

		rnVend.incluir(vend);

	}

//	@Test
//	public void testValidarDuplicidadeCnpj() {
//
//		Vendedor vend1 = new Vendedor();
//		Vendedor vend2 = new Vendedor();
//
//		vend1.setId(1);
//		vend2.setId(1);
//
//		try {
//
//			rnVend.incluir(vend1);
//			rnVend.incluir(vend2);
//
//			assertEquals("Exceção validar Duplicidade CNPJ vendedor OK!", rnVend.verificaDuplicidade(vend1),
//					rnVend.verificaDuplicidade(vend2));
//
//		} catch (RegraException e) {
//
//			e.printStackTrace();
//
//		}
//	}

	@Test(expected = RegraException.class)
	public void testValidarIdNull() throws RegraException {

		vend.setId(idNull);

		rnVend.validaIdNull(vend.getId());

	}

	@After
	public void limparCliente() {

		vend = new Vendedor();

	}
}
