package model;

import java.sql.Date;

public class Compra {

	private Integer id;
	private Date data;
	private Double preco;
	private Integer idFuncionario;
	private Integer idFornecedor;

	public Compra(Integer id, Date data, Double preco, Integer idFuncionario, Integer idFornecedor) {
		super();
		this.id = id;
		this.data = data;
		this.preco = preco;
		this.idFuncionario = idFuncionario;
		this.idFornecedor = idFornecedor;
	}

	public Integer getId() {
		return id;
	}

	public Date getData() {
		return data;
	}

	public Double getPreco() {
		return preco;
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public Integer getIdFornecedor() {
		return idFornecedor;
	}

}
