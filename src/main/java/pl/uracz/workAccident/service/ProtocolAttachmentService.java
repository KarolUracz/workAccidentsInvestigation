package pl.uracz.workAccident.service;

import pl.uracz.workAccident.entity.ProtocolAttachment;

import java.util.List;

public interface ProtocolAttachmentService {
    List<ProtocolAttachment> findAll();
    boolean saveProtocolAttachment(ProtocolAttachment company);
    ProtocolAttachment readProtocolAttachment(long id);
    boolean updateProtocolAttachment(ProtocolAttachment company);
    boolean deleteProtocolAttachment(long id);
}
