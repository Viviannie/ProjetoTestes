package testes;

import model.classesbasicas.Cliente;
import model.dao.DAOClienteImpl;
import model.excecoes.ConexaoException;
import model.excecoes.DAOException;
import model.excecoes.RegraException;
import model.regra.RNCliente;

public class ClienteDAOTest {

	public void testIncluirCliente() {

		Cliente cli = new Cliente();
		DAOClienteImpl daoCli = new DAOClienteImpl();
//		RNCliente rnCli = new RNCliente();

		cli.setNomeFantasia("Copos Descartáveis do Brasil.");
		cli.setRazaoSocial("Copos Descartáveis Ltda.");
		cli.setEmail("coposdescartaveis@gmail.com");
		cli.setCnpj("54785698547412");
		cli.setLogradouro("Avenida Domingos Ferreira");
		cli.setNumero("352");
		cli.setBairro("Boa Viagem");
		cli.setCidade("Recife");
		cli.setEstado("PE");

		try {
			
			daoCli.incluir(cli);

		} catch (ConexaoException | DAOException e) {

			e.printStackTrace();

		}
	}
}