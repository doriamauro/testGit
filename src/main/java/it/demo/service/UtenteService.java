package it.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.demo.dao.UtenteDAO;
import it.demo.entity.Indirizzo;
import it.demo.entity.Utente;
//	questo è per GIT
// altro cambiamento
// ulteriore modifica
@Service
@Transactional
public class UtenteService {

	@Autowired
	private UtenteDAO dao;
	
	public void registraUtente(Utente u) {
		dao.save(u);
		
	}
	
	public void sostituisciIndirizzo(int idUtente, Indirizzo newInd) {
		Optional<Utente> o = dao.findById(idUtente);
		if(o.isPresent()) {
			Utente u = o.get(); //ATTACHED
			u.setResidenza(newInd);
		}
	}
	
	public void modificaCapIndirizzoUtente(int idUtente, String newCap) {
		Optional<Utente> o = dao.findById(idUtente);
		if(o.isPresent()) {
			Utente u = o.get(); //ATTACHED
			u.getResidenza().setCap(newCap);
		}
	}
	
}
