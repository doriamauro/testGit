package it.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.demo.entity.Indirizzo;
import it.demo.service.IndirizzoService;
//prova
//prova

@RestController
public class IndirizzoController {

	@Autowired
	private IndirizzoService service;
	
	@PostMapping(path="/indirizzi", consumes = "application/json")
	public void registraIndirizzo(@RequestBody Indirizzo i) {
		service.registraIndirizzo(i);
	}
	
	@PatchMapping(path="/indirizzi/cap/{idIndirizzo}")
	public void modificaCap(@PathVariable int idIndirizzo, String cap) {
		service.modiricaCap(idIndirizzo, cap);
	}
	
}
