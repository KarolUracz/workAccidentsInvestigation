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
import pl.uracz.workAccident.entity.Company;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
class CompanyRepositoryTest {

    @Autowired
    CompanyRepository companyRepository;

    @BeforeEach
    public void init() {
        Company company = new Company();
        company.setId(1L);
        company.setCompanyName("test");
        company.setStreet("street");
        company.setCity("city");
        company.setPostalCode("123");
        company.setTaxIdentificationNumber("1111");
        company.setPkdNumber("1");
        companyRepository.save(company);
    }

    @Test
    void findByCompanyName() {
        Company test = companyRepository.findByCompanyName("test");
        assertEquals("test", test.getCompanyName());
    }

    @Test
    void existsByCompanyName() {
        boolean test = companyRepository.existsByCompanyName("test");
        assertTrue(test);
        assertFalse(companyRepository.existsByCompanyName("company"));
    }

    @Test
    void findByCompanyNameAndTaxIdentificationNumber() {
        Company test = companyRepository.findByCompanyNameAndTaxIdentificationNumber("test", "1111");
        assertEquals("test", test.getCompanyName());
        assertEquals("1111", test.getTaxIdentificationNumber());
    }
}