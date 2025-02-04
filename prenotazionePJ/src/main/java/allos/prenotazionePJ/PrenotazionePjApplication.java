package allos.prenotazionePJ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrenotazionePjApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrenotazionePjApplication.class, args);
		System.out.println("App in ascolto sulla porta 8092: ...");
	}

}
