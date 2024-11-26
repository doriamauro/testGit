package it.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.demo.entity.Indirizzo;

public interface IndirizzoDAO extends JpaRepository<Indirizzo, Integer> {

}
