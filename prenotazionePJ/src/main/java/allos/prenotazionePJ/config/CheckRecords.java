package allos.prenotazionePJ.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import allos.prenotazionePJ.model.Volo;
import allos.prenotazionePJ.repository.IRepoVolo;

@Configuration
public class CheckRecords {
	
	@Autowired
	IRepoVolo irv;
	
	@Bean
	String checkVoli() {
		System.out.println("Check in corso dei records. . .");
		if(irv.findAll().size()==0) {
			Volo v = new Volo("Roma", "Milano");
			irv.save(v);
			v = new Volo("Napoli", "Milano");
			irv.save(v);
			v = new Volo("Roma", "Milano");
			irv.save(v);
			v = new Volo("Roma", "Sicilia");
			irv.save(v);
			v = new Volo("Napoli", "Milano");
			irv.save(v);
			v = new Volo("Sicilia", "Roma");
			irv.save(v);
			
			System.out.println("Creazione voli di default eseguita!");
		}
		else {
			System.out.println("Voli di default rilevati!");
		}
		return null;
	}

}
