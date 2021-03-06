package pl.uracz.workAccident.service;

import pl.uracz.workAccident.dto.ProtocolAttachmentDto;
import pl.uracz.workAccident.entity.ProtocolAttachment;

import java.util.List;

public interface ProtocolAttachmentService {
    List<ProtocolAttachment> findAll();
    void saveProtocolAttachment(ProtocolAttachment protocolAttachment);
    void saveProtocolAttachment(ProtocolAttachmentDto protocolAttachmentDto);
    ProtocolAttachment readProtocolAttachment(long id);
    void deleteProtocolAttachment(long id);
}
