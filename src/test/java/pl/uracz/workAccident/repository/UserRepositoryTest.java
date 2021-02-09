package pl.uracz.workAccident.repository;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import pl.uracz.workAccident.entity.Company;
import pl.uracz.workAccident.entity.Role;
import pl.uracz.workAccident.entity.User;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Test
    void findByUsername() {
        User user = new User();
        user.setId(1L);
        user.setUsername("test");
        user.setPassword("test");
        Company company = new Company();
        company.setId(1L);
        company.setCompanyName("testCompany");
        company.setPkdNumber("123");
        company.setCity("wawa");
        company.setPostalCode("12345");
        company.setStreet("street");
        company.setTaxIdentificationNumber("1234");
        companyRepository.save(company);
        user.setCompany(company);
        Role role = new Role();
        role.setId(1L);
        role.setName("ROLE_USER");
        roleRepository.save(role);
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);
        User test = userRepository.findByUsername("test");
        Assertions.assertEquals("test", test.getUsername());
    }
}