package pl.uracz.workAccident.service.impl;

import org.springframework.stereotype.Service;
import pl.uracz.workAccident.entity.VictimAddress;
import pl.uracz.workAccident.repository.VictimAddressRepository;
import pl.uracz.workAccident.service.VictimAddressService;

import java.util.List;

@Service
public class VictimAddressServiceImpl implements VictimAddressService {

    private VictimAddressRepository victimAddressRepository;

    public VictimAddressServiceImpl(VictimAddressRepository victimAddressRepository) {
        this.victimAddressRepository = victimAddressRepository;
    }

    @Override
    public List<VictimAddress> findAll() {
        return victimAddressRepository.findAll();
    }

    @Override
    public void saveVictimAddress(VictimAddress victimAddress) {
        victimAddressRepository.save(victimAddress);
    }

    @Override
    public VictimAddress readVictimAddress(long id) {
        return victimAddressRepository.getOne(id);
    }

    @Override
    public void deleteVictimAddress(long id) {
        victimAddressRepository.deleteById(id);
    }
}
