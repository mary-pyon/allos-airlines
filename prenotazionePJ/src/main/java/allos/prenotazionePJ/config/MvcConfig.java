package allos.prenotazionePJ.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer{
	
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/info").setViewName("info");
		registry.addViewController("/prenotazione").setViewName("prenotazione");
		registry.addViewController("/listaVoli").setViewName("listaVoli");
		registry.addViewController("/formUtente").setViewName("formUtente");
		registry.addViewController("/recapPren").setViewName("recapPren");
		registry.addViewController("/successPren").setViewName("successPren");
		registry.addViewController("/gestPren").setViewName("gestPren");
		registry.addViewController("/listPrens").setViewName("listPrens");
	}
	
}
