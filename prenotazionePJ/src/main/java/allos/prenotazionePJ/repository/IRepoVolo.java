package allos.prenotazionePJ.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import allos.prenotazionePJ.model.Volo;


@Repository
public interface IRepoVolo extends JpaRepository<Volo, Integer> {

	@Query("From Volo v WHERE v.id = ?1")
	public Volo getVoloById(int id);
	
	@Query("From Volo v WHERE v.partenza = ?1 AND v.destinazione = ?2")
	public List<Volo> getVoliByTratta(String part, String dest);
	
}
