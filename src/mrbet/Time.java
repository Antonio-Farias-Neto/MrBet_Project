package mrbet;

import java.util.Objects;

/**
 * Representação de um time, com nome e um mascote.
 * @author Antonio Neto
 */
public class Time {
	private String nome;
	private String mascote;
	private String codigo;
	
	/**
	 * Cria um time.
	 * @param codigo é o identificador do time no sistema
	 * @param nome é o nome do time
	 * @param mascote é o mascote do time
	 */
	public Time(String codigo, String nome, String mascote) {
		this.codigo = codigo;
		this.nome = nome;
		this.mascote = mascote;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	@Override
	public String toString() {
		return "[" + this.codigo + "] "  + this.nome + " / " + this.mascote;
	}
}
