package pl.uracz.workAccident.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import pl.uracz.workAccident.entity.AccidentEffect;
import pl.uracz.workAccident.entity.AccidentRegister;
import pl.uracz.workAccident.entity.AfterAccidentRecommendation;
import pl.uracz.workAccident.entity.Company;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class AccidentRegisterRepositoryTest {

    @Autowired
    AccidentRegisterRepository accidentRegisterRepository;

    @Autowired
    AccidentEffectRepository accidentEffectRepository;

    @Autowired
    AfterAccidentRecommendationRepository afterAccidentRecommendationRepository;

    @Autowired
    CompanyRepository companyRepository;

    @BeforeEach
    public void init(){
        AccidentRegister accidentRegister = new AccidentRegister();
        accidentRegister.setId(1L);
        accidentRegister.setProtocolNumber("1/1/1");
        accidentRegister.setDateOfPreparation(LocalDate.parse("2020-02-02"));
        accidentRegister.setVictimFullName("victim name");
        accidentRegister.setAccidentPlace("workplace");
        accidentRegister.setAccidentDate(LocalDate.parse("2020-01-10"));
        AccidentEffect accidentEffect = new AccidentEffect();
        accidentEffect.setId(1L);
        accidentEffect.setAccidentEffect("effect");
        accidentEffectRepository.save(accidentEffect);
        List<AccidentEffect> effects = Collections.singletonList(accidentEffect);
        accidentRegister.setAccidentEffects(effects);
        accidentRegister.setDaysOfWorkAbsence(12);
        accidentRegister.setAccidentAtWork(true);
        accidentRegister.setDateOfDeliveryToZus(LocalDate.parse("2020-02-14"));
        AfterAccidentRecommendation recommendation = new AfterAccidentRecommendation();
        recommendation.setId(1L);
        recommendation.setRecommendation("recommendation");
        afterAccidentRecommendationRepository.save(recommendation);
        List<AfterAccidentRecommendation> recommendations = Collections.singletonList(recommendation);
        accidentRegister.setAfterAccidentRecommendations(recommendations);
        Company company = new Company();
        company.setId(1L);
        company.setCompanyName("test");
        company.setStreet("street");
        company.setCity("city");
        company.setPostalCode("123");
        company.setTaxIdentificationNumber("1111");
        company.setPkdNumber("1");
        companyRepository.save(company);
        accidentRegister.setCompany(company);
        accidentRegisterRepository.save(accidentRegister);
    }

    @AfterEach

    @Test
    void existsByProtocolNumber() {
        boolean b = accidentRegisterRepository.existsByProtocolNumber("1/1/1");
        assertTrue(b);
    }

    @Test
    void findByProtocolNumber() {
        AccidentRegister byProtocolNumber = accidentRegisterRepository.findByProtocolNumber("1/1/1");
        assertNotNull(byProtocolNumber);
        assertEquals("1/1/1", byProtocolNumber.getProtocolNumber());
    }

    @Test
    void findByCompany() {
        Company company = new Company();
        company.setId(1L);
        company.setCompanyName("test");
        company.setStreet("street");
        company.setCity("city");
        company.setPostalCode("123");
        company.setTaxIdentificationNumber("1111");
        company.setPkdNumber("1");
        List<AccidentRegister> byCompany = accidentRegisterRepository.findByCompany(company);
        assertEquals(1, byCompany.size());
    }

    @Test
    void findByProtocolNumberAndCompany() {
        Company company = new Company();
        company.setId(1L);
        company.setCompanyName("test");
        company.setStreet("street");
        company.setCity("city");
        company.setPostalCode("123");
        company.setTaxIdentificationNumber("1111");
        company.setPkdNumber("1");
        AccidentRegister numberAndCompany = accidentRegisterRepository.findByProtocolNumberAndCompany("1/1/1", company);
        assertEquals(company, numberAndCompany.getCompany());
    }
}