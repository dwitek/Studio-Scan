package pl.dwitek.studioscan.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import pl.dwitek.studioscan.domain.DomainUser;
import reactor.core.publisher.Mono;

@Repository
public interface DomainUserRepository extends ReactiveCrudRepository<DomainUser, Long> {

    @Query("SELECT * FROM User WHERE username = :username")
    Mono<DomainUser> findDomainUserByUsername(String username);
}
