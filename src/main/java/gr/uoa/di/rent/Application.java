package gr.uoa.di.rent;

import gr.uoa.di.rent.exceptions.AppException;
import gr.uoa.di.rent.models.*;
import gr.uoa.di.rent.properties.FileStorageProperties;
import gr.uoa.di.rent.repositories.HotelRepository;
import gr.uoa.di.rent.repositories.RoleRepository;
import gr.uoa.di.rent.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
@EnableScheduling
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // Insert some initial-data into the repository.
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private HotelRepository hotelRepository;

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(Collections.singletonList("*"));
        config.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept"));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH"));
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    @Bean
    public CommandLineRunner initialData(RoleRepository roleRepo, UserRepository userRepo) {
        return args -> {
            // Insert the RoleNames if they don't exist.
            if (roleRepository.findByName(RoleName.ROLE_ADMIN) == null) {
                roleRepository.save(new Role(RoleName.ROLE_ADMIN));
            }
            if (roleRepository.findByName(RoleName.ROLE_USER) == null) {
                roleRepository.save(new Role(RoleName.ROLE_USER));
            }
            if (roleRepository.findByName(RoleName.ROLE_PROVIDER) == null) {
                roleRepository.save(new Role(RoleName.ROLE_PROVIDER));
            }

            // Insert the admin if not exist.
            if (!userRepository.findByEmail("admin@rentcube.com").isPresent()) {

                // Assign an admin role
                Role role = roleRepository.findByName(RoleName.ROLE_ADMIN);
                if (role == null) {
                    throw new AppException("Admin Role not set.");
                }

                User user_temp = new User("admin",
                        passwordEncoder.encode("asdfk2.daADd"),
                        "admin@rentcube.com",
                        role,
                        false,
                        false,
                        null
                );

                Profile profile = new Profile(
                        "Rent",
                        "Cube",
                        new Date(),
                        "https://ui-avatars.com/api/?name=Rent+Cube&rounded=true&%20bold=true&" +
                                "background=a8d267&color=000000"
                );

                user_temp.setProfile(profile);

                profile.setOwner(user_temp);

                userRepository.save(user_temp);
            }

            // Create hotel example:
            String shortD = "Short Description";
            String longD = "Long Description";
            hotelRepository.save(new Hotel(userRepository.findByEmail("admin@rentcube.com").orElse(null), "10",
                    "10", "10", shortD, longD, "4.5"));
        };
    }
}
