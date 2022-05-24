package br.com.fiap.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.jdbc.model.Categoria;
import br.com.fiap.jdbc.model.Produto;

public class CategoriaDAO {

	private Connection connection;

	public CategoriaDAO(Connection connection) {
		this.connection = connection;
	}

	public List<Categoria> listar() throws SQLException {

		List<Categoria> categorias = new ArrayList<Categoria>();
		String sql = "select * from categoria";
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Categoria categoria = new Categoria();
			categoria.setIdCategoria(rs.getInt(1));
			categoria.setNome(rs.getString(2));
			categorias.add(categoria);
		}
		rs.close();
		stmt.close();
		return categorias;
	}

	public List<Categoria> listarComProduto() {
		try {
			Categoria categoriaAtual = null;
			List<Categoria> categorias = new ArrayList<Categoria>();

			String sql = "SELECT C.idCategoria, C.nome, P.idProduto, P.nome, P.descricao, P.idCategoria FROM CATEGORIA C INNER JOIN PRODUTO P ON C.idCategoria = P.idCategoria order by C.idCategoria";

			try (PreparedStatement stmt = connection.prepareStatement(sql)) {
				stmt.execute();
				ResultSet rs = stmt.getResultSet();
				while (rs.next()) {
					if (categoriaAtual == null || !categoriaAtual.getNome().equals(rs.getString(2))) {
						Categoria categoria = new Categoria();
						categoria.setIdCategoria(rs.getInt(1));
						categoria.setNome(rs.getString(2));
						categorias.add(categoria);
						categoriaAtual = categoria;
					}
					Produto produto = new Produto();
					produto.setId(rs.getInt(3));
					produto.setNome(rs.getString(4));
					produto.setDescricao(rs.getString(5));
					produto.setCategoriaId(rs.getInt(6));

					categoriaAtual.adicionarProduto(produto);
				}
				rs.close();
				stmt.close();
				return categorias;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
