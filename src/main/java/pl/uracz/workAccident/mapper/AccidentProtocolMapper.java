package pl.uracz.workAccident.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.uracz.workAccident.dto.*;
import pl.uracz.workAccident.entity.*;

@Mapper(componentModel = "spring", uses = {AccidentInvestigatorMapper.class, AccidentEffectMapper.class,
AccidentCauseMapper.class, AfterAccidentRecommendationMapper.class, CompanyMapper.class, ProtocolAttachmentMapper.class,
VictimMapper.class})
public interface AccidentProtocolMapper {


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "victim", source = "victimDto")
    @Mapping(target = "protocolAttachments", source = "protocolAttachmentsDto")
    @Mapping(target = "company", source = "companyDto")
    @Mapping(target = "afterAccidentRecommendations", source = "afterAccidentRecommendationsDto")
    @Mapping(target = "accidentInvestigators", source = "accidentInvestigatorsDto")
    @Mapping(target = "accidentEffects", source = "accidentEffectsDto")
    @Mapping(target = "accidentCauses", source = "accidentCausesDto")
    AccidentProtocol protocolFromDto (AccidentProtocolDto accidentProtocolDto);

    @Mapping(target = "victimDto", source = "victim")
    @Mapping(target = "protocolAttachmentsDto", source = "protocolAttachments")
    @Mapping(target = "companyDto", source = "company")
    @Mapping(target = "afterAccidentRecommendationsDto", source = "afterAccidentRecommendations")
    @Mapping(target = "accidentEffectsDto", source = "accidentEffects")
    @Mapping(target = "accidentInvestigatorsDto", source = "accidentInvestigators")
    @Mapping(target = "accidentCausesDto", source = "accidentCauses")
    AccidentProtocolDto dtoFromAccidentProtocol(AccidentProtocol accidentProtocol);
}
