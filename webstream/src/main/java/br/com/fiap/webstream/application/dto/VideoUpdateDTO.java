package br.com.fiap.webstream.application.dto;

import br.com.fiap.webstream.domain.entities.Categoria;

public record VideoUpdateDTO(

        String titulo,

        String descricao,
        String url,

        Categoria categoria

) {
}
