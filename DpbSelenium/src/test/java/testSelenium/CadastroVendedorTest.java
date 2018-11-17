package testSelenium;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CadastroVendedorTest {

	private static WebDriver webDriver;
	private static CadastroVendedorPage cadastroVendedorPage;

	/**
	 * Driver Configurations
	 */ 
	private static final String PATH_CHROME_DRIVER			= ".\\lib\\chromedriver.exe";
	private static final String WEBDRIVER_CHROME_DRIVER		= "webdriver.chrome.driver";
//	private static final String PATH_FIREFOX_DRIVER			= "/../../../lib";
//	private static final String WEBDRIVER_FIREFOX_DRIVER	= "webdriver.gecko.driver";

	/**
	 * Values de WebElement Locators
	 */
	private static final String VALUE_INPUT_NOME       = "Daniel Gomes";
	private static final String VALUE_INPUT_CPF        = "22233344405";
	private static final String VALUE_INPUT_EMAIL      = "dgsfilho@gmail.com";
	private static final String VALUE_INPUT_SENHA      = "123456";
	private static final String VALUE_INPUT_LOGRADOURO = "RUA CACHOEIRA";
	private static final String VALUE_INPUT_NUMERO     = "95";
	private static final String VALUE_INPUT_BAIRRO     = "IMBIRIBEIRA";
	private static final String VALUE_INPUT_CIDADE     = "RECIFE";
	private static final String VALUE_INPUT_ESTADO     = "PE";
	private static final String VALUE_INPUT_ATIVO      = "S";

	@BeforeClass
	public static void setSystemPropertyChromeWebDriver() {
//		Paths.get("." + File.separator + "libs" + File.separator + "chromedriver");

		System.setProperty(
				WEBDRIVER_CHROME_DRIVER, 
				PATH_CHROME_DRIVER);

		webDriver = new ChromeDriver();

		cadastroVendedorPage = new CadastroVendedorPage(webDriver);
		cadastroVendedorPage.accessURL();
	}
	
	@Test
	public void testCadastroVendedor() {
		cadastroVendedorPage
		.preencherNome(VALUE_INPUT_NOME)
		.preencherCpf(VALUE_INPUT_CPF)
		.preencherEmail(VALUE_INPUT_EMAIL)
		.preencherSenha(VALUE_INPUT_SENHA)
		.preencherLogradouro(VALUE_INPUT_LOGRADOURO)
		.preencherNumero(VALUE_INPUT_NUMERO)
		.preencherBairro(VALUE_INPUT_BAIRRO)
		.preencherCidade(VALUE_INPUT_CIDADE)
		.preencherEstado(VALUE_INPUT_ESTADO)
		.preencherAtivo(VALUE_INPUT_ATIVO);

		cadastroVendedorPage.pressionarBotaoFormularioSalvarVendedor();
	}

	@AfterClass
	public static void closeDriver() {
		webDriver.close();
	}
}
