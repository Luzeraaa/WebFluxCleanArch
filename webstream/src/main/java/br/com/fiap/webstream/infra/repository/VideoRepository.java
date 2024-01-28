package br.com.fiap.webstream.infra.repository;

import br.com.fiap.webstream.domain.entities.Video;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Repository("customVideoRepository")
public interface VideoRepository extends ReactiveMongoRepository<Video, Long> {

    Mono<Video> findById(String id);

    Flux<Video> findAllByOrderByDataPublicacaoDesc(Pageable pageable);

    @Query("{ $or: [ { 'titulo': { $eq: ?0, $exists: true } }, { 'dataPublicacao': { $eq: ?1, $exists: true } } ] }")
    Flux<Video> buscaPorTituloEData(String titulo, Date dataPublicacao);
}
