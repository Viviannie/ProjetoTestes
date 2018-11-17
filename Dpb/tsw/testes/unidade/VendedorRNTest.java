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

	public RNVendedor rnVend = new RNVendedor();

	@Before
	public void init() {

		this.rnVend = new RNVendedor();

	}

	@Test
	public void testValidarNome() {

		Vendedor vend = new Vendedor();

		vend.setNome("Annie Viviane Lessa da Cunha Santana Bezerra da Silva");

		try {

			assertTrue("Exceção validar Nome vendedor OK!", rnVend.validarNome(vend));

		} catch (RegraException e) {

			e.printStackTrace();

		}		
	}

	@Test
	public void testValidarCpf() {

		Vendedor vend = new Vendedor();

		vend.setCpf("123456789523");

		try {

			assertTrue("Exceção validar CPF vendedor OK!", rnVend.validarCpf(vend));

		} catch (RegraException e) {

			e.printStackTrace();

		}		
	}

	@Test
	public void testValidarEmail() {

		Vendedor vend = new Vendedor();

		vend.setEmail("annievivianelessadacunhasantanabezerradasilva@gmail.com");

		try {

			assertTrue("Exceção validar E-mail vendedor OK!", rnVend.validarEmail(vend));

		} catch (RegraException e) {

			e.printStackTrace();

		}	
	}
	
	@Test
	public void testValidarSenha() {

		Vendedor vend = new Vendedor();

		vend.setSenha("1234567891234dasdasdhasiuhadsahdsauhsdoiuahsddiuh564");

		try {

			assertTrue("Exceção validar Senha vendedor OK!", rnVend.validarSenha(vend));

		} catch (RegraException e) {

			e.printStackTrace();

		}		
	}

	@Test(expected = NullPointerException.class)
	public void testeClienteRegraException() {		

		Vendedor vend = new Vendedor();	

		vend.setCpf(null);
		vend.setNome(null);
		vend.setSenha(null);
		vend.setLogradouro(null);
		vend.setNumero(null);
		vend.setBairro(null);
		vend.setCidade(null);
		vend.setEstado(null);
		vend.setEmail(null);
		vend.setId(0);

		try {
			rnVend.incluir(vend);
		} catch (RegraException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals("Exceção validar RegraException vendedor OK!", rnVend);

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
			
			assertEquals("Exceção validar Duplicidade CNPJ vendedor OK!", rnVend.verificaDuplicidade(vend1), rnVend.verificaDuplicidade(vend2));
			
		} catch (RegraException e) {

			e.printStackTrace();
			
		}		
	}
	
	@Test
	public void testValidarId() {			

		try {
			rnVend.validaId(null);
		} catch (RegraException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals("Exceção validar ID vendedor OK!", rnVend);

	}

	@After
	public void limparCliente() {

		Vendedor vend = new Vendedor();

		vend = new Vendedor();		

	}
}
