package br.com.fiap.webstream.application.dto;

import jakarta.validation.constraints.NotBlank;

public record UserDTO(

        @NotBlank
        String nome,

        @NotBlank
        String email

) {
}
