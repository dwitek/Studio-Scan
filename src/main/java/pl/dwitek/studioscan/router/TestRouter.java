package pl.dwitek.studioscan.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import pl.dwitek.studioscan.handler.TestHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class TestRouter {

    @Bean
    public RouterFunction<ServerResponse> route(TestHandler testHandler) {

        return RouterFunctions
                .route(GET("/"), testHandler::test);
    }
}
