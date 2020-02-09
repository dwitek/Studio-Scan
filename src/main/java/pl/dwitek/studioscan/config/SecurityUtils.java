package pl.dwitek.studioscan.config;

import org.springframework.security.core.Authentication;
import pl.dwitek.studioscan.domain.DomainUser;

import java.util.Optional;

public class SecurityUtils {

    public static Optional<DomainUser> getCurrentUser(Authentication authentication) {
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof DomainUser) {
                return Optional.of((DomainUser) principal);
            }
        }
        return Optional.empty();
    }
}
