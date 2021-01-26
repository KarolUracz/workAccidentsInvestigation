package pl.uracz.workAccident.service.impl;

import org.springframework.stereotype.Service;
import pl.uracz.workAccident.dto.*;
import pl.uracz.workAccident.entity.*;
import pl.uracz.workAccident.mapper.*;
import pl.uracz.workAccident.repository.*;
import pl.uracz.workAccident.service.AccidentProtocolService;

import java.util.ArrayList;
import java.util.List;


@Service
public class AccidentProtocolServiceImpl implements AccidentProtocolService {

    private AccidentProtocolRepository accidentProtocolRepository;
    private AccidentProtocolMapper accidentProtocolMapper;
    private AccidentCauseRepository accidentCauseRepository;
    private AccidentCauseMapper accidentCauseMapper;
    private AccidentEffectRepository accidentEffectRepository;
    private AccidentEffectMapper accidentEffectMapper;
    private AccidentsInvestigatorRepository accidentsInvestigatorRepository;
    private AccidentInvestigatorMapper accidentInvestigatorMapper;
    private AccidentTypeRepository accidentTypeRepository;
    private AccidentTypeMapper accidentTypeMapper;
    private AfterAccidentRecommendationRepository afterAccidentRecommendationRepository;
    private AfterAccidentRecommendationMapper afterAccidentRecommendationMapper;
    private ProtocolAttachmentRepository protocolAttachmentRepository;
    private ProtocolAttachmentMapper protocolAttachmentMapper;
    private VictimAddressRepository victimAddressRepository;
    private VictimAddressMapper victimAddressMapper;
    private VictimRepository victimRepository;
    private VictimMapper victimMapper;
    private CompanyRepository companyRepository;
    private CompanyMapper companyMapper;

    public AccidentProtocolServiceImpl(AccidentProtocolRepository accidentProtocolRepository,
                                       AccidentProtocolMapper accidentProtocolMapper,
                                       AccidentCauseRepository accidentCauseRepository,
                                       AccidentCauseMapper accidentCauseMapper,
                                       AccidentEffectRepository accidentEffectRepository,
                                       AccidentEffectMapper accidentEffectMapper,
                                       AccidentsInvestigatorRepository accidentsInvestigatorRepository,
                                       AccidentInvestigatorMapper accidentInvestigatorMapper,
                                       AccidentTypeRepository accidentTypeRepository,
                                       AccidentTypeMapper accidentTypeMapper,
                                       AfterAccidentRecommendationRepository afterAccidentRecommendationRepository,
                                       AfterAccidentRecommendationMapper afterAccidentRecommendationMapper,
                                       ProtocolAttachmentRepository protocolAttachmentRepository,
                                       ProtocolAttachmentMapper protocolAttachmentMapper,
                                       VictimAddressRepository victimAddressRepository,
                                       VictimAddressMapper victimAddressMapper,
                                       VictimRepository victimRepository,
                                       VictimMapper victimMapper, CompanyRepository companyRepository,
                                       CompanyMapper companyMapper) {
        this.accidentProtocolRepository = accidentProtocolRepository;
        this.accidentProtocolMapper = accidentProtocolMapper;
        this.accidentCauseRepository = accidentCauseRepository;
        this.accidentCauseMapper = accidentCauseMapper;
        this.accidentEffectRepository = accidentEffectRepository;
        this.accidentEffectMapper = accidentEffectMapper;
        this.accidentsInvestigatorRepository = accidentsInvestigatorRepository;
        this.accidentInvestigatorMapper = accidentInvestigatorMapper;
        this.accidentTypeRepository = accidentTypeRepository;
        this.accidentTypeMapper = accidentTypeMapper;
        this.afterAccidentRecommendationRepository = afterAccidentRecommendationRepository;
        this.afterAccidentRecommendationMapper = afterAccidentRecommendationMapper;
        this.protocolAttachmentRepository = protocolAttachmentRepository;
        this.protocolAttachmentMapper = protocolAttachmentMapper;
        this.victimAddressRepository = victimAddressRepository;
        this.victimAddressMapper = victimAddressMapper;
        this.victimRepository = victimRepository;
        this.victimMapper = victimMapper;
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
    }

    @Override
    public List<AccidentProtocol> findAll() {
        return accidentProtocolRepository.findAll();
    }

    @Override
    public void saveAccidentProtocol(AccidentProtocol accidentProtocol) {
        accidentProtocolRepository.save(accidentProtocol);
    }

    @Override
    public void saveAccidentProtocol(AccidentProtocolDto accidentProtocolDto) {
        AccidentProtocol accidentProtocol = accidentProtocolMapper.protocolFromDto(accidentProtocolDto);
        AccidentProtocol byProtocolNumber = accidentProtocolRepository.findByProtocolNumber(accidentProtocol.getProtocolNumber());
        if (byProtocolNumber != null) {
            accidentProtocol.setId(byProtocolNumber.getId());
        }
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
            AccidentProtocol byProtocolNumber = accidentProtocolRepository.findByProtocolNumber(protocolNumber);
            return byProtocolNumber;
        }
        return null;
    }

    @Override
    public boolean existByProtocolNumber(String protocolNumber) {
        return accidentProtocolRepository.existsAccidentProtocolByProtocolNumber(protocolNumber);
    }
}
