package gr.uoa.di.rent.repositories;

import gr.uoa.di.rent.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Returns a user with a specific email
    Optional<User> findByEmail(String email);
}