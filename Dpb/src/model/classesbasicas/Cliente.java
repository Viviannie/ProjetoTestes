package model.classesbasicas;

public class Cliente {

	private int id;
	private String razaoSocial;
	private String nomeFantasia;
	private String cnpj;	
	private String logradouro;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String email;

//	public Cliente(String razaoSocial, String nomeFantasia, String cnpj, String logradouro, String numero, String bairro, String cidade, String estado, String email) {
//
//		this.razaoSocial = razaoSocial;
//		this.nomeFantasia = nomeFantasia;
//		this.cnpj = cnpj;
//		this.logradouro = logradouro;
//		this.numero = numero;
//		this.bairro = bairro;
//		this.cidade = cidade;
//		this.estado = estado;
//		this.email = email;
//
//	}

	public Cliente() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}