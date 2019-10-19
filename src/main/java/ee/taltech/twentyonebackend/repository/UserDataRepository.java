package ee.taltech.twentyonebackend.repository;

import ee.taltech.twentyonebackend.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Long> {
    Optional<UserData> findByUsername(String username);
}
