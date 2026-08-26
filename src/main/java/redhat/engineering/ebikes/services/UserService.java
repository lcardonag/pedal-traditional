package redhat.engineering.ebikes.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import redhat.engineering.ebikes.entities.Service_User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redhat.engineering.ebikes.repositories.UserRepository;

import jakarta.transaction.*;
import jakarta.persistence.*;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Service_User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<Service_User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public void deleteAUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Transactional
    public void createUser(Service_User userData) {
        entityManager.createNativeQuery("INSERT INTO service_user(fullname, username, email, user_role, password) VALUES (?,?,?,?)")
                .setParameter(1, userData.getFullname())
                .setParameter(2, userData.getUsername())
                .setParameter(3, userData.getEmail())
                .setParameter(4, userData.getUserRole())
                .setParameter(5, passwordEncoder.encode(userData.getPassword()) )
                .executeUpdate();
    }
}
