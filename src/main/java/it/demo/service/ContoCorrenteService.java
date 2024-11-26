package it.demo.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.demo.dao.ContoCorrenteDAO;
import it.demo.dao.UtenteDAO;
import it.demo.entity.ContoCorrente;
import it.demo.entity.Movimento;
import it.demo.entity.TipoMovimento;
import it.demo.entity.Utente;

@Service
@Transactional
public class ContoCorrenteService {

	@Autowired
	private ContoCorrenteDAO daoC;
	
	@Autowired
	private UtenteDAO daoU;
	
	//INPUT --> i dati del conto (numero, saldo iniziale). 
	//INPUT --> Il riferimento al proprietario
	//OUTPUT --> nuovo conto sul DB
	
	//SPECIFICHE di BUSINESS: se il proprietario non esiste. Exception
//							  se il saldo iniziale è negativo. Exception
//							  se il saldo iniziale è > 0 bisogna creare anche il movimento associato
	
	public void creaNuovoConto(int numero, double saldoIniziale, int idUtente ) {
//		Optional<Utente> o = daoU.findById(idUtente);
//		if(o.isEmpty()) throw new 
		
		if(saldoIniziale<0) throw new RuntimeException("il saldo non può essere negativo");
		
		
		Optional<Utente> o = daoU.findById(idUtente);
		if(o.isEmpty()) throw new RuntimeException("utente non presente");
		Utente u = o.get();
		ContoCorrente cc = new ContoCorrente(numero, saldoIniziale, new Date()); //DETACHED
		
		if(saldoIniziale>0) {
			Movimento m = new Movimento(TipoMovimento.VERSAMENTO,saldoIniziale,new Date(),u) ; //DETACHED
			cc.addMovimento(m); //Detached con dentro detached
		}
		cc.addProprietario(u);
		
		daoC.save(cc);
		
	}
	
	//INPUT --> numero del conto
	//OUTPUT --> boolean 
	
	//tornare true se la sommatoria dei movimenti, tra prelievi e versamenti, è uguale
	//al saldo, altrimenti false.
	
	public boolean checkMovimenti(int numeroConto) {
		return false;
	}
	
	//INPUT --> numero del conto
	//OUTPUT --> boolean 
	
	//tornare true se i movimenti sono stati effettuati soltanto dai proprietari del conto,
	//altrimenti false.
	
	public boolean checkOperatori(int numeroConto) {
		
		ContoCorrente cc = daoC.findById(numeroConto).orElseThrow();
		
		if(cc.getProprietari().size()==0) throw new RuntimeException("conto senza proprietario");
		
		Utente u = cc.getProprietari().get(0);
		
		long n =
		cc.getMovimenti().stream()
						 .filter(m -> m.getOperatore().getIdUtente() == u.getIdUtente())
						 .count();
						 
		return  n== cc.getMovimenti().size();
	}
	
	
}
