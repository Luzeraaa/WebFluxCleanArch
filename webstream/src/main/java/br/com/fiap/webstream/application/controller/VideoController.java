package br.com.fiap.webstream.application.controller;

import br.com.fiap.webstream.application.controller.DTO.VideoDTO;
import br.com.fiap.webstream.application.controller.DTO.VideoUpdateDTO;
import br.com.fiap.webstream.domain.entities.Video;
import br.com.fiap.webstream.services.interfaces.VideoServiceInterface;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@RestController
@RequestMapping("/videos")
@AllArgsConstructor
public class VideoController {

    private final VideoServiceInterface videoService;

    @PostMapping
    public Mono<Video> save(@Valid @RequestBody VideoDTO videoDTO) throws JsonProcessingException {
        return videoService.cadastrarVideo(videoDTO);
    }

    @GetMapping
    public Flux<Video> findAll(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "10") int size) {
        return videoService.findAllBy(PageRequest.of(page, size));
    }

    @PatchMapping("/{id}")
    public Mono<Video> update(@PathVariable String id, @RequestBody VideoUpdateDTO videoUpdateDTO) throws JsonProcessingException {
        return videoService.update(id, videoUpdateDTO);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return videoService.delete(id);
    }

    @GetMapping("/filtros")
    public Flux<Video> findByDataTittle(@RequestParam(required = false) String titulo,
                                        @RequestParam(required = false) Date dataPublicacao,
                                        @RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int size) {
        return videoService.findByDataTittle(titulo, dataPublicacao, PageRequest.of(page, size));
    }
}
