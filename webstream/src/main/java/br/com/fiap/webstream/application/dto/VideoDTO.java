package br.com.fiap.webstream.application.dto;

import br.com.fiap.webstream.domain.entities.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VideoDTO(

        @NotBlank
        String titulo,

        @NotBlank
        String descricao,

        @NotBlank
        String url,

        @NotNull
        Categoria categoria

) {
}
