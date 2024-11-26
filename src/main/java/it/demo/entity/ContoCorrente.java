package it.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class ContoCorrente {
	@Id
	private int numero;
	private double saldo;
	private Date dataApertura;
	
	//interface
	@ManyToMany
	@JoinTable(name="propreitari")
	private List<Utente> proprietari = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_conto")
	private List<Movimento> movimenti = new ArrayList<>();

	public ContoCorrente() {}
			
	public ContoCorrente(int numero, double saldo, Date dataApertura) {
		this.numero = numero;
		this.saldo = saldo;
		this.dataApertura = dataApertura;
	}

	public void addMovimento(Movimento m) {
		this.movimenti.add(m);
	}
	
	public void addProprietario(Utente u) {
		this.proprietari.add(u);
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Date getDataApertura() {
		return dataApertura;
	}

	public void setDataApertura(Date dataApertura) {
		this.dataApertura = dataApertura;
	}

	public List<Utente> getProprietari() {
		return proprietari;
	}

	public void setProprietari(List<Utente> proprietari) {
		this.proprietari = proprietari;
	}

	public List<Movimento> getMovimenti() {
		return movimenti;
	}

	public void setMovimenti(List<Movimento> movimenti) {
		this.movimenti = movimenti;
	}

	@Override
	public String toString() {
		return "ContoCorrente [numero=" + numero + ", saldo=" + saldo + ", dataApertura=" + dataApertura
				+ ", proprietari=" + proprietari + ", movimenti=" + movimenti + "]";
	}
	
}
