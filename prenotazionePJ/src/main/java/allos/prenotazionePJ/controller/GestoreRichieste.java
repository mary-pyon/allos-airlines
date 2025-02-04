package allos.prenotazionePJ.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import allos.prenotazionePJ.model.Prenotazione;
import allos.prenotazionePJ.model.Utente;
import allos.prenotazionePJ.model.Volo;
import allos.prenotazionePJ.repository.IDAOService;

@Controller
public class GestoreRichieste {
	
	@Autowired
	IDAOService dao;
	
	
//	@PostMapping("/upsertPren")
//	public String upsertPrenotazione(Prenotazione pren) {
//		dao.upsertPrenotazione(pren);
//		return "home";
//	}
	
	@GetMapping("/listVoli")
	public String getVoli(Model model, @RequestParam String partenza, String destinazione) {
		List<Volo> voli = dao.getVoliByTratta(partenza, destinazione);
		model.addAttribute("voli", voli);
		return "listaVoli";
	}
	
	@GetMapping("/selectedVolo")
	public String selectedVolo(Model model, @RequestParam int id) {
		Volo volo = dao.getVoloById(id);
		model.addAttribute("volo", volo);
		return "formUtente";
	}
	
	@PostMapping("/createPren")
	public String setPrenotazione(Model model, Utente utente, @RequestParam int voloId) {
		Volo volo = dao.getVoloById(voloId);
		model.addAttribute("volo", volo);
		model.addAttribute("utente", utente);
		return "recapPren";
	}
	
	@PostMapping("/confirmPren")
	public String confirmPrenotazione(Model model, Utente utente, @RequestParam int voloId) {
		System.out.println("sono in confirmPren");
		Volo voloSelec = dao.getVoloById(voloId);
		dao.upsertUtente(utente);
		Prenotazione pren = new Prenotazione(utente, voloSelec);
		dao.upsertPrenotazione(pren);
		model.addAttribute("volo", voloSelec);
		model.addAttribute("utente", utente);
		model.addAttribute("pren", pren);
		return "successPren";
	}
	
	@GetMapping("/findPrenByCod")
	public String getPrenByCodice(Model model, @RequestParam String nome, @RequestParam String cognome, @RequestParam String codicePrenotazione) {
		Prenotazione pren = dao.getPrenotazioneByCodice(codicePrenotazione);
		Utente user = pren.getUtente();
		if(user.getNome().equalsIgnoreCase(nome) && user.getCognome().equalsIgnoreCase(cognome)) {
			Volo volo = pren.getVolo();
			model.addAttribute("pren", pren);
			model.addAttribute("utente", user);
			model.addAttribute("volo", volo);
			return "prenotazione";
		}
		else {
			String msg = "Spiacenti, non è stata trovata la prenotazione. Verificare la correttezza dei dati";
			model.addAttribute("msg", msg);
			return "prenotazione";
		}
	}

	@GetMapping("/getPrens")
	public String getPrenotazioni(Model model) {
		List<Prenotazione> prenotazioni = dao.getPrenotazioni();
		model.addAttribute("prenotazioni", prenotazioni);
		return "listPrens";
	}
	
	@GetMapping("/deletePren")
	public String deletePrenotazione(@RequestParam int id) {
		dao.deletePrenotazione(id);
		return "home";
	}	
	
}
