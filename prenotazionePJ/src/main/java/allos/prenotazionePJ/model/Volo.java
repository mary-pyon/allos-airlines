package allos.prenotazionePJ.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="voli")
public class Volo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 250, nullable = false, unique = false)
	private String partenza;
	
	@Column(length = 250, nullable = false, unique = false)
	private String destinazione;
	
	//private String compagniaAerea;
	//private BigDecimal prezzo;
	//private String orario;
	
	// one to many
	//private List<Prenotazione> prenotazioni;
	
	
	public Volo(String partenza, String destinazione) {
		this.partenza = partenza;
		this.destinazione = destinazione;
	}
}
