package pl.dwitek.studioscan.handler;

import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import pl.dwitek.studioscan.config.SecurityUtils;
import pl.dwitek.studioscan.domain.DomainUser;
import reactor.core.publisher.Mono;

@Component
public class TestHandler {

    public Mono<ServerResponse> test(ServerRequest serverRequest) {
        return ServerResponse.ok().body(ReactiveSecurityContextHolder.getContext()
                .log()
                .map(SecurityContext::getAuthentication)
                .map(SecurityUtils::getCurrentUser), DomainUser.class);
    }
}
