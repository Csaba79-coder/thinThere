package backend.thinthere.config;

import backend.thinthere.enums.Role;
import backend.thinthere.model.User;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Arrays;

@TestConfiguration
public class SecurityConfigTest {
    @Bean
    @Primary
    public UserDetailsService userDetailsService() {
        User user = createUser("user@user.com", "user", Role.ROLE_USER);
        User admin = createUser("admin@admin.com", "admin", Role.ROLE_ADMIN);
        User adminInDB = createUser("kiscica@gmail.com", "Kiscica", Role.ROLE_ADMIN);

        return new InMemoryUserDetailsManager(Arrays.asList(user, admin, adminInDB));
    }

    private User createUser(String email, String password, Role role) {
        User user = new User();
        user.setUsername(email);
        user.setPassword(password);
        user.setRole(role);

        return user;
    }
}