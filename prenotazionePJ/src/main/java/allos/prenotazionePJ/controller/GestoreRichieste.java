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
	
	
	@PostMapping("/upsertPren")
	public String upsertPrenotazione(Prenotazione pren) {
		System.out.println(pren);
		dao.upsertPrenotazione(pren);
		return "home";
	}

	@GetMapping("/getPrens")
	public String getPrenotazioni(Model model) {
		List<Prenotazione> prenotazioni = dao.getPrenotazioni();
		model.addAttribute("prenotazioni", prenotazioni);
		return "tabella";
	}
	
	@GetMapping("/deletePren")
	public String deletePrenotazione(@RequestParam int id) {
		dao.deletePrenotazione(id);
		return "home";
	}
	
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
		//creare una prenotazione e settare id volo
		//trovare modo di recuperare il volo
		Volo volo = dao.getVoloById(voloId);
		System.out.println(volo);
		System.out.println(utente);
		model.addAttribute("volo", volo);
		model.addAttribute("utente", utente);
		dao.upsertUtente(utente);
		return "recapPren";
	}
	
	@PostMapping("/confirmPren")
	public String confirmPrenotazione(Model model, Utente utente, @RequestParam int voloId) {
		System.out.println("sono in confirmPren");
		Volo voloSelec = dao.getVoloById(voloId);
		System.out.println(utente);
		System.out.println(voloSelec);
		Prenotazione pren = new Prenotazione();
		pren.setNome(utente.getNome());
		pren.setCognome(utente.getCognome());
		pren.setEta(utente.getEta());
		pren.setPartenza(voloSelec.getPartenza());
		pren.setDestinazione(voloSelec.getDestinazione());
		// richiamare metodo upsert che dovrà rimandare alla pagina di prenotazione effettuata
		dao.upsertPrenotazione(pren);
		model.addAttribute("pren", pren);
		return "successPren";
	}
	
	public String getPrenByCodice() {
		// ragionare su come fare
		// dovrei cercare tramite codice
		// però quel codice deve avere come utente nome e cognome del form
		// il return potrei farlo su tabella
		
		//utente ha le sue prenotazioni
		/*
		 * recuperare la sua lista
		 * questa lista cercare la prenotazione con il codice che prendo nella query string
		 * 
		 */
		return null;
		
	}
	
	// metodo funzionante ma non riesco a recuperare id volo
	
//	@PostMapping("/confirmPren")
//	public String confirmPrenotazione(Utente utente, Volo volo, Prenotazione pren) {
//		System.out.println("sono in confirmPren");
//		Volo voloSelec = dao.getVoloById(voloId);
//		System.out.println(utente);
//		System.out.println(volo);
//		//Prenotazione pren = new Prenotazione();
//		pren.setNome(utente.getNome());
//		pren.setCognome(utente.getCognome());
//		pren.setEta(utente.getEta());
//		pren.setPartenza(volo.getPartenza());
//		pren.setDestinazione(volo.getDestinazione());
//		dao.upsertPrenotazione(pren);
//		return "home";
//	}
	
}
