package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.classesbasicas.Vendedor;
import model.regra.Fachada;

/**
 * Servlet implementation class CadastroVendedor
 */
@WebServlet("/CadastroVendedor")
public class CadastroVendedor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Vendedor vendedor = new Vendedor();
	Fachada fachada = new Fachada();

	RequestDispatcher rd = null;

	//Na página lista_vendedores
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");

		if(request.getParameter("action") != null) {

			if(request.getParameter("action").toString().equals("novo")) {

				request.setAttribute("action", "novo");

				rd = request.getRequestDispatcher("cadastro_vendedor.jsp");

			} 

			rd.forward(request, response);

		}
	}

	//Na página cadastro_vendedor
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action").toString();

		if(action.equals("inserir")) {

			try {

				vendedor.setNome(request.getParameter("nome").toString());
				vendedor.setCpf(request.getParameter("cpf").toString());
				vendedor.setEmail(request.getParameter("email").toString());
				vendedor.setSenha(request.getParameter("senha").toString());
				vendedor.setLogradouro(request.getParameter("logradouro").toString());
				vendedor.setNumero(request.getParameter("numero").toString());
				vendedor.setBairro(request.getParameter("bairro").toString());
				vendedor.setCidade(request.getParameter("cidade").toString());
				vendedor.setEstado(request.getParameter("estado").toString());
				vendedor.setAtivo(request.getParameter("ativo").charAt(0));				

				fachada.salvarVendedor(vendedor);
				
				if (fachada != null) {
					
					System.out.println("Vendedor salvo com sucesso!");
					
				}

				rd = request.getRequestDispatcher("mensagem.jsp");

			} catch (Exception e) {

				e.printStackTrace();

			}
		} 

		rd.forward(request, response);		

	}
}