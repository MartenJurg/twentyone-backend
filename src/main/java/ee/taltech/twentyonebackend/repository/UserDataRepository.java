package ee.taltech.twentyonebackend.repository;

import ee.taltech.twentyonebackend.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Long> {
}