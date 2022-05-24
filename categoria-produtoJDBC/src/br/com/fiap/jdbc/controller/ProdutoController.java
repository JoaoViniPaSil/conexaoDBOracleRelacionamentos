package br.com.fiap.jdbc.controller;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.jdbc.dao.ProdutoDAO;
import br.com.fiap.jdbc.factory.ConnectionFactory;
import br.com.fiap.jdbc.model.Categoria;
import br.com.fiap.jdbc.model.Produto;

public class ProdutoController {

	private ProdutoDAO produtoDAO;

	public ProdutoController() {
		Connection connection = new ConnectionFactory().conectarOracle();
		this.produtoDAO = new ProdutoDAO(connection);
	}

	public void salvarComCategoria(Produto produto) {
		this.produtoDAO.salvarComCategoria(produto);
	}

	public List<Produto> listarTodos() {
		return this.produtoDAO.listarTodos();
	}

	public List<Produto> listarPorCategoria(int idCategoria) {
		return this.produtoDAO.listarPorCategoria(idCategoria);
	}

	public void alterar(String nome, String descricao, int idProduto, int idCategoria) {
		this.produtoDAO.alterar(nome, descricao, idProduto, idCategoria);
	}

	public void excluir(int idProduto) {
		this.produtoDAO.excluir(idProduto);
	}
}
