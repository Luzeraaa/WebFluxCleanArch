package br.com.fiap.webstream.infra.repository;

import br.com.fiap.webstream.domain.entities.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository("customUserRepository")
public interface UserRepository extends ReactiveMongoRepository<User, String> {
}
