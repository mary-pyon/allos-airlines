package allos.prenotazionePJ.repository;

import java.util.List;

import allos.prenotazionePJ.model.Prenotazione;
import allos.prenotazionePJ.model.Utente;
import allos.prenotazionePJ.model.Volo;

public interface IDAOService {

	// Prenotazione
	public boolean upsertPrenotazione(Prenotazione p);
	public List<Prenotazione> getPrenotazioni();
	public boolean deletePrenotazione(int id);
	public Prenotazione getPrenotazioneByCodice(String codice);
	
	// Volo
	public Volo getVoloById(int id);
	public List<Volo> getVoliByTratta(String part, String dest);
	
	// Utente
	public boolean upsertUtente(Utente u);
}
