package ee.taltech.twentyonebackend.repository;

import ee.taltech.twentyonebackend.model.UserInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserInventoryRepository  extends JpaRepository<UserInventory, Long> {
    Optional<UserInventory> findByUsername(String username);
}
