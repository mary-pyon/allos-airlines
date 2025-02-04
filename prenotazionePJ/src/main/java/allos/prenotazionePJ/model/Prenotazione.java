package allos.prenotazionePJ.model;

import java.util.Random;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="prenotazioni")
public class Prenotazione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 5, nullable = false, unique = true)
	private String codicePrenotazione;
	
	@ManyToOne
	@JoinColumn(name="id_utente", referencedColumnName = "id")
	private Utente utente;

	@ManyToOne
	@JoinColumn(name="id_volo", referencedColumnName = "id")
	private Volo volo;
	
	public Prenotazione (Utente utente, Volo volo) {
		this.utente = utente;
		this.volo = volo;
	}
	
	public String generaCodicePren() {
		String codici = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder str = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			str.append(codici.charAt(random.nextInt(codici.length())));
		}
		return str.toString();
	}

}
