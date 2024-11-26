package it.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.demo.dao.IndirizzoDAO;
import it.demo.entity.Indirizzo;

@Service
@Transactional
public class IndirizzoService {

	@Autowired
	private IndirizzoDAO dao;
	
	public void registraIndirizzo(Indirizzo i) {
		dao.save(i);
	}
	
	public void cancellaIndirizzo(int idIndirizzo) {
		dao.deleteById(idIndirizzo);
	}
	
	public void modiricaCap(int idIndirizzo, String cap) {
		Optional<Indirizzo> o = dao.findById(idIndirizzo);
		if(o.isPresent()) {
			Indirizzo i = o.get(); //ATTACHED
			i.setCap(cap);
		}		
	}
	
	public Indirizzo leggiIndirizzo(int idIndirizzo) {
		return dao.findById(idIndirizzo).orElse(null);
	}
	
}
