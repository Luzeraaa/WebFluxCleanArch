package br.com.fiap.webstream.application.controller;

import br.com.fiap.webstream.application.dto.UserDTO;
import br.com.fiap.webstream.domain.entities.User;
import br.com.fiap.webstream.services.interfaces.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService usuarioService;

    @PostMapping
    public Mono<User> register(@Valid @RequestBody UserDTO userDTO) throws JsonProcessingException {
        return usuarioService.save(userDTO);
    }

}
