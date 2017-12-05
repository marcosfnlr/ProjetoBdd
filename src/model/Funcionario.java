package model;

public class Funcionario {

	private Integer id;
	private String nome;
	private Integer cpf;
	private String email;
	private Integer idCargo;

	public Funcionario(Integer id, String nome, Integer cpf, String email, Integer idCargo) {
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

	public Integer getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	public Integer getIdCargo() {
		return idCargo;
	}
}
