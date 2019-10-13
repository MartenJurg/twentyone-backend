package ee.taltech.twentyonebackend.repository;

import java.util.Optional;

import ee.taltech.twentyonebackend.model.Role;
import ee.taltech.twentyonebackend.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}