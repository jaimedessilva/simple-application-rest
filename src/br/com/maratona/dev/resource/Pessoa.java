package br.com.maratona.dev.resource;

/**Project: maratonaDev
 * File: Pessoa.java
 * @author jaime-Dev
 * Em 16-10-2020 **/

public class Pessoa {

	private String nome;
	private Integer matricula;
	
	/*
	 * Construct
	 */
	public Pessoa() {}
	//
	public Pessoa(String nome, Integer matricula) {
		this.nome = nome;
		this.matricula = matricula;
	}
	
	/* Getter */
	public String getNome() {
		return nome;
	}
	/* Setter */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/* Getter */
	public Integer getMatricula() {
		return matricula;
	}
	/* Setter */
	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}
	@Override
	public String toString() {
		return "Pessoa nome:" + nome 
				+ "\n matricula:" + matricula;
	}
}
