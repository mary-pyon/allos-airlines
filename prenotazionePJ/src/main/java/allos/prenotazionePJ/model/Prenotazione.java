package allos.prenotazionePJ.model;

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
@Table(name="prenotazioni")
public class Prenotazione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 30, nullable = false, unique = false)
	private String nome;
	
	@Column(length = 50, nullable = false, unique = false)
	private String cognome;
	
	@Column(nullable = false)
	private int eta;
	
	@Column(length = 150, nullable = false, unique = false)
	private String partenza;
	
	@Column(length = 150, nullable = false, unique = false)
	private String destinazione;

		
	
}
