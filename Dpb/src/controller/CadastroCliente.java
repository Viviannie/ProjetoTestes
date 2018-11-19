package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.classesbasicas.Cliente;
import model.classesbasicas.Vendedor;
import model.regra.Fachada;

/**
 * Servlet implementation class CadastroCliente
 */
@WebServlet("/CadastroCliente")
public class CadastroCliente {
	private static final long serialVersionUID = 1L;

	Cliente cliente = new Cliente();
	Fachada fachada = new Fachada();

	RequestDispatcher rd = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		if (request.getParameter("action") != null) {

			if (request.getParameter("action").toString().equals("novo")) {

				request.setAttribute("action", "novo");

				rd = request.getRequestDispatcher("cadastro_cliente.jsp");

			}

			rd.forward(request, response);

		}
	}

	// Na página cadastro_cliente
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action").toString();

		if (action.equals("inserir")) {

			try {

				cliente.setRazaoSocial(request.getParameter("razaoSocial").toString());
				cliente.setNomeFantasia(request.getParameter("nomeFantasia").toString());
				cliente.setCnpj(request.getParameter("cnpj").toString());
				cliente.setLogradouro(request.getParameter("logradouro").toString());
				cliente.setNumero(request.getParameter("numero").toString());
				cliente.setBairro(request.getParameter("bairro").toString());
				cliente.setCidade(request.getParameter("cidade").toString());
				cliente.setEstado(request.getParameter("estado").toString());
				cliente.setEmail(request.getParameter("email").toString());

				fachada.salvarCliente(cliente);

				if (fachada != null) {

					System.out.println("Cliente salvo com sucesso!");

				}

				rd = request.getRequestDispatcher("mensagem_cliente.jsp");

			} catch (Exception e) {

				e.printStackTrace();

			}
		}

		rd.forward(request, response);

	}
}
