package mrbet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MrBetControllerTest {
	
	private MrBetController mb;
	
	@BeforeEach
	void preparaMrBet() {
		mb = new MrBetController();
		mb.incluirTime("250_PB", "Nacional de Patos", "Canário");
		mb.incluirTime("252_PB", "Sport Lagoa Seca", "Carneiro");
		mb.incluirTime("002_RJ", "Clube de Regatas do Flamengo", "Urubu");
		mb.incluirTime("105_PB", "Sociedade Recreativa de Monteiro (SOCREMO)", "Gavião");
	}

	@Test
	void cadastrarUmCampeonatoComSucesso() {
		assertEquals(mb.incluirCampeonato("Brasileirão série A 2023", 20), "CAMPEONATO ADICIONADO!");
	}
	
	@Test
	void cadastrarUmCampeonatoComNomeExistente() {
		mb.incluirCampeonato("Brasileirão série A 2023", 15);
		assertEquals(mb.incluirCampeonato("Brasileirão série A 2023", 20), "CAMPEONATO JA EXISTE!");
	}
	
	@Test
	void incluirTimeEmCampeonato() {
		mb.incluirCampeonato("Brasileirão série A 2023", 20);
		assertEquals(mb.incluirTimeCampeonato("250_PB", "Brasileirão série A 2023"), "TIME INCLUIDO NO CAMPEONATO!");
		assertEquals(mb.incluirTimeCampeonato("252_PB", "Brasileirão série A 2023"), "TIME INCLUIDO NO CAMPEONATO!");
	}
	
	@Test
	void incluirTimeEmCampeonatoQueEleJaFoiIncluido() {
		mb.incluirCampeonato("Brasileirão série A 2023", 20);
		assertEquals(mb.incluirTimeCampeonato("250_PB", "Brasileirão série A 2023"), "TIME INCLUIDO NO CAMPEONATO!");
		assertEquals(mb.incluirTimeCampeonato("252_PB", "Brasileirão série A 2023"), "TIME INCLUIDO NO CAMPEONATO!");
		assertEquals(mb.incluirTimeCampeonato("252_PB", "Brasileirão série A 2023"), "O TIME JA FOI INCLUIDO ANTERIORMENTE!"); 

	}
	
	@Test
	void incluirTimeEmCampeonatoQuandoTimeNaoFoiCadastrado() {
		mb.incluirCampeonato("Brasileirão série A 2023", 15);
		try {
			mb.verificaTimeCampeonato("000_PB", "Brasileirão série D 2023");
		} catch (IllegalArgumentException ie){}
	}
	
	@Test
	void incluirTimeEmCampeonatoQuandoCampeonatoNaoFoiCadastrado() {
		try {
			mb.verificaTimeCampeonato("252_PB", "Brasileirão série D 2023");
		} catch (IllegalArgumentException ie){}
	}
	
	@Test
	void incluirTimeEmCampeonatoExcedendoAQuantidadeDeParticipantes() {
		mb.incluirCampeonato("Brasileirão série A 2023", 1);
		mb.incluirTimeCampeonato("252_PB", "Brasileirão série A 2023");
		assertEquals(mb.incluirTimeCampeonato("250_PB", "Brasileirão série A 2023"), "TODOS OS TIMES DESSE CAMPEONATO JA FORAM INCLUIDOS!");
	}
	
	@Test
	void VerificarSeUmTimeEstaNoCampeonato() {
		mb.incluirCampeonato("Copa do Nordeste 2023", 16);
		mb.incluirTimeCampeonato("250_PB", "Copa do Nordeste 2023");
		assertEquals(mb.verificaTimeCampeonato("250_PB", "Copa do Nordeste 2023"), "O TIME ESTA NO CAMPEONATO!");
		assertEquals(mb.verificaTimeCampeonato("252_PB", "Copa do Nordeste 2023"), "O TIME NAO ESTA NO CAMPEONATO!");
	}
	
	@Test
	void VerificarSeUmTimeEstaNoCampeonatoQueNaoFoiCadastrado() {
		try {
			mb.verificaTimeCampeonato("252_PB", "Brasileirão série D 2023");
		} catch (IllegalArgumentException ie){}
	}
	
	@Test
	void VerificarSeUmTimeNaoCadastradoEstaNoCampeonato() {
		mb.incluirCampeonato("Copa do Nordeste 2023", 16);
		try {
			mb.verificaTimeCampeonato("000_PB", "Copa do Nordeste 2023");
		} catch (IllegalArgumentException ie){}
	}

}
