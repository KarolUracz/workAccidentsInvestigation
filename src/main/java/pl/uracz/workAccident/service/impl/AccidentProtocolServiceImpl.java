package pl.uracz.workAccident.service.impl;

import org.springframework.stereotype.Service;
import pl.uracz.workAccident.dto.*;
import pl.uracz.workAccident.entity.*;
import pl.uracz.workAccident.mapper.*;
import pl.uracz.workAccident.repository.*;
import pl.uracz.workAccident.service.AccidentProtocolService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
                                       AccidentCauseRepository accidentCauseRepository, AccidentCauseMapper accidentCauseMapper,
                                       AccidentEffectRepository accidentEffectRepository, AccidentEffectMapper accidentEffectMapper,
                                       AccidentsInvestigatorRepository accidentsInvestigatorRepository, AccidentInvestigatorMapper accidentInvestigatorMapper,
                                       AccidentTypeRepository accidentTypeRepository, AccidentTypeMapper accidentTypeMapper,
                                       AfterAccidentRecommendationRepository afterAccidentRecommendationRepository, AfterAccidentRecommendationMapper afterAccidentRecommendationMapper,
                                       ProtocolAttachmentRepository protocolAttachmentRepository, ProtocolAttachmentMapper protocolAttachmentMapper,
                                       VictimAddressRepository victimAddressRepository, VictimAddressMapper victimAddressMapper, VictimRepository victimRepository, VictimMapper victimMapper, CompanyRepository companyRepository, CompanyMapper companyMapper) {
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
        Company company = new Company();
        if (companyRepository.existsByCompanyName(accidentProtocolDto.getCompanyDto().getCompanyName())){
            company = companyRepository.findByCompanyName(accidentProtocolDto.getCompanyDto().getCompanyName());
            accidentProtocol.setCompany(company);
        } else {
            company = companyMapper.companyDtoToCompany(accidentProtocolDto.getCompanyDto());
            accidentProtocol.setCompany(company);
            companyRepository.save(company);
        }

        Set<AccidentInvestigator> accidentInvestigators = new HashSet<>();
        for (AccidentInvestigatorDto accidentInvestigatorDto : accidentProtocolDto.getAccidentInvestigatorsDto()) {
            AccidentInvestigator accidentInvestigator = accidentInvestigatorMapper.accidentInvestigatorFromDto(accidentInvestigatorDto);
            accidentInvestigator.setCompany(company);
            accidentInvestigators.add(accidentInvestigator);
            accidentsInvestigatorRepository.save(accidentInvestigator);
        }
        accidentProtocol.setAccidentInvestigators(accidentInvestigators);

        Set<Victim> victims = new HashSet<>();
        for (VictimDto victimDto : accidentProtocolDto.getVictimDto()) {
            VictimAddress victimAddress = victimAddressMapper.victimAddressFromDto(victimDto.getAddressDto());
            victimAddressRepository.save(victimAddress);
            Victim victim = victimMapper.victimFromDto(victimDto);
            victim.setAddress(victimAddress);
            victims.add(victim);
            victimRepository.save(victim);
        }
        accidentProtocol.setVictim(victims);

        Set<AccidentCause> accidentCauses = new HashSet<>();
        for (AccidentCauseDto accidentCauseDto : accidentProtocolDto.getAccidentCausesDto()) {
            AccidentCause accidentCause = accidentCauseMapper.accidentCauseFromDto(accidentCauseDto);
            accidentCauses.add(accidentCause);
            accidentCauseRepository.save(accidentCause);
        }
        accidentProtocol.setAccidentCauses(accidentCauses);
        Set<AccidentEffect> accidentEffects = new HashSet<>();
        for (AccidentEffectDto accidentEffectDto : accidentProtocolDto.getAccidentEffectsDto()) {
            AccidentEffect accidentEffect = accidentEffectMapper.accidentEffectFromDto(accidentEffectDto);
            accidentEffects.add(accidentEffect);
            accidentEffectRepository.save(accidentEffect);
        }
        accidentProtocol.setAccidentEffects(accidentEffects);

        Set<AccidentType> accidentTypes = new HashSet<>();
        for (AccidentTypeDto accidentTypeDto : accidentProtocolDto.getAccidentTypeDto()) {
            AccidentType accidentType = accidentTypeMapper.accidentTypeFromDto(accidentTypeDto);
            accidentTypes.add(accidentType);
            accidentTypeRepository.save(accidentType);
        }
        accidentProtocol.setAccidentType(accidentTypes);

        Set<AfterAccidentRecommendation> afterAccidentRecommendations = new HashSet<>();
        for (AfterAccidentRecommendationDto afterAccidentRecommendationDto : accidentProtocolDto.getAfterAccidentRecommendationsDto()) {
            AfterAccidentRecommendation afterAccidentRecommendation = afterAccidentRecommendationMapper.accidentRecommendationFromDto(afterAccidentRecommendationDto);
            afterAccidentRecommendations.add(afterAccidentRecommendation);
            afterAccidentRecommendationRepository.save(afterAccidentRecommendation);
        }
        accidentProtocol.setAfterAccidentRecommendations(afterAccidentRecommendations);

        Set<ProtocolAttachment> protocolAttachments = new HashSet<>();
        for (ProtocolAttachmentDto protocolAttachmentDto : accidentProtocolDto.getProtocolAttachmentsDto()) {
            ProtocolAttachment protocolAttachment = protocolAttachmentMapper.attachmentFromDto(protocolAttachmentDto);
            protocolAttachments.add(protocolAttachment);
            protocolAttachmentRepository.save(protocolAttachment);
        }
        accidentProtocol.setProtocolAttachments(protocolAttachments);

        accidentProtocolRepository.save(accidentProtocol);
    }

    @Override
    public AccidentProtocol readAccidentProtocol(long id) {
        return accidentProtocolRepository.getOne(id);
    }

    @Override
    public void deleteAccidentProtocol(long id) {
        accidentProtocolRepository.deleteById(id);
    }

    @Override
    public Integer numberOfAccidents() {
        return accidentProtocolRepository.numberOfAccidents();
    }

    @Override
    public List<AccidentProtocol> findAllUnfinished() {
        return accidentProtocolRepository.findAllUnfinished();
    }
}
