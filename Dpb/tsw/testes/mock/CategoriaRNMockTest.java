package testes.mock;

import model.classesbasicas.Categoria;

public class CategoriaRNMockTest {
	
	private ICategoriaMockTest iCategoriaMockTest;
	public Categoria cat = new Categoria();

	public CategoriaRNMockTest(ICategoriaMockTest iCategoriaMockTest) {

		this.iCategoriaMockTest = iCategoriaMockTest;

	}
	
	public Categoria pesquisar(String descricao) {
		
		Categoria categoria = new Categoria();
		
		cat.setDescricao("Muito coisa escrita.");
		
		if (categoria.equals(cat.getDescricao())) {
			
			return categoria;
			
		}
		
		return categoria;	
		
	}
}
