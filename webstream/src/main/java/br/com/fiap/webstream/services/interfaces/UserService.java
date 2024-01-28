package br.com.fiap.webstream.services.interfaces;

import br.com.fiap.webstream.application.dto.UserDTO;
import br.com.fiap.webstream.domain.entities.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> save(UserDTO userDTO) throws JsonProcessingException;
}
