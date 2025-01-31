package allos.prenotazionePJ.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import allos.prenotazionePJ.model.Prenotazione;

@Service
public class DAOService implements IDAOService {
	
	@Autowired
	IRepoPrenotazione irp;

	String msg;
	
	@Override
	public boolean upsertPrenotazione(Prenotazione p) {
		msg = "Inserimento avvenuto con successo.";
		if(irp.existsById(p.getId()))
			msg = "Modifica avvenuta con successo.";
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

}
