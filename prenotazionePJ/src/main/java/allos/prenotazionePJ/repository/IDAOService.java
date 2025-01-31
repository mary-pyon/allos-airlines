package allos.prenotazionePJ.repository;

import java.util.List;

import allos.prenotazionePJ.model.Prenotazione;

public interface IDAOService {

	public boolean upsertPrenotazione(Prenotazione p);
	
	public List<Prenotazione> getPrenotazioni();
	
	public boolean deletePrenotazione(int id);
}
