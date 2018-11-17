package model.classesbasicas;

public class Produto {
	
	private int id;
	private String descricao;
	private double precoUnitario;
	private Categoria categoria;
	private char ativo;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getPrecoUnitario() {
		return precoUnitario;
	}
	
	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public char getAtivo() {
		return ativo;
	}
	
	public void setAtivo(char ativo) {
		this.ativo = ativo;
	}
}
