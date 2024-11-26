package it.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.demo.entity.ContoCorrente;

public interface ContoCorrenteDAO extends JpaRepository<ContoCorrente, Integer>{

	//creare un metodo astratto
	@Query(nativeQuery = true,value="select * from contocorrente where dataapertura between '2024-01-01 and 2024-01-31'")//query SQL oppure query JPQL
	public List<ContoCorrente> getContiGennaio();
	
	@Query(value="SELECT cc FROM ContoCorrente cc where cc.saldo > :saldo")
	public List<ContoCorrente> getContiPerSaldo(double saldo);
	
	
}
