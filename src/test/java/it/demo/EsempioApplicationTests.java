package it.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.demo.entity.Indirizzo;
import it.demo.entity.Utente;
import it.demo.service.ContoCorrenteService;
import it.demo.service.IndirizzoService;
import it.demo.service.UtenteService;

@SpringBootTest
class EsempioApplicationTests {

	@Autowired
	private IndirizzoService service;
	
	@Autowired
	private UtenteService serviceU;
	
	@Autowired
	private ContoCorrenteService serviceC;
	
	@Test
	void testCreazioneConto() {
		
		serviceC.creaNuovoConto(40, 10000, 10);
	
	}
	
//	@Test
//	void testModificaIndirizzoUtente() {
//		
//		serviceU.sostituisciIndirizzo(30, new Indirizzo(21,"viale del tramonto, 19","88700", "Genova", "GE"));
//	
//	}
	
	
//	@Test
//	void testInserimentoUtente() {
//		Utente u = new Utente(30, "Armando", "De Razza", 
//				   new Indirizzo(100, "via su non fare cosi, 10","00100", "Roma", "RM"));
//		serviceU.registraUtente(u);
//	
//	}
	
//	@Test
//	void testLetturaIndirizzo() {
//		
//		
//		System.out.println(service.leggiIndirizzo(2));
//	
//	}
//	
//	@Test
//	void testCancellazioneIndirizzo() {
//		
//		
//		service.cancellaIndirizzo(1);
//	
//	}
	
//	@Test
//	void testInserimentoIndirizzo() {
//		
//		Indirizzo i = new Indirizzo(2,"piazza bho, 10", "00100","Roma","RM");
//		service.registraIndirizzo(i);
//	
//	}

}
