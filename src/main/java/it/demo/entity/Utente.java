package it.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Utente {
	@Id
	private int idUtente;
	private String nome;
	private String cognome;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_ind")
	private Indirizzo residenza;

	public Utente() {}
	
	public Utente(int idUtente, String nome, String cognome, Indirizzo residenza) {
		this.idUtente = idUtente;
		this.nome = nome;
		this.cognome = cognome;
		this.residenza = residenza;
	}

	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Indirizzo getResidenza() {
		return residenza;
	}

	public void setResidenza(Indirizzo residenza) {
		this.residenza = residenza;
	}

	@Override
	public String toString() {
		return "Utente [idUtente=" + idUtente + ", nome=" + nome + ", cognome=" + cognome + ", residenza=" + residenza
				+ "]";
	}
}
