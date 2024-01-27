package br.com.fiap.webstream.domain.repositories.custom;

import br.com.fiap.webstream.domain.entities.Video;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

public interface VideoRepositoryCustom {

    Mono<Video> save(Video video);

    Mono<Video> findById(String id);

    Flux<Video> findAllByOrderByDataPublicacaoDesc(Pageable pageable);

    Flux<Video> buscaPorTituloEData(String titulo, Date dataPublicacao);

    Mono<Void> delete(String id);
}
