package pl.uracz.workAccident.repository;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import pl.uracz.workAccident.entity.Role;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
class RoleRepositoryTest {

    @Autowired
    RoleRepository repository;

    @BeforeEach
    public void init() {
        Role role = new Role();
        role.setId(1L);
        role.setName("ROLE_USER");
        repository.save(role);
    }

    @Test
    void findByName() {
        Role role_user = repository.findByName("ROLE_USER");
        assertEquals("ROLE_USER", role_user.getName());
    }

    @Test
    void existsRoleByName() {
        boolean role_user = repository.existsRoleByName("ROLE_USER");
        assertTrue(role_user);
    }
}