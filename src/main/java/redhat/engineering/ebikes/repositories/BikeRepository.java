package redhat.engineering.ebikes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import redhat.engineering.ebikes.entities.Bike;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long> { }

