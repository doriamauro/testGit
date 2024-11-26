package it.demo.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class Movimento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMovimento;
	private TipoMovimento tipo;
	private double importo;
	private Date dataOperazione;
	
	@ManyToOne
	@JoinColumn(name="fk_utente")
	private Utente operatore;

	public Movimento() {}
			
	public Movimento(TipoMovimento tipo, double importo, Date dataOperazione, Utente operatore) {
		this.tipo = tipo;
		this.importo = importo;
		this.dataOperazione = dataOperazione;
		this.operatore = operatore;
	}
	
	public Movimento(int idMovimento, TipoMovimento tipo, double importo, Date dataOperazione, Utente operatore) {
		this.idMovimento = idMovimento;
		this.tipo = tipo;
		this.importo = importo;
		this.dataOperazione = dataOperazione;
		this.operatore = operatore;
	}

	public int getIdMovimento() {
		return idMovimento;
	}

	public void setIdMovimento(int idMovimento) {
		this.idMovimento = idMovimento;
	}

	public TipoMovimento getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimento tipo) {
		this.tipo = tipo;
	}

	public double getImporto() {
		return importo;
	}

	public void setImporto(double importo) {
		this.importo = importo;
	}

	public Date getDataOperazione() {
		return dataOperazione;
	}

	public void setDataOperazione(Date dataOperazione) {
		this.dataOperazione = dataOperazione;
	}

	public Utente getOperatore() {
		return operatore;
	}

	public void setOperatore(Utente operatore) {
		this.operatore = operatore;
	}

	@Override
	public String toString() {
		return "Movimento [idMovimento=" + idMovimento + ", tipo=" + tipo + ", importo=" + importo + ", dataOperazione="
				+ dataOperazione + ", operatore=" + operatore + "]";
	}
	
	
}
