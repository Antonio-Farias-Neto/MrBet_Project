package mrbet;

import java.util.Scanner;

public class MrBetMain {
	public static void main(String[] args) {
		MrBetController mb = new MrBetController();
		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, mb, scanner);
		}
	}
	
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(M)Minha iclusão de times\n" +
						"(R)Recuperar Time\n" +
						"(.)Adicionar Campeonato\n" + 
						"(B)Bora incluir time em campeonato e Verificar se time está em campeonato\n" +
						"(E)Exibir campeonatos que o time participa\n" +
						"(T)Tentar a sorte e status\n" +
						"(!)Já pode fechar o programa!\n" + "\n" +
						"Opção> ");
		return scanner.next().toUpperCase();
	}
	
	private static void comando(String opcao, MrBetController mb, Scanner scanner) {
		switch (opcao) {
		case "M":
			minhaInclusaoDeTimes(mb, scanner);
			break;
		case "R":
			recuperarTime(mb, scanner);
			break;
		case ".":
			adicionarCampeonato(mb,scanner);
			break;
		case "B":
			incluirEVerificarTime(mb,scanner);
			break;
		case "E":
			exibirCampeonatosQueOTimeParticipa(mb, scanner);
			break;
		case "T":
			tentarSorteEStatus(mb,scanner);
			break;
		case "!":
			System.out.println("Por hoje é só, pessoal!");
			System.exit(0);
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}
	
	private static void minhaInclusaoDeTimes(MrBetController mb, Scanner scanner) {
		System.out.println("Código: ");
		scanner.nextLine();
		String codigo = scanner.nextLine();
		System.out.println("Nome: ");
		String nome = scanner.nextLine();
		System.out.println("Mascote: ");
		String mascote = scanner.nextLine();
		System.out.println(mb.incluirTime(codigo, nome, mascote));
	}
	
	private static void recuperarTime(MrBetController mb, Scanner scanner) {
		System.out.println("Código: ");
		scanner.nextLine();
		String codigo = scanner.nextLine();
		System.out.println(mb.recuperarTime(codigo));
	}
	
	private static void adicionarCampeonato(MrBetController mb, Scanner scanner) {
		System.out.println("Campeonato: ");
		scanner.nextLine();
		String nome = scanner.nextLine();
		System.out.println("Participantes: ");
		int qtdParticipantes = scanner.nextInt();
		System.out.println(mb.incluirCampeonato(nome, qtdParticipantes));
	}
	
	private static void incluirEVerificarTime(MrBetController mb, Scanner scanner) {
		System.out.println("(I) Incluir time em campeonato ou (V) Verificar se time está em campeonato?");
		scanner.nextLine();
		String resposta = scanner.nextLine().toUpperCase();
		switch (resposta) {
		case "I":
			System.out.println("Campeonato: ");
			String nome = scanner.nextLine();
			System.out.println("Código: ");
			String codigo = scanner.nextLine();
			System.out.println(mb.incluirTimeCampeonato(codigo, nome));
			break;
		case "V":
			System.out.println("Campeonato: ");
			String name = scanner.nextLine();
			System.out.println("Código: ");
			String code = scanner.nextLine();
			System.out.println(mb.verificaTimeCampeonato(code, name));
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}
	
	private static void exibirCampeonatosQueOTimeParticipa(MrBetController mb, Scanner scanner) {
		System.out.println("Time: ");
		scanner.nextLine();
		String time = scanner.nextLine();
		System.out.println(mb.campsParticipando(time));
	}
	
	public static void tentarSorteEStatus(MrBetController mb, Scanner scanner) {
		System.out.println("(A)Apostar ou (S)Status das Apostas? ");
		scanner.nextLine();
		String resposta = scanner.nextLine().toUpperCase();
		switch (resposta) {
		case "A":
			System.out.println("Código: ");
			String codigo = scanner.nextLine();
			System.out.println("Campeonato: ");
			String nome = scanner.nextLine();
			System.out.println("Colocação: ");
			int col = scanner.nextInt();
			System.out.println("Valor da Aposta: ");
			float aposta = scanner.nextFloat();
			System.out.println(mb.tentarSorte(codigo, nome, col, aposta));
			break;
		case "S":
			System.out.println("Apostas:");
			System.out.println(mb.statusAposta());
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}
}

	
