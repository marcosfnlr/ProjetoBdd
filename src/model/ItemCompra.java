package model;

public class ItemCompra {

	private Integer idProduto;
	private Integer idCompra;
	private String qtd;

	public ItemCompra(Integer idProduto, Integer idCompra, String qtd) {
		super();
		this.idProduto = idProduto;
		this.idCompra = idCompra;
		this.qtd = qtd;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public Integer getIdCompra() {
		return idCompra;
	}

	public String getQtd() {
		return qtd;
	}

}
