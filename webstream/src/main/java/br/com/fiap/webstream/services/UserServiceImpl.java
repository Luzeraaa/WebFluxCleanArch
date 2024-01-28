package br.com.fiap.webstream.services;

import br.com.fiap.webstream.application.dto.UserDTO;
import br.com.fiap.webstream.domain.entities.User;
import br.com.fiap.webstream.domain.repositories.custom.UserRepositoryCustom;
import br.com.fiap.webstream.services.interfaces.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final ObjectMapper objectMapper;

    private final UserRepositoryCustom userRepository;

    @Override
    public Mono<User> save(UserDTO userDTO) throws JsonProcessingException {

        var user = objectMapper.readValue(objectMapper.writeValueAsString(userDTO), User.class);

        return userRepository.save(user);
    }
}
