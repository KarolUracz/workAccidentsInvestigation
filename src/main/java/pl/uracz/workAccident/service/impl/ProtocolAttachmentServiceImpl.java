package pl.uracz.workAccident.service.impl;

import org.springframework.stereotype.Service;
import pl.uracz.workAccident.dto.ProtocolAttachmentDto;
import pl.uracz.workAccident.entity.ProtocolAttachment;
import pl.uracz.workAccident.mapper.ProtocolAttachmentMapper;
import pl.uracz.workAccident.repository.ProtocolAttachmentRepository;
import pl.uracz.workAccident.service.ProtocolAttachmentService;

import java.util.List;

@Service
public class ProtocolAttachmentServiceImpl implements ProtocolAttachmentService {

    private ProtocolAttachmentRepository protocolAttachmentRepository;
    private ProtocolAttachmentMapper protocolAttachmentMapper;

    public ProtocolAttachmentServiceImpl(ProtocolAttachmentRepository protocolAttachmentRepository, ProtocolAttachmentMapper protocolAttachmentMapper) {
        this.protocolAttachmentRepository = protocolAttachmentRepository;
        this.protocolAttachmentMapper = protocolAttachmentMapper;
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
    public void saveProtocolAttachment(ProtocolAttachmentDto protocolAttachmentDto) {
        ProtocolAttachment protocolAttachment = protocolAttachmentMapper.attachmentFromDto(protocolAttachmentDto);
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
