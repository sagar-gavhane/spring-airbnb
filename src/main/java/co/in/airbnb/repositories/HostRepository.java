package co.in.airbnb.repositories;

import co.in.airbnb.entities.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostRepository extends JpaRepository<Host, Integer> {
}
