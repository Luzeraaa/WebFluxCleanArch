package br.com.fiap.webstream.services.interfaces;

import br.com.fiap.webstream.application.dto.VideoDTO;
import br.com.fiap.webstream.application.dto.VideoUpdateDTO;
import br.com.fiap.webstream.domain.entities.Video;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

public interface VideoService {

    Mono<Video> cadastrarVideo(VideoDTO videoDTO) throws JsonProcessingException;

    Flux<Video> findAllBy(Pageable pageable);

    Mono<Video> update(String id, VideoUpdateDTO videoUpdateDTO) throws JsonProcessingException;

    Mono<Void> delete(String id);

    Flux<Video> findByDataTittle(String titulo, Date dataPublicacao, Pageable pageable);
}
