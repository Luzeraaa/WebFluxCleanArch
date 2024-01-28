package br.com.fiap.webstream.domain.repositories.custom;

import br.com.fiap.webstream.domain.entities.User;
import reactor.core.publisher.Mono;

public interface UserRepositoryCustom {
    Mono<User> save(User video);
}
