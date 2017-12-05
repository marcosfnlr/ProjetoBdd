package model;

public class Fornecedor {

	private Integer id;
	private String razaoSocial;
	private Integer cnpj;

	public Fornecedor(Integer id, String razaoSocial, Integer cnpj) {
		super();
		this.id = id;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
	}

	public Integer getId() {
		return id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public Integer getCnpj() {
		return cnpj;
	}

}
