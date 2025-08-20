package mrbet;

import java.util.HashMap;
import java.util.Objects;

/**
 * Representação de um campeonato com nome e times.
 * @author Antonio Neto
 */
public class Campeonato {
	private String nome;
	private int qtdparticipantes;
	private HashMap<String,Time> timesParticipantes = new HashMap<>();
	
	/**
	 * Cria um campeonato.
	 * @param nome é o nome do campeonato
	 * @param qtdParticipantes é a quantidade máxima de participantes permitidos
	 */
	public Campeonato(String nome, int qtdParticipantes) {
		this.nome = nome;
		this.qtdparticipantes = qtdParticipantes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campeonato other = (Campeonato) obj;
		return Objects.equals(nome, other.nome);
	}
	
	public int getQtdParticipantes() {
		return this.qtdparticipantes;
	}
	
	public HashMap<String,Time> getTimesParticipantes() {
		return this.timesParticipantes;
	}
	
	@Override
	public String toString() {
		return this.nome + " - " + this.timesParticipantes.size() + "/" + this.qtdparticipantes;
	}
}
