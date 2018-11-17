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

		if(instancia == null)

			instancia = new Fachada();

		return instancia;

	}

	/*#########################################################################
	 * CATEGORIA
	 *########################################################################*/
	public void salvarCategoria(Categoria categoria) throws RegraException {

		rnCategoria.validarCampos(categoria);
		rnCategoria.validarDescricao(categoria);
		rnCategoria.verificaDuplicidade(categoria);
		rnCategoria.incluir(categoria);

	}

	public void excluirCategoria(Categoria categoria) throws RegraException {

		rnCategoria.validaId(categoria.getId());
		rnCategoria.excluir(categoria);

	}

	public void alterarCategoria(Categoria categoria) throws RegraException {

		rnCategoria.validarCampos(categoria);
		rnCategoria.validarDescricao(categoria);
		rnCategoria.validaId(categoria.getId());
		rnCategoria.alterar(categoria);

	}

	public Categoria pesquisarCategoriaPorId(Categoria categoria) throws RegraException {

		rnCategoria.validaId(categoria.getId());
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

	/*#########################################################################
	 * CLIENTE
	 *########################################################################*/
	public void salvarCliente(Cliente cliente) throws RegraException {

		rnCliente.validacaoBasica(cliente);
		rnCliente.verificaDuplicidade(cliente);
		rnCliente.validarRazaoSocial(cliente);
		rnCliente.incluir(cliente);

	}

	public void excluirCliente(Cliente cliente)throws RegraException {

		rnCliente.validaId(cliente.getId());
		rnCliente.excluir(cliente);

	}

	public void alterarCliente(Cliente cliente)throws RegraException {

		rnCliente.validacaoBasica(cliente);
		rnCliente.validaId(cliente.getId());
		rnCliente.alterar(cliente);

	}

	public Cliente pesquisarClientePorId(Integer id)throws RegraException {

		rnCliente.validaId(id);
		return rnCliente.pesquisar(id);

	}

	public Cliente pesquisarClientePorCnpj(Cliente cliente)throws RegraException {

		rnCliente.validacaoBasica(cliente);
		return rnCliente.pesquisar(cliente.getCnpj());

	}

	public ArrayList<Cliente> listarClientes()throws RegraException {

		return rnCliente.listar();

	}

	/*#########################################################################
	 * PEDIDO
	 *########################################################################*/
	public void salvarPedido(Pedido pedido) throws RegraException {
		
		rnPedido.verificaDuplicidade(pedido);
		rnPedido.incluir(pedido);
		
	}
	
	public void alterarPedido(Pedido pedido) throws RegraException{
		
		rnPedido.validaId(pedido.getId());
		rnPedido.alterar(pedido);
	}

	public void excluirPedido(Pedido pedido) throws RegraException {
		
		rnPedido.validaId(pedido.getId());
		rnPedido.excluir(pedido);
		
	}

	public Pedido pesquisarPedidoPorId(Integer id) throws RegraException {
		
		rnPedido.validaId(id);
		return rnPedido.pesquisar(id);
		
	}

	public ArrayList<Pedido> listarPedidos()throws RegraException {
		
		return rnPedido.listar();
		
	}

	/*#########################################################################
	 * PRODUTO
	 *########################################################################*/
	public void salvarProduto(Produto produto) throws RegraException {
		
		rnProduto.validarCampos(produto);
		rnProduto.validarDescricao(produto);
		rnProduto.verificaDuplicidade(produto);
		rnProduto.incluir(produto);
		
	}
	
	public void alterarProduto(Produto produto) throws RegraException {
		
		rnProduto.validarCampos(produto);
		rnProduto.validarDescricao(produto);
		rnProduto.validaId(produto.getId());
		rnProduto.alterar(produto);
		
	}

	public void excluirProduto(Produto produto) throws RegraException {
		
		rnProduto.validaId(produto.getId());
		rnProduto.excluir(produto);
		
	}
	
	public Produto pesquisarProdutoPorId(Integer id) throws RegraException {
		
		rnProduto.validaId(id);
		return rnProduto.pesquisar(id);
		
	}

	public Produto pesquisarProdutoPorDescricao(Produto produto) throws RegraException {
		
		rnProduto.validarCampos(produto);
		rnProduto.validarDescricao(produto);
		return rnProduto.pesquisar(produto.getDescricao());
		
	}

	public ArrayList<Produto> listarProdutos() throws RegraException {
		
		return rnProduto.listar();
		
	}

	/*#########################################################################
	 * VENDEDOR
	 *########################################################################*/
	public void salvarVendedor(Vendedor vendedor) throws RegraException {
		
		rnVendedor.validarCampos(vendedor);
		rnVendedor.verificaDuplicidade(vendedor);
		rnVendedor.incluir(vendedor);
		
	}
	
	public void alterarVendedor(Vendedor vendedor) throws RegraException {
		
		rnVendedor.validarCampos(vendedor);
		rnVendedor.validaId(vendedor.getId());
		rnVendedor.alterar(vendedor);
		
	}

	public void excluirVendedor(Vendedor vendedor) throws RegraException {
		
		rnVendedor.validaId(vendedor.getId());
		rnVendedor.excluir(vendedor);
		
	}

	public Vendedor pesquisarVendedorPorId(Integer id) throws RegraException {
		
		rnVendedor.validaId(id);
		return rnVendedor.pesquisar(id);
		
	}

	public Vendedor pesquisarVendedorPorCpf(Vendedor vendedor) throws RegraException {
		
		rnVendedor.validarCampos(vendedor);
		return rnVendedor.pesquisar(vendedor.getCpf());
		
	}

	public ArrayList<Vendedor> listarVendedores() throws RegraException {
		
		return rnVendedor.listar();
		
	}
	
	/*#########################################################################
	 * PEDIDOITENS
	 *########################################################################*/
	public void salvarPedidoItens(PedidoItens pedidoItens) throws RegraException {
		
		rnPedidoItens.verificaDuplicidade(pedidoItens);
		rnPedidoItens.incluir(pedidoItens);
		
	}
	
	public void alterarVendedor(PedidoItens pedidoItens) throws RegraException {
		
		rnPedidoItens.validaId(pedidoItens.getId());
		rnPedidoItens.alterar(pedidoItens);
		
	}

	public void excluirVendedor(PedidoItens pedidoItens) throws RegraException {
		
		rnPedidoItens.validaId(pedidoItens.getId());
		rnPedidoItens.excluir(pedidoItens);
		
	}

	public PedidoItens pesquisarPedidoItensPorId(Integer id) throws RegraException {
		
		rnPedidoItens.validaId(id);
		return rnPedidoItens.pesquisar(id);
		
	}

	public ArrayList<PedidoItens> listarPedidoItens() throws RegraException {
		
		return rnPedidoItens.listar();
		
	}
	
	/*#########################################################################
	 * STATUSPEDIDO
	 *########################################################################*/
	public void salvarStatusPedido(StatusPedido statusPedido) throws RegraException {
		
		rnStatusPedido.validarCampos(statusPedido);
		rnStatusPedido.validarDescricao(statusPedido);
		rnStatusPedido.verificaDuplicidade(statusPedido);
		rnStatusPedido.incluir(statusPedido);
		
	}
	
	public void alterarStatusPedido(StatusPedido statusPedido) throws RegraException {
		
		rnStatusPedido.validarCampos(statusPedido);
		rnStatusPedido.validarDescricao(statusPedido);
		rnStatusPedido.validaId(statusPedido.getId());
		rnStatusPedido.alterar(statusPedido);
		
	}

	public void excluirStatusPedido(StatusPedido statusPedido) throws RegraException {
		
		rnStatusPedido.validaId(statusPedido.getId());
		rnStatusPedido.excluir(statusPedido);
		
	}

	public StatusPedido pesquisarStatusPedidoPorId(Integer id) throws RegraException {
		
		rnStatusPedido.validaId(id);
		return rnStatusPedido.pesquisar(id);
		
	}

	public StatusPedido pesquisarVendedorPorDescricao(StatusPedido statusPedido) throws RegraException {
		
		rnStatusPedido.validarCampos(statusPedido);
		rnStatusPedido.validarDescricao(statusPedido);
		return rnStatusPedido.pesquisar(statusPedido.getDescricao());
		
	}

	public ArrayList<StatusPedido> listarStatusPedidos() throws RegraException {
		
		return rnStatusPedido.listar();
		
	}
}
