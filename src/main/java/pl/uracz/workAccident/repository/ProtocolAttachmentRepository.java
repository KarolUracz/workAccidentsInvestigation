package pl.uracz.workAccident.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.uracz.workAccident.entity.ProtocolAttachment;

@Repository
public interface ProtocolAttachmentRepository extends JpaRepository<ProtocolAttachment, Long> {
}
