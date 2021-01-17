package pl.uracz.workAccident.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.uracz.workAccident.entity.VictimAddress;

@Repository
public interface VictimAddressRepository extends JpaRepository<VictimAddress, Long> {
}
