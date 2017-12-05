package model;

public class ProdutoFornecedor {

	private Integer idProduto;
	private Integer idFornecedor;
	private Double preco;

	public ProdutoFornecedor(Integer idProduto, Integer idFornecedor, Double preco) {
		super();
		this.idProduto = idProduto;
		this.idFornecedor = idFornecedor;
		this.preco = preco;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public Integer getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(Integer idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

}
