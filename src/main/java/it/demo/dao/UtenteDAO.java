package it.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.demo.entity.Utente;

public interface UtenteDAO extends JpaRepository<Utente, Integer>{

}
