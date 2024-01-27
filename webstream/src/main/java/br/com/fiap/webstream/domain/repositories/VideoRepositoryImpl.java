package br.com.fiap.webstream.domain.repositories;

import br.com.fiap.webstream.domain.entities.Video;
import br.com.fiap.webstream.domain.repositories.custom.VideoRepositoryCustom;
import br.com.fiap.webstream.infra.persistence.VideoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Component
@AllArgsConstructor
public class VideoRepositoryImpl implements VideoRepositoryCustom {

    private final VideoRepository videoRepository;

    public Mono<Video> save(Video video) {
        return videoRepository.save(video);
    }

    public Mono<Void> delete(String id) {
        return videoRepository.findById(id)
                .flatMap(videoRepository::delete);
    }

    @Override
    public Mono<Video> findById(String id) {
        return videoRepository.findById(id);
    }

    @Override
    public Flux<Video> findAllByOrderByDataPublicacaoDesc(Pageable pageable) {
        return videoRepository.findAllByOrderByDataPublicacaoDesc(pageable);
    }

    @Override
    public Flux<Video> buscaPorTituloEData(String titulo, Date dataPublicacao) {
        return videoRepository.buscaPorTituloEData(titulo, dataPublicacao);
    }
}
