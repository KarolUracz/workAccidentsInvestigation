package pl.uracz.workAccident.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import pl.uracz.workAccident.entity.*;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class AccidentProtocolRepositoryTest {

    @Autowired
    AccidentProtocolRepository accidentProtocolRepository;
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    AccidentsInvestigatorRepository accidentsInvestigatorRepository;
    @Autowired
    VictimRepository victimRepository;
    @Autowired
    VictimAddressRepository victimAddressRepository;
    @Autowired
    AccidentCauseRepository accidentCauseRepository;
    @Autowired
    AccidentEffectRepository accidentEffectRepository;
    @Autowired
    AfterAccidentRecommendationRepository afterAccidentRecommendationRepository;
    @Autowired
    ProtocolAttachmentRepository protocolAttachmentRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @BeforeEach
    public void init(){
        AccidentProtocol accidentProtocol = new AccidentProtocol();
        accidentProtocol.setId(1L);
        accidentProtocol.setProtocolNumber("1/1/1");
        Company company = new Company();
        company.setId(1L);
        company.setCompanyName("test");
        company.setStreet("street");
        company.setCity("city");
        company.setPostalCode("123");
        company.setTaxIdentificationNumber("1111");
        company.setPkdNumber("1");
        companyRepository.save(company);
        accidentProtocol.setCompany(company);
        AccidentInvestigator investigator = new AccidentInvestigator();
        investigator.setId(1L);
        investigator.setCompany(company);
        investigator.setName("invName");
        investigator.setSurname("surname");
        investigator.setWorkPosition("investigator");
        accidentsInvestigatorRepository.save(investigator);
        accidentProtocol.setAccidentInvestigators(Collections.singletonList(investigator));
        accidentProtocol.setAccidentProceedingStart(LocalDate.parse("2020-02-02"));
        accidentProtocol.setAccidentProceedingEnd(LocalDate.parse("2020-02-16"));
        accidentProtocol.setAccidentDate(LocalDate.parse("2020-01-31"));
        accidentProtocol.setAccidentTime(LocalDateTime.of(2020, 1,31,17,45,30));
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
        accidentProtocol.setVictim(victim);
        accidentProtocol.setReportedBy("reportedBy");
        accidentProtocol.setReportedDate(LocalDate.parse("2020-01-31"));
        accidentProtocol.setAccidentCircumstances("circumstances");
        AccidentCause accidentCause = new AccidentCause();
        accidentCause.setId(1L);
        accidentCause.setAccidentCause("cause");
        accidentCauseRepository.save(accidentCause);
        accidentProtocol.setAccidentCauses(Collections.singletonList(accidentCause));
        accidentProtocol.setEmployerFault("true");
        accidentProtocol.setEmployeeFault("false");
        accidentProtocol.setEmployeeIntoxication("false");
        AccidentEffect effect = new AccidentEffect();
        effect.setId(1L);
        effect.setAccidentEffect("effect");
        accidentEffectRepository.save(effect);
        accidentProtocol.setAccidentEffects(Collections.singletonList(effect));
        accidentProtocol.setAccidentAtWork(true);
        accidentProtocol.setAccidentReason("reason");
        accidentProtocol.setIndividualAccident(true);
        accidentProtocol.setCollectiveAccident(false);
        accidentProtocol.setFatalAccident(false);
        accidentProtocol.setSeriousAccident(false);
        accidentProtocol.setWorkAbsence(true);
        AfterAccidentRecommendation recommendation = new AfterAccidentRecommendation();
        recommendation.setId(1L);
        recommendation.setRecommendation("recommendation");
        afterAccidentRecommendationRepository.save(recommendation);
        accidentProtocol.setAfterAccidentRecommendations(Collections.singletonList(recommendation));
        accidentProtocol.setDateOfPreparation(LocalDate.parse("2020-02-16"));
        accidentProtocol.setObstaclesOfPreparationInTerm("none");
        ProtocolAttachment attachment = new ProtocolAttachment();
        attachment.setId(1L);
        attachment.setAttachmentName("attachment");
        protocolAttachmentRepository.save(attachment);
        accidentProtocol.setProtocolAttachments(Collections.singletonList(attachment));
        accidentProtocol.setFinishedProtocol(true);
        User user = new User();
        user.setId(1L);
        user.setUsername("test");
        user.setPassword("test");
        user.setCompany(company);
        Role role = new Role();
        role.setId(1L);
        role.setName("ROLE_USER");
        roleRepository.save(role);
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);
        accidentProtocol.setUser(user);
        accidentProtocolRepository.save(accidentProtocol);
    }

    @Test
    void numberOfAccidents() {
//        Integer numberOfAccidents = accidentProtocolRepository.numberOfAccidents();
//        assertEquals(1, numberOfAccidents);
    }

    @Test
    void findAllUnfinished() {
        List<AccidentProtocol> allUnfinished = accidentProtocolRepository.findAllUnfinished();
        assertEquals(0, allUnfinished.size());
    }

    @Test
    void findByProtocolNumber() {
        AccidentProtocol byProtocolNumber = accidentProtocolRepository.findByProtocolNumber("1/1/1");
        assertEquals("1/1/1", byProtocolNumber.getProtocolNumber());
    }

    @Test
    @Transactional
    void deleteAccidentProtocolByProtocolNumber() {
//        accidentProtocolRepository.deleteAccidentProtocolByProtocolNumber("1/1/1");
//        AccidentProtocol byProtocolNumber = accidentProtocolRepository.findByProtocolNumber("1/1/1");
//        assertNull(byProtocolNumber);
    }

    @Test
    void existsAccidentProtocolByProtocolNumber() {
        assertTrue(accidentProtocolRepository.existsAccidentProtocolByProtocolNumber("1/1/1"));
    }
}