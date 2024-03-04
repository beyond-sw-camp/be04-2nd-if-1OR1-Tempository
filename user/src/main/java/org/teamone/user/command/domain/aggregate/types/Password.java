package org.teamone.user.command.domain.aggregate.types;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@NoArgsConstructor
@Embeddable
public class Password {

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();     // BCrypt 방식 암호화

    private String password;

    public Password(final String rawPassword) {
        this.password = encodePassword(rawPassword);
    }

    private String encodePassword(final String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    public void changePassword(final String oldRawPassword, final String newRawPassword) {
        if (isMatches(oldRawPassword)) {
            this.password = encodePassword(newRawPassword);
        }
    }

    public boolean isMatches(String rawPassword) {
        return passwordEncoder.matches(rawPassword, password);
    }

    @Override
    public String toString() {
        return "Password{" +
                "password='" + password + '\'' +
                '}';
    }
}