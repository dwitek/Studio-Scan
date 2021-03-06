package pl.dwitek.studioscan.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.dwitek.studioscan.repository.DomainUserRepository;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class DomainReactiveUserDetailsService implements ReactiveUserDetailsService {

    private DomainUserRepository domainUserRepository;

    @Override
    public Mono<UserDetails> findByUsername(String username) {

        return domainUserRepository.findDomainUserByUsername(username)
                .switchIfEmpty(Mono.error(new UsernameNotFoundException("User was not found")))
                .cast(UserDetails.class);
    }
}
