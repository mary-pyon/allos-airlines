package allos.prenotazionePJ.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import allos.prenotazionePJ.model.Prenotazione;

@Repository
public interface IRepoPrenotazione extends JpaRepository<Prenotazione, Integer> {

	@Query("From Prenotazione p WHERE p.id_utente = ?1")
	public List<Prenotazione> getListPrenByIdUtente(int id);
	
	@Query("From Prenotazione p WHERE p.codicePrenotazione = ?1")
	public Prenotazione getPrenotazioneByCodice(String codicePren); 
	
}
