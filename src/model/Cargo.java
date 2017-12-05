package model;

public class Cargo {
	private Integer id;
	private String titulo;

	public Cargo(Integer id, String titulo) {
		super();
		this.id = id;
		this.titulo = titulo;
	}

	public Integer getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

}
