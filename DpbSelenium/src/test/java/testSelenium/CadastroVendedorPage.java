package testSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CadastroVendedorPage {

	private static final String ID_BOTAO_SALVAR = "btnSalvar";

	private WebDriver webDriver;

	/**
	 * URL's
	 */
	private static final String URL_CADASTRO_VENDEDOR = "http://localhost:8080/Dpb/cadastro_vendedor.jsp";

	/**
	 * WebElement for Cadastro Vendedor
	 */
	private static final String NAME_INPUT_NOME = "nome";
	private static final String NAME_INPUT_CPF = "cpf";
	private static final String NAME_INPUT_EMAIL = "email";
	private static final String NAME_INPUT_SENHA = "senha";
	private static final String NAME_INPUT_LOGRADOURO = "logradouro";
	private static final String NAME_INPUT_NUMERO = "numero";
	private static final String NAME_INPUT_BAIRRO = "bairro";
	private static final String NAME_INPUT_CIDADE = "cidade";
	private static final String NAME_INPUT_ESTADO = "estado";
	private static final String NAME_INPUT_ATIVO = "ativo";
	private static final String NAME_BOTAO_SALVAR = "btnSalvar";

	public void accessURL() {
		this.webDriver.get(URL_CADASTRO_VENDEDOR);
	}

	/**
	 * Valores para preencherWebElements
	 */

	/**
	 * HTML Tags and Attributes
	 */
	private static final String ATTRIBUTE_VALUE = "value";

	public CadastroVendedorPage(WebDriver pDriver) {
		this.webDriver = pDriver;
	}

	public CadastroVendedorPage preencherNome(String pNome) {
		preencherCampoInputPorName(NAME_INPUT_NOME, pNome);

		return this;
	}

	public CadastroVendedorPage preencherCpf(String pCpf) {
		preencherCampoInputPorName(NAME_INPUT_CPF, pCpf);

		return this;
	}

	public CadastroVendedorPage preencherEmail(String pEmail) {
		preencherCampoInputPorName(NAME_INPUT_EMAIL, pEmail);

		return this;
	}

	public CadastroVendedorPage preencherSenha(String pSenha) {
		preencherCampoInputPorName(NAME_INPUT_SENHA, pSenha);

		return this;
	}

	public CadastroVendedorPage preencherLogradouro(String pLogradouro) {
		preencherCampoInputPorName(NAME_INPUT_LOGRADOURO, pLogradouro);

		return this;
	}

	public CadastroVendedorPage preencherNumero(String pNumero) {
		preencherCampoInputPorName(NAME_INPUT_NUMERO, pNumero);

		return this;
	}

	public CadastroVendedorPage preencherBairro(String pBairro) {
		preencherCampoInputPorName(NAME_INPUT_BAIRRO, pBairro);

		return this;
	}

	public CadastroVendedorPage preencherCidade(String pCidade) {
		preencherCampoInputPorName(NAME_INPUT_CIDADE, pCidade);

		return this;
	}

	public CadastroVendedorPage preencherEstado(String pEstado) {
		preencherCampoInputPorName(NAME_INPUT_ESTADO, pEstado);

		return this;
	}

	public CadastroVendedorPage preencherAtivo(String pAtivo) {
		preencherCampoInputPorName(NAME_INPUT_ATIVO, pAtivo);

		return this;
	}

	// Botão Salvar
	public void pressionarBotaoFormularioSalvarVendedor() {
		this.webDriver.findElement(By.name(NAME_BOTAO_SALVAR)).submit();
	}

//	public void pressionarBotaoSalvar() {
//		this.webDriver.findElement(By.cssSelector(CSS_SELECTOR_BOTAO_SALVAR)).submit();
//		;
//	}

	private WebElement preencherCampoInputPorName(String pName, String pValor) {
		WebElement campo = webDriver.findElement(By.name(pName));

		// Limpa valores previamente digitados
		campo.clear();

		// Preenche o campo
		campo.sendKeys(pValor);

		return campo;
	}
}
