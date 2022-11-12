package academy.devdojo.springbootrevisao.service;

import java.util.List;

import academy.devdojo.springbootrevisao.exception.BadRequestException;
import academy.devdojo.springbootrevisao.mapper.AnimeMapper;
import academy.devdojo.springbootrevisao.repository.AnimeRepository;
import academy.devdojo.springbootrevisao.request.AnimePostRequestBody;
import academy.devdojo.springbootrevisao.request.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import academy.devdojo.springbootrevisao.domain.Anime;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AnimeService {

	private final AnimeRepository animeRepository;
	public List<Anime> listAll(){
		return animeRepository.findAll();
	}

	public List<Anime> findByName(String name){
		return animeRepository.findByName(name);
	}
	
	public Anime findByIdOrThrowBadRequestException(Long id){
		return animeRepository.findById(id)
				.orElseThrow(() -> new BadRequestException("Anime not found!"));

	}

	@Transactional
	public Anime save(AnimePostRequestBody animePostRequestBody) {
		return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animePostRequestBody));
	}

	public void delete(long id) {
		animeRepository.delete(findByIdOrThrowBadRequestException(id));
		
	}

	public void replace(AnimePutRequestBody animePutRequestBody) {
		Anime savedAnime = findByIdOrThrowBadRequestException(animePutRequestBody.getId());
		Anime anime = AnimeMapper.INSTANCE.toAnime(animePutRequestBody);
		anime.setId(savedAnime.getId());
		animeRepository.save(anime);
	}
}
