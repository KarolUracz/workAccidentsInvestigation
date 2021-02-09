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
import pl.uracz.workAccident.entity.Victim;
import pl.uracz.workAccident.entity.VictimAddress;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
class VictimRepositoryTest {

    @Autowired
    VictimRepository victimRepository;

    @Autowired
    VictimAddressRepository victimAddressRepository;

    @BeforeEach
    public void init() {
        Victim victim = new Victim();
        victim.setId(1L);
        victim.setName("test");
        victim.setSurname("test");
        victim.setBirthDate(LocalDate.parse("1980-04-11"));
        victim.setProfessionCode("111");
        victim.setWorkDepartment("work");
        victim.setWorkplace("company");
        VictimAddress victimAddress = new VictimAddress();
        victimAddress.setId(1L);
        victimAddress.setCity("city");
        victimAddress.setStreet("street");
        victimAddress.setHouseNumber("1a");
        victimAddress.setApartmentNumber(11);
        victimAddress.setIdentificationDocumentNumber("111111");
        victimAddress.setPeselNumber("123456");
        victimAddress.setPostCode("123");
        victimAddressRepository.save(victimAddress);
        victim.setAddress(victimAddress);
        victimRepository.save(victim);
    }

    @Test
    void findByNameAndSurname() {
        Victim byNameAndSurname = victimRepository.findByNameAndSurname("test", "test");
        assertEquals("test", byNameAndSurname.getSurname());
        assertEquals("test", byNameAndSurname.getName());
    }
}