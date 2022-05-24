package br.com.fiap.test;
import java.sql.SQLException;
import java.util.List;
import br.com.fiap.jdbc.controller.CategoriaController;
import br.com.fiap.jdbc.controller.ProdutoController;
import br.com.fiap.jdbc.model.Categoria;
import br.com.fiap.jdbc.model.Produto;
/**
@Author Emerson Abraham All Rights Reserved
*/
public class Teste {

	public static void main(String[] args) throws SQLException {

		CategoriaController categoriaController = new CategoriaController();
		ProdutoController produtoController = new ProdutoController();

		List<Categoria> listaCategoria = categoriaController.listarTodas();
		for (Categoria categoria : listaCategoria) {
			System.out.println(categoria.getNome());
		}

		Produto produto1 = new Produto();
		produto1.setNome("God Of War");
		produto1.setDescricao("Jogo de aventura com violência explícita. Recomendação 18+");
		produto1.setCategoriaId(2);
		produtoController.salvarComCategoria(produto1);
		
		Produto produto2 = new Produto();
		produto2.setNome("Smartphone Samsung");
		produto2.setDescricao("Samsung Galaxy S20");
		produto2.setCategoriaId(1);
		produtoController.salvarComCategoria(produto2);

		listaCategoria = categoriaController.listarComProduto();
		List<Produto> listaProdutos = null;
		for (Categoria categoria : listaCategoria) {
			listaProdutos = categoria.getProdutos();
			for (Produto produtoDaCategoria : listaProdutos) {
				System.out.print("Categoria: " + categoria.getNome() + " -- ");
				System.out.println("Nome do produto: " + produtoDaCategoria.getNome());
			}
		}
		
		List<Produto> listaProduto = produtoController.listarPorCategoria(2);
		for(Produto produto: listaProduto) {
			System.out.println(produto.getNome() +" -- "+ produto.getCategoriaId());
		}
		
		produtoController.alterar("Medal of Honor", "Jogo de guerra com violência explícita", 2, 10);
		produtoController.excluir(11);
		
		/*listaCategoria = categoriaController.listarComProduto();
		List<Produto> listaProdutos = null;
		for (Categoria categoria : listaCategoria) {
			listaProdutos = categoria.getProdutos();
			for (Produto produtoDaCategoria : listaProdutos) {
				System.out.print("Categoria: " + categoria.getNome() + " -- ");
				System.out.println("Nome do produto: " + produtoDaCategoria.getNome());
			}
		}*/
		
	}

}
