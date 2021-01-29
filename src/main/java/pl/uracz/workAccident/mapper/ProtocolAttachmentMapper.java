package pl.uracz.workAccident.mapper;

import org.mapstruct.Mapper;
import pl.uracz.workAccident.dto.ProtocolAttachmentDto;
import pl.uracz.workAccident.entity.ProtocolAttachment;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface ProtocolAttachmentMapper {

    ProtocolAttachment attachmentFromDto (ProtocolAttachmentDto protocolAttachmentDto);
    ProtocolAttachmentDto dtoFromProtocolAttachment (ProtocolAttachment protocolAttachment);
    Set<ProtocolAttachmentDto> protocolAttachmentToDto (Set<ProtocolAttachment> protocolAttachments);
}
