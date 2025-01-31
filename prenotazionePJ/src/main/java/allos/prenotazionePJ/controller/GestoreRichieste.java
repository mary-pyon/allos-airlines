package allos.prenotazionePJ.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import allos.prenotazionePJ.model.Prenotazione;
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
	
}
