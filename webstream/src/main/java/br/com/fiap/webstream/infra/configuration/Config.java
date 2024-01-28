package br.com.fiap.webstream.infra.configuration;

import br.com.fiap.webstream.application.controller.UserController;
import br.com.fiap.webstream.application.controller.VideoController;
import br.com.fiap.webstream.domain.repositories.UserRepositoryImpl;
import br.com.fiap.webstream.domain.repositories.VideoRepositoryImpl;
import br.com.fiap.webstream.domain.repositories.custom.UserRepositoryCustom;
import br.com.fiap.webstream.domain.repositories.custom.VideoRepositoryCustom;
import br.com.fiap.webstream.infra.repository.UserRepository;
import br.com.fiap.webstream.infra.repository.VideoRepository;
import br.com.fiap.webstream.services.UserServiceImpl;
import br.com.fiap.webstream.services.VideoServiceImpl;
import br.com.fiap.webstream.services.interfaces.UserService;
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
    public VideoServiceImpl videoService(ObjectMapper objectMapper, VideoRepositoryCustom videoRepository) {
        return new VideoServiceImpl(objectMapper, videoRepository);
    }

    @Bean
    public VideoController videoController(VideoServiceImpl videoService) {
        return new VideoController(videoService);
    }

    @Bean
    public UserRepositoryImpl userRepositoryImpl(UserRepository userRepository) {
        return new UserRepositoryImpl(userRepository);
    }

    @Bean
    public UserServiceImpl userServiceImpl(ObjectMapper objectMapper, UserRepositoryCustom userRepositoryCustom) {
        return new UserServiceImpl(objectMapper, userRepositoryCustom);
    }

    @Bean
    public UserController userController(UserService userService) {
        return new UserController(userService);
    }


}
