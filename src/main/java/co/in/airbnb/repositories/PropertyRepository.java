package co.in.airbnb.repositories;

import co.in.airbnb.entities.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer> {
}
