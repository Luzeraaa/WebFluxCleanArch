package br.com.fiap.webstream.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.With;
import org.springframework.data.annotation.Id;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@With
public class Video {

    @Id
    private String id;

    private String titulo;

    private String descricao;

    private String url;

    private String dataPublicacao;

    private Categoria categoria;

    public Video(){
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        this.dataPublicacao = formatador.format(new Date());
    }
}
