package br.com.fiap.webstream.domain.repositories;

import br.com.fiap.webstream.domain.entities.User;
import br.com.fiap.webstream.domain.entities.Video;
import br.com.fiap.webstream.domain.repositories.custom.UserRepositoryCustom;
import br.com.fiap.webstream.infra.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {

    private final UserRepository userRepository;

    @Override
    public Mono<User> save(User user) {
        return userRepository.save(user);
    }
}
