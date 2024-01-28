package br.com.fiap.webstream.services;

import br.com.fiap.webstream.application.dto.VideoDTO;
import br.com.fiap.webstream.application.dto.VideoUpdateDTO;
import br.com.fiap.webstream.domain.entities.Video;
import br.com.fiap.webstream.domain.repositories.custom.VideoRepositoryCustom;
import br.com.fiap.webstream.services.interfaces.VideoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
@AllArgsConstructor
public class VideoServiceImpl implements VideoService {

    private final ObjectMapper objectMapper;

    private final VideoRepositoryCustom videoRepository;

    public Mono<Video> cadastrarVideo(VideoDTO videoDTO) throws JsonProcessingException {
        Video video = objectMapper.readValue(objectMapper.writeValueAsString(videoDTO), Video.class);
        return videoRepository.save(video);
    }

    public Flux<Video> findAllBy(Pageable pageable) {
        return videoRepository.findAllByOrderByDataPublicacaoDesc(pageable);
    }

    public Mono<Video> update(String id, VideoUpdateDTO videoUpdateDTO) throws JsonProcessingException {
        Video video = objectMapper.readValue(objectMapper.writeValueAsString(videoUpdateDTO), Video.class);
        return videoRepository.findById(id)
                .map(v -> video.withId(v.getId()))
                .flatMap(videoRepository::save);
    }

    public Mono<Void> delete(String id) {
        return videoRepository.delete(id);
    }

    public Flux<Video> findByDataTittle(String titulo, Date dataPublicacao, Pageable pageable) {
        if (titulo == null && dataPublicacao == null) {
            return findAllBy(pageable);
        }
        return videoRepository.buscaPorTituloEData(titulo, dataPublicacao);
    }
}
