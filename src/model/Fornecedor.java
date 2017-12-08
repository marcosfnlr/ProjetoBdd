package model;

public class Fornecedor {

	private Integer id;
	private String razaoSocial;
	private String cnpj;

	public Fornecedor(Integer id, String razaoSocial, String cnpj) {
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

	public String getCnpj() {
		return cnpj;
	}

}
