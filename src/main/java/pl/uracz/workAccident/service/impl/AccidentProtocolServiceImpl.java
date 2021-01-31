package pl.uracz.workAccident.service.impl;

import org.springframework.stereotype.Service;
import pl.uracz.workAccident.dto.*;
import pl.uracz.workAccident.entity.*;
import pl.uracz.workAccident.mapper.*;
import pl.uracz.workAccident.repository.*;
import pl.uracz.workAccident.service.AccidentProtocolService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
public class AccidentProtocolServiceImpl implements AccidentProtocolService {

    private final AccidentProtocolRepository accidentProtocolRepository;
    private final AccidentProtocolMapper accidentProtocolMapper;
    private final AccidentRegisterMapper accidentRegisterMapper;
    private final AccidentRegisterRepository accidentRegisterRepository;
    private final CompanyRepository companyRepository;
    private final AccidentRegisterMapper registerMapper;
    private final AccidentRegisterRepository registerRepository;
    private final AccidentsInvestigatorRepository investigatorRepository;
    private final AccidentCauseRepository causeRepository;
    private final AccidentEffectRepository effectRepository;
    private final AfterAccidentRecommendationRepository recommendationRepository;
    private final ProtocolAttachmentRepository protocolAttachmentRepository;
    private final VictimRepository victimRepository;
    private final VictimAddressRepository victimAddressRepository;


    public AccidentProtocolServiceImpl(AccidentProtocolRepository accidentProtocolRepository,
                                       AccidentProtocolMapper accidentProtocolMapper, CompanyRepository companyRepository, AccidentRegisterMapper registerMapper, AccidentRegisterRepository registerRepository, AccidentsInvestigatorRepository investigatorRepository, AccidentCauseRepository causeRepository, AccidentEffectRepository effectRepository, AfterAccidentRecommendationRepository recommendationRepository, ProtocolAttachmentRepository protocolAttachmentRepository, VictimRepository victimRepository, VictimAddressRepository victimAddressRepository, AccidentRegisterMapper accidentRegisterMapper, AccidentRegisterRepository accidentRegisterRepository) {
        this.accidentProtocolRepository = accidentProtocolRepository;
        this.accidentProtocolMapper = accidentProtocolMapper;
        this.accidentRegisterMapper = accidentRegisterMapper;
        this.companyRepository = companyRepository;
        this.registerMapper = registerMapper;
        this.registerRepository = registerRepository;
        this.investigatorRepository = investigatorRepository;
        this.causeRepository = causeRepository;
        this.effectRepository = effectRepository;
        this.recommendationRepository = recommendationRepository;
        this.protocolAttachmentRepository = protocolAttachmentRepository;
        this.victimRepository = victimRepository;
        this.victimAddressRepository = victimAddressRepository;
        this.accidentRegisterRepository = accidentRegisterRepository;
    }

    @Override
    public List<AccidentProtocol> findAll() {
        return accidentProtocolRepository.findAll();
    }

    @Override
    public void saveAccidentProtocol(AccidentProtocolDto accidentProtocolDto, User user) {
        AccidentProtocol accidentProtocol = accidentProtocolMapper.protocolFromDto(accidentProtocolDto);

        Company byCompanyName = companyRepository.findByCompanyName(accidentProtocol.getCompany().getCompanyName());
        if (byCompanyName != null) {
            accidentProtocol.setCompany(byCompanyName);
        }
//        companyRepository.save(accidentProtocol.getCompany());

        for (AccidentInvestigator accidentInvestigator: accidentProtocol.getAccidentInvestigators()) {
            accidentInvestigator.setCompany(user.getCompany());
        }

        Victim byNameAndSurname = victimRepository.findByNameAndSurname(accidentProtocol.getVictim().getName(), accidentProtocol.getVictim().getSurname());
        if (byNameAndSurname != null) {
            accidentProtocol.setVictim(byNameAndSurname);
        }
//        victimRepository.save(accidentProtocol.getVictim());

        accidentProtocol.setUser(user);

//        accidentProtocolRepository.save(accidentProtocol);
//
//        if (accidentProtocol.isFinishedProtocol()) {
//            AccidentRegister accidentRegister = accidentRegisterMapper.registerFromProtocol(accidentProtocol);
//            accidentRegister.setCompany(user.getCompany());
//            accidentRegisterRepository.save(accidentRegister);
//        }
        accidentProtocolRepository.save(accidentProtocol);
    }

    @Override
    public AccidentProtocol readAccidentProtocol(long id) {
        return accidentProtocolRepository.getOne(id);
    }

    @Override
    public int deleteAccidentProtocol(String protocolNumber) {
        return accidentProtocolRepository.deleteAccidentProtocolByProtocolNumber(protocolNumber);
    }

    @Override
    public Integer numberOfAccidents() {
        return accidentProtocolRepository.numberOfAccidents();
    }

    //TODO: create mapper for below method
    @Override
    public List<UnfinishedProtocolDto> findAllUnfinished() {
        List<AccidentProtocol> allUnfinished = accidentProtocolRepository.findAllUnfinished();
        List<UnfinishedProtocolDto> allUnfinishedDto = new ArrayList<>();
        for (AccidentProtocol accidentProtocol : allUnfinished) {
            UnfinishedProtocolDto unfinishedProtocolDto = new UnfinishedProtocolDto();
            unfinishedProtocolDto.setUnfinishedProtocolNumber(accidentProtocol.getProtocolNumber());
            unfinishedProtocolDto.setAccidentDate(accidentProtocol.getAccidentDate());
            unfinishedProtocolDto.setReportedDate(accidentProtocol.getReportedDate());
            unfinishedProtocolDto.setVictimFullName(accidentProtocol.getVictim().getName() + " " + accidentProtocol.getVictim().getSurname());
            allUnfinishedDto.add(unfinishedProtocolDto);
        }
        return allUnfinishedDto;
    }

    @Override
    public AccidentProtocol findByProtocolNumber(String protocolNumber) {
        if (accidentProtocolRepository.existsAccidentProtocolByProtocolNumber(protocolNumber)) {
            return accidentProtocolRepository.findByProtocolNumber(protocolNumber);
        }
        return null;
    }

    @Override
    public void updateAccident(AccidentProtocol accidentProtocol) {
        if (accidentProtocol.isFinishedProtocol()) {
            AccidentRegister accidentRegister = accidentRegisterMapper.registerFromProtocol(accidentProtocol);
            accidentRegisterRepository.save(accidentRegister);
        }
        accidentProtocolRepository.save(accidentProtocol);
    }

    @Override
    public AccidentProtocol findById(long id) {
        return accidentProtocolRepository.findById(id).orElse(null);
    }
}
