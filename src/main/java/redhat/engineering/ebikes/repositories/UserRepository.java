package redhat.engineering.ebikes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import redhat.engineering.ebikes.entities.Service_User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Service_User, Long> {
    Optional<Service_User> findUserByUsername(String username);
}

