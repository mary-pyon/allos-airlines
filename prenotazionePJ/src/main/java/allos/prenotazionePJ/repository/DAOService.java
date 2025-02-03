package allos.prenotazionePJ.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import allos.prenotazionePJ.model.Prenotazione;
import allos.prenotazionePJ.model.Utente;
import allos.prenotazionePJ.model.Volo;

@Service
public class DAOService implements IDAOService {
	
	@Autowired
	IRepoPrenotazione irp;
	
	@Autowired
	IRepoVolo irv;
	
	@Autowired
	IRepoUtente iru;
	
	
	// PRENOTAZIONE
	
	@Override
	public boolean upsertPrenotazione(Prenotazione p) {
		if(irp.existsById(p.getId())) {
			irp.save(p);
			return true;
		}
		p.setCodicePrenotazione(p.generaCodicePren());
		irp.save(p);
		return true;
	}

	@Override
	public List<Prenotazione> getPrenotazioni() {
		return irp.findAll();
	}

	@Override
	public boolean deletePrenotazione(int id) {
		irp.deleteById(id);
		return true;
	}

	@Override
	public Prenotazione getPrenotazioneByCodice(String codice) {
		return irp.getPrenotazioneByCodice(codice);
	}

	
	// VOLO 
	
	@Override
	public Volo getVoloById(int id) {
		return irv.getVoloById(id);
	}

	@Override
	public List<Volo> getVoliByTratta(String part, String dest) {
		return irv.getVoliByTratta(part, dest);
	}

	// UTENTE
	
	@Override
	public boolean upsertUtente(Utente u) {
		iru.save(u);
		return true;
	}


}
