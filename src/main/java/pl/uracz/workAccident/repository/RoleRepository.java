package pl.uracz.workAccident.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.uracz.workAccident.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName (String name);
    boolean existsRoleByName(String name);
}
