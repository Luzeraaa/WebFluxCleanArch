package br.com.fiap.webstream.application.configuration;

import br.com.fiap.webstream.application.controller.VideoController;
import br.com.fiap.webstream.domain.repositories.VideoRepositoryImpl;
import br.com.fiap.webstream.domain.repositories.custom.VideoRepositoryCustom;
import br.com.fiap.webstream.services.VideoService;
import br.com.fiap.webstream.services.interfaces.VideoServiceInterface;
import br.com.fiap.webstream.infra.persistence.VideoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public VideoRepositoryImpl videoRepository(VideoRepository videoRepository) {
        return new VideoRepositoryImpl(videoRepository);
    }

    @Bean
    public VideoService videoService(ObjectMapper objectMapper, VideoRepositoryCustom videoRepository) {
        return new VideoService(objectMapper, videoRepository);
    }

    @Bean
    public VideoController videoController(VideoService videoService) {
        return new VideoController(videoService);
    }

}
