package model.regra;

import java.util.ArrayList;

import model.classesbasicas.Categoria;
import model.classesbasicas.Cliente;
import model.classesbasicas.Pedido;
import model.classesbasicas.PedidoItens;
import model.classesbasicas.Produto;
import model.classesbasicas.StatusPedido;
import model.classesbasicas.Vendedor;
import model.excecoes.RegraException;

public class Fachada {

	private static Fachada instancia;

	private static RNCategoria rnCategoria;
	private static RNCliente rnCliente;
	private static RNStatusPedido rnStatusPedido;
	private static RNProduto rnProduto;
	private static RNVendedor rnVendedor;
	private static RNPedidoItens rnPedidoItens;
	private static RNPedido rnPedido;

	public Fachada() {

		rnCategoria = new RNCategoria();
		rnCliente = new RNCliente();
		rnStatusPedido = new RNStatusPedido();
		rnProduto = new RNProduto();
		rnVendedor = new RNVendedor();
		rnPedidoItens = new RNPedidoItens();
		rnPedido = new RNPedido();

	}

	public static Fachada getInstancia() {

		if (instancia == null)

			instancia = new Fachada();

		return instancia;

	}

	/*
	 * #########################################################################
	 * CATEGORIA
	 * ########################################################################
	 */
	public void salvarCategoria(Categoria categoria) throws RegraException {

		rnCategoria.validarCampos(categoria);
		rnCategoria.validarDescricao(categoria);
		rnCategoria.verificaDuplicidade(categoria);
		rnCategoria.incluir(categoria);

	}

	public void excluirCategoria(Categoria categoria) throws RegraException {

		rnCategoria.validaIdNull(categoria.getId());
		rnCategoria.validaIdExistente(categoria.getId());
		rnCategoria.excluir(categoria);

	}

	public void alterarCategoria(Categoria categoria) throws RegraException {

		rnCategoria.validarCampos(categoria);
		rnCategoria.validarDescricao(categoria);
		rnCategoria.validaIdNull(categoria.getId());
		rnCategoria.validaIdExistente(categoria.getId());
		rnCategoria.alterar(categoria);

	}

	public Categoria pesquisarCategoriaPorId(Categoria categoria) throws RegraException {

		rnCategoria.validaIdNull(categoria.getId());
		rnCategoria.validaIdExistente(categoria.getId());
		return rnCategoria.pesquisar(categoria.getId());

	}

	public Categoria pesquisarCategoriaPorDescricao(Categoria categoria) throws RegraException {

		rnCategoria.validarCampos(categoria);
		rnCategoria.validarDescricao(categoria);
		return rnCategoria.pesquisar(categoria.getDescricao());

	}

	public ArrayList<Categoria> listarCategorias() throws RegraException {

		return rnCategoria.listar();

	}

	/*
	 * #########################################################################
	 * CLIENTE
	 * ########################################################################
	 */
	public void salvarCliente(Cliente cliente) throws RegraException {

		rnCliente.validacaoBasica(cliente);
		rnCliente.verificaDuplicidade(cliente);
		rnCliente.validarRazaoSocial(cliente);
		rnCliente.incluir(cliente);

	}

	public void excluirCliente(Cliente cliente) throws RegraException {

		rnCliente.validaIdNull(cliente.getId());
		rnCliente.validaIdExistente(cliente.getId());
		rnCliente.excluir(cliente);

	}

	public void alterarCliente(Cliente cliente) throws RegraException {

		rnCliente.validacaoBasica(cliente);
		rnCliente.validaIdNull(cliente.getId());
		rnCliente.validaIdExistente(cliente.getId());
		rnCliente.alterar(cliente);

	}

	public Cliente pesquisarClientePorId(Cliente cliente)throws RegraException {

		rnCliente.validaIdNull(cliente.getId());
		rnCliente.validaIdExistente(cliente.getId());
		return rnCliente.pesquisar(cliente.getId());

	}

	public Cliente pesquisarClientePorCnpj(Cliente cliente) throws RegraException {

		rnCliente.validacaoBasica(cliente);
		return rnCliente.pesquisar(cliente.getCnpj());

	}

	public ArrayList<Cliente> listarClientes() throws RegraException {

		return rnCliente.listar();

	}

	/*
	 * #########################################################################
	 * PEDIDO
	 * ########################################################################
	 */
	public void salvarPedido(Pedido pedido) throws RegraException {

		rnPedido.verificaDuplicidade(pedido);
		rnPedido.incluir(pedido);

	}

	public void alterarPedido(Pedido pedido) throws RegraException {

		rnPedido.validaIdNull(pedido.getId());
		rnPedido.validaIdExistente(pedido.getId());
		rnPedido.alterar(pedido);
	}

	public void excluirPedido(Pedido pedido) throws RegraException {

		rnPedido.validaIdNull(pedido.getId());
		rnPedido.validaIdExistente(pedido.getId());
		rnPedido.excluir(pedido);

	}

	public Pedido pesquisarPedidoPorId(Pedido pedido) throws RegraException {

		rnPedido.validaIdNull(pedido.getId());
		rnPedido.validaIdExistente(pedido.getId());
		return rnPedido.pesquisar(pedido.getId());

	}

	public ArrayList<Pedido> listarPedidos() throws RegraException {

		return rnPedido.listar();

	}

	/*
	 * #########################################################################
	 * PRODUTO
	 * ########################################################################
	 */
	public void salvarProduto(Produto produto) throws RegraException {

		rnProduto.validarCampos(produto);
		rnProduto.validarDescricao(produto);
		rnProduto.verificaDuplicidade(produto);
		rnProduto.incluir(produto);

	}

	public void alterarProduto(Produto produto) throws RegraException {

		rnProduto.validarCampos(produto);
		rnProduto.validarDescricao(produto);
		rnProduto.validaIdNull(produto.getId());
		rnProduto.alterar(produto);

	}

	public void excluirProduto(Produto produto) throws RegraException {

		rnProduto.validaIdNull(produto.getId());
		rnProduto.validaIdExistente(produto.getId());
		rnProduto.excluir(produto);

	}

	public Produto pesquisarProdutoPorId(Produto produto) throws RegraException {

		rnProduto.validaIdNull(produto.getId());
		rnProduto.validaIdExistente(produto.getId());
		return rnProduto.pesquisar(produto.getId());

	}

	public Produto pesquisarProdutoPorDescricao(Produto produto) throws RegraException {

		rnProduto.validarCampos(produto);
		rnProduto.validarDescricao(produto);
		return rnProduto.pesquisar(produto.getDescricao());

	}

	public ArrayList<Produto> listarProdutos() throws RegraException {

		return rnProduto.listar();

	}

	/*
	 * #########################################################################
	 * VENDEDOR
	 * ########################################################################
	 */
	public void salvarVendedor(Vendedor vendedor) throws RegraException {

		rnVendedor.validarCampos(vendedor);
		rnVendedor.verificaDuplicidade(vendedor);
		rnVendedor.incluir(vendedor);

	}

	public void alterarVendedor(Vendedor vendedor) throws RegraException {

		rnVendedor.validarCampos(vendedor);
		rnVendedor.validaIdNull(vendedor.getId());
		rnVendedor.alterar(vendedor);

	}

	public void excluirVendedor(Vendedor vendedor) throws RegraException {

		rnVendedor.validaIdNull(vendedor.getId());
		rnVendedor.excluir(vendedor);

	}

	public Vendedor pesquisarVendedorPorId(Vendedor vendedor) throws RegraException {

		rnVendedor.validaIdNull(vendedor.getId());
		rnVendedor.validaIdExistente(vendedor.getId());
		return rnVendedor.pesquisar(vendedor.getId());

	}

	public Vendedor pesquisarVendedorPorCpf(Vendedor vendedor) throws RegraException {

		rnVendedor.validarCampos(vendedor);
		return rnVendedor.pesquisar(vendedor.getCpf());

	}

	public ArrayList<Vendedor> listarVendedores() throws RegraException {

		return rnVendedor.listar();

	}

	/*
	 * #########################################################################
	 * PEDIDOITENS
	 * ########################################################################
	 */
	public void salvarPedidoItens(PedidoItens pedidoItens) throws RegraException {

		rnPedidoItens.verificaDuplicidade(pedidoItens);
		rnPedidoItens.validaIdNull(pedidoItens.getId());
		rnPedidoItens.validaIdExistente(pedidoItens.getId());
		rnPedidoItens.incluir(pedidoItens);

	}

	public void alterarVendedor(PedidoItens pedidoItens) throws RegraException {

		rnPedidoItens.validaIdNull(pedidoItens.getId());
		rnPedidoItens.validaIdExistente(pedidoItens.getId());
		rnPedidoItens.alterar(pedidoItens);

	}

	public void excluirVendedor(PedidoItens pedidoItens) throws RegraException {

		rnPedidoItens.validaIdNull(pedidoItens.getId());
		rnPedidoItens.validaIdExistente(pedidoItens.getId());
		rnPedidoItens.excluir(pedidoItens);

	}

	public PedidoItens pesquisarPedidoItensPorId(PedidoItens pedidoItens) throws RegraException {

		rnPedidoItens.validaIdNull(pedidoItens.getId());
		rnPedidoItens.validaIdExistente(pedidoItens.getId());
		return rnPedidoItens.pesquisar(pedidoItens.getId());

	}

	public ArrayList<PedidoItens> listarPedidoItens() throws RegraException {

		return rnPedidoItens.listar();

	}

	/*
	 * #########################################################################
	 * STATUSPEDIDO
	 * ########################################################################
	 */
	public void salvarStatusPedido(StatusPedido statusPedido) throws RegraException {

		rnStatusPedido.validarCampos(statusPedido);
		rnStatusPedido.validarDescricao(statusPedido);
		rnStatusPedido.verificaDuplicidade(statusPedido);
		rnStatusPedido.incluir(statusPedido);

	}

	public void alterarStatusPedido(StatusPedido statusPedido) throws RegraException {

		rnStatusPedido.validarCampos(statusPedido);
		rnStatusPedido.validarDescricao(statusPedido);
		rnStatusPedido.validaIdNull(statusPedido.getId());
		rnStatusPedido.validaIdExistente(statusPedido.getId());
		rnStatusPedido.alterar(statusPedido);

	}

	public void excluirStatusPedido(StatusPedido statusPedido) throws RegraException {

		rnStatusPedido.validaIdNull(statusPedido.getId());
		rnStatusPedido.validaIdExistente(statusPedido.getId());
		rnStatusPedido.excluir(statusPedido);

	}

	public StatusPedido pesquisarStatusPedidoPorId(StatusPedido statusPedido) throws RegraException {

		rnStatusPedido.validaIdNull(statusPedido.getId());
		rnStatusPedido.validaIdExistente(statusPedido.getId());
		return rnStatusPedido.pesquisar(statusPedido.getId());

	}

	public StatusPedido pesquisarVendedorPorDescricao(StatusPedido statusPedido) throws RegraException {

		rnStatusPedido.validarCampos(statusPedido);
		rnStatusPedido.validarDescricao(statusPedido);
		rnStatusPedido.validaIdNull(statusPedido.getId());
		rnStatusPedido.validaIdExistente(statusPedido.getId());
		return rnStatusPedido.pesquisar(statusPedido.getDescricao());

	}

	public ArrayList<StatusPedido> listarStatusPedidos() throws RegraException {

		return rnStatusPedido.listar();

	}
}
