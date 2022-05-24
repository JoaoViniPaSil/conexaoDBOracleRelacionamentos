package br.com.fiap.jdbc.model;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

	private int idCategoria;
	private String nome;
	private List<Produto> produtos = new ArrayList<Produto>();

	public Categoria() {
		
	}

	
	public int getId() {
		return idCategoria;
	}
	

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void adicionarProduto(Produto produto) {
		produtos.add(produto);
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

}
