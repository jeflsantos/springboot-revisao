package academy.devdojo.springbootrevisao.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import academy.devdojo.springbootrevisao.domain.Anime;

@Repository
public interface AnimeRepository {

	List<Anime> listAll();
	
}
