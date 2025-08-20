package mrbet;

import java.util.HashMap;
import java.util.ArrayList;

/**
 * Classe controladora do sistema MrBet
 * @author Antonio Neto
 */
public class MrBetController {
	private HashMap<String,Campeonato> campeonatos = new HashMap<>();
	private HashMap<String,Time> times = new HashMap<>();
	private ArrayList<String> apostas = new ArrayList<>();
	
	public MrBetController() {
		
	}
	
	/**
	 * Cria e inclui um campeonato no sistema.
	 * @param nome � o nome e identificador do campeonato
	 * @param participantes a quantidade m�xima de participantes desse campeonato
	 * @return String confirmando ou n�o a inclus�o do campeonato no sistema
	 */
	public String incluirCampeonato(String nome, int participantes) {
		if (nome == null) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		if ("".equals(nome.trim())) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		String nomeSemUpper = nome.substring(0,1).toUpperCase() + nome.substring(1,nome.length()).toLowerCase();
		if (this.campeonatos.containsKey(nome) || this.campeonatos.containsKey(nomeSemUpper)) {
			return "CAMPEONATO JA EXISTE!";
		}
		
		Campeonato camp = new Campeonato(nome,participantes);
		this.campeonatos.put(nome, camp);
		return "CAMPEONATO ADICIONADO!";
	}
	
	/**
	 * Cria e inclui um time no sistema.
	 * @param codigo � o identificador do time
	 * @param nome � o nome do time
	 * @param mascote � o mascote do time
	 * @return String confirmando ou n�o a inclus�o do time no sistema
	 */
	public String incluirTime(String codigo, String nome , String mascote) {
		if (codigo == null) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		if (nome == null) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		if (mascote == null) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		if ("".equals(codigo.trim())) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		if ("".equals(nome.trim())) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		if ("".equals(mascote.trim())) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		if (this.times.containsKey(codigo)) {
			return  "TIME JA EXISTE!";
		}
		Time time = new Time(codigo,nome,mascote);
		this.times.put(codigo, time);
		return "INCLUSAO REALIZADA!";
	}
	
	/**
	 * confere se existe um time no sistema.
	 * @param codigo � o c�digo do time a ser recebido para ser procurado
	 * @return String com o c�digo, nome e mascote do time caso ele exista ou a informa��o da inexist�ncia dele
	 */
	public String recuperarTime(String codigo) {
		if (codigo == null) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		if ("".equals(codigo.trim())) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		if (this.times.containsKey(codigo)) {
			return this.times.get(codigo).toString();
		}
		return "TIME NAO EXISTE!";
	}
	
	/**
	 * inclui um time do sistema em um campeonato do sistema.
	 * @param codTime � o c�digo do time a ser colocado em determinado campeonato
	 * @param nomeCamp � o nome do campeonato a receber um time
	 * @return String com a confirma��o ou n�o da inclus�o de um time em um campeonato
	 */
	public String incluirTimeCampeonato(String codTime, String nomeCamp) {
		if (codTime == null) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		if (nomeCamp == null) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		if ("".equals(codTime.trim())) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		if ("".equals(nomeCamp.trim())) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		if (!this.times.containsKey(codTime)) {
			throw new IllegalArgumentException("O TIME NAO EXISTE!");
		}
		if (!this.campeonatos.containsKey(nomeCamp)) {
			throw new IllegalArgumentException("CAMPEONATO NAO EXISTE!");
		}
		if(this.campeonatos.get(nomeCamp).getTimesParticipantes().size() == this.campeonatos.get(nomeCamp).getQtdParticipantes()) {
			return "TODOS OS TIMES DESSE CAMPEONATO JA FORAM INCLUIDOS!";
		}
		if (this.campeonatos.get(nomeCamp).getTimesParticipantes().containsKey(codTime)) {
			return "O TIME JA FOI INCLUIDO ANTERIORMENTE!";
		}
		this.campeonatos.get(nomeCamp).getTimesParticipantes().put(codTime,this.times.get(codTime));
		return "TIME INCLUIDO NO CAMPEONATO!";
		
	}
	
	/**
	 * Verifica se um time est� dentro de um campeonato.
	 * @param codTime � o c�digo do time a ser procurado em determinado campeonato
	 * @param nomeCamp � o nome do campeonato no qual ser� procurado um time
	 * @return String com a confirma��o ou n�o da exist�ncia do time no campeonato
	 */
	public String verificaTimeCampeonato(String codTime, String nomeCamp) {
		if (codTime == null) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		if (nomeCamp == null) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		if ("".equals(codTime.trim())) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		if ("".equals(nomeCamp.trim())) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		if (!this.times.containsKey(codTime)) {
			throw new IllegalArgumentException("O TIME NAO EXISTE!");
		}
		if (!this.campeonatos.containsKey(nomeCamp)) {
			throw new IllegalArgumentException("O CAMPEONATO NAO EXISTE!");
		}
		if (this.campeonatos.get(nomeCamp).getTimesParticipantes().containsKey(codTime)) {
			return "O TIME ESTA NO CAMPEONATO!";
		}
		return "O TIME NAO ESTA NO CAMPEONATO!";
	}
	
	/**
	 * Mostra em quais campeonatos o time est�.
	 * @param codigo � o c�digo do time no qual ser� informado os campeonatos em que ele est�
	 * @return String com os campeonatos em que o time est�
	 */
	public String campsParticipando(String codigo) {
		if (codigo == null) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		if ("".equals(codigo.trim())) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		if (!this.times.containsKey(codigo)) {
			throw new IllegalArgumentException("O TIME NAO EXISTE!");
		}
		
		boolean naoTemTime = true;
		String out = "Time: "+ this.times.get(codigo).getCodigo() + " | Campeonatos do " + this.times.get(codigo).getNome() + " | ";
		for (Campeonato camp:this.campeonatos.values()) {
			if (camp.getTimesParticipantes().containsKey(codigo)) {
				out += "* " + camp.toString() + " | ";
				naoTemTime = false;
			}
		}
		if (naoTemTime) {
			return "O TIME NAO ESTA EM NENHUM CAMPEONATO!";
		}
		out = out.substring(0,out.length()-3);
		return out;
	}
	
	/**
	 * Realiza uma aposta em um time em um determinado campeonato.
	 * @param codTime � o c�digo do time no qual o usu�rio vai apostar
	 * @param nomeCamp � o nome do campeonato que o time participa
	 * @param colocacao � a posi��o final que o usu�rio aposta que o time terminar� nesse campeonato
	 * @param preco � o valor da aposta
	 * @return String com a confirma��o ou n�o da aposta
	 */
	public String tentarSorte(String codTime, String nomeCamp, int colocacao, double preco) {
		if (codTime == null) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		if (nomeCamp == null) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		if ("".equals(codTime.trim())) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		if ("".equals(nomeCamp.trim())) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}
		if (!this.times.containsKey(codTime)) {
			throw new IllegalArgumentException("O TIME NAO EXISTE!");
		}
		if (!this.campeonatos.containsKey(nomeCamp)) {
			throw new IllegalArgumentException("CAMPEONATO NAO EXISTE!");
		}
		
		if (this.campeonatos.get(nomeCamp).getQtdParticipantes() < colocacao) {
			return "APOSTA NAO REGISTRADA!";
		}
		
		if (colocacao < 1) {
			return "APOSTA NAO REGISTRADA!";
		}
		if (!this.campeonatos.get(nomeCamp).getTimesParticipantes().containsKey(codTime)) {
			return "O TIME NAO ESTA NO CAMPEONATO!";
		}
		String aposta = this.times.get(codTime).toString() + " | " + this.campeonatos.get(nomeCamp).toString() + " | " + "R$" + preco; 
		this.apostas.add(aposta);
		return "APOSTA REGISTRADA!";
	}
	
	/**
	 * mostra os status das apostas realizadas.
	 * @return todas as apostas realizadas at� o momento pel usu�rio
	 */
	public String statusAposta() {
		String out = "Apostas: | ";
		
		for (int i = 0; i < this.apostas.size(); i++) {
			out += (i+1) + ". " + this.apostas.get(i) + " | ";
		}
		if (out.equals("Apostas: | ")) {
			return "NAO TEM APOSTAS REGISTRADAS!";
		}
		out = out.substring(0,out.length()-3);
		return out;
	}
}
