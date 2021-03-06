package pl.uracz.workAccident.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.uracz.workAccident.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findByCompanyName (String companyName);
    boolean existsByCompanyName (String companyName);
    Company findByCompanyNameAndTaxIdentificationNumber(String companyName, String nip);
}
