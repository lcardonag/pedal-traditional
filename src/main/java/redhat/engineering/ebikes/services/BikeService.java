package redhat.engineering.ebikes.services;

import redhat.engineering.ebikes.entities.Bike;
import redhat.engineering.ebikes.repositories.BikeRepository;
import redhat.engineering.ebikes.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BikeService {
    private final BikeRepository bikeRepository;
    private final UserRepository userRepository;
    private final EntityManager entityManager;

    @Autowired
    public BikeService(BikeRepository bikeRepository, UserRepository userRepository, EntityManager entityManager) {
        this.bikeRepository = bikeRepository;
        this.userRepository = userRepository;
        this.entityManager = entityManager;
    }

    @Transactional
    public List<Bike> getBikes() {
        return bikeRepository.findAll();
    }

    @Transactional
    public Optional<Bike> getBike(Long bikeId) {
        return bikeRepository.findById(bikeId);
    }

    public void deleteBike(Long bikeId) {
        bikeRepository.deleteById(bikeId);
    }

    @Transactional
    public void createBikeAd(Bike bikeData) {
        entityManager.createNativeQuery("INSERT INTO bikes(name, model, price, warranty_status) VALUES (?,?,?,?)")
                .setParameter(1, bikeData.getName())
                .setParameter(2, bikeData.getModel())
                .setParameter(3, bikeData.getPrice())
                .setParameter(4, bikeData.getWarrantyStatus())
                .executeUpdate();
    }

    @Transactional
    public void purchaseBike(Optional<Bike> bikeData) {
        bikeData.ifPresent(bike -> entityManager.createNativeQuery("INSERT INTO bike_order(product_id, customer_id, price) VALUES (?,?,?)")
                .setParameter(1, bike.getId())
                .setParameter(2, 26)
                .setParameter(3, bike.getPrice())
                .executeUpdate());
    }
}
