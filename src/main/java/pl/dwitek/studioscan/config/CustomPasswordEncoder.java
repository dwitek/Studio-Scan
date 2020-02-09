package pl.dwitek.studioscan.config;

import org.springframework.security.crypto.password.PasswordEncoder;

import static org.springframework.security.core.token.Sha512DigestUtils.shaHex;

public class CustomPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return shaHex(rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return shaHex(rawPassword.toString()).equals(encodedPassword);
    }
}
