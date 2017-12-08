package model;

public class Funcionario {

	private Integer id;
	private String nome;
	private String cpf;
	private String email;
	private Integer idCargo;

	public Funcionario(Integer id, String nome, String cpf, String email, Integer idCargo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.idCargo = idCargo;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	public Integer getIdCargo() {
		return idCargo;
	}
}
