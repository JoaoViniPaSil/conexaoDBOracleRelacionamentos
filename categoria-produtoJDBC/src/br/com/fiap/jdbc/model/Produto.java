package br.com.fiap.jdbc.model;

public class Produto {

	private int idProduto;
	private String nome;
	private String descricao;
	private int idCategoria;

	public Produto() {
		
	}

	public Integer getId() {
		return idProduto;
	}

	public void setId(Integer id) {
		this.idProduto = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getCategoriaId() {
		return idCategoria;
	}

	public void setCategoriaId(Integer categoriaId) {
		this.idCategoria = categoriaId;
	}

}
