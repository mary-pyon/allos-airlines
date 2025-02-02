package allos.prenotazionePJ.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import allos.prenotazionePJ.model.Utente;

@Repository
public interface IRepoUtente extends JpaRepository<Utente, Integer> {

}
