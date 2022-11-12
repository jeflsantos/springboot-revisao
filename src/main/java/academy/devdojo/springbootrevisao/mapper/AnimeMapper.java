package academy.devdojo.springbootrevisao.mapper;

import academy.devdojo.springbootrevisao.domain.Anime;
import academy.devdojo.springbootrevisao.request.AnimePostRequestBody;
import academy.devdojo.springbootrevisao.request.AnimePutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "string")
public abstract class AnimeMapper {

    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

    public abstract Anime toAnime(AnimePostRequestBody animePostRequestBody);
    public abstract Anime toAnime(AnimePutRequestBody animePuttRequestBody);
}
