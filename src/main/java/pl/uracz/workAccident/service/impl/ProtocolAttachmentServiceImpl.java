package pl.uracz.workAccident.service.impl;

import org.springframework.stereotype.Service;
import pl.uracz.workAccident.entity.ProtocolAttachment;
import pl.uracz.workAccident.repository.ProtocolAttachmentRepository;
import pl.uracz.workAccident.service.ProtocolAttachmentService;

import java.util.List;

@Service
public class ProtocolAttachmentServiceImpl implements ProtocolAttachmentService {

    private ProtocolAttachmentRepository protocolAttachmentRepository;

    public ProtocolAttachmentServiceImpl(ProtocolAttachmentRepository protocolAttachmentRepository) {
        this.protocolAttachmentRepository = protocolAttachmentRepository;
    }

    @Override
    public List<ProtocolAttachment> findAll() {
        return protocolAttachmentRepository.findAll();
    }

    @Override
    public void saveProtocolAttachment(ProtocolAttachment protocolAttachment) {
        protocolAttachmentRepository.save(protocolAttachment);
    }

    @Override
    public ProtocolAttachment readProtocolAttachment(long id) {
        return protocolAttachmentRepository.getOne(id);
    }

    @Override
    public void deleteProtocolAttachment(long id) {
        protocolAttachmentRepository.deleteById(id);
    }
}
