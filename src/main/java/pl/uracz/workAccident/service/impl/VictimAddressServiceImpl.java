package pl.uracz.workAccident.service.impl;

import org.springframework.stereotype.Service;
import pl.uracz.workAccident.dto.VictimAddressDto;
import pl.uracz.workAccident.entity.VictimAddress;
import pl.uracz.workAccident.mapper.VictimAddressMapper;
import pl.uracz.workAccident.repository.VictimAddressRepository;
import pl.uracz.workAccident.service.VictimAddressService;

import java.util.List;

@Service
public class VictimAddressServiceImpl implements VictimAddressService {

    private VictimAddressRepository victimAddressRepository;
    private VictimAddressMapper victimAddressMapper;

    public VictimAddressServiceImpl(VictimAddressRepository victimAddressRepository, VictimAddressMapper victimAddressMapper) {
        this.victimAddressRepository = victimAddressRepository;
        this.victimAddressMapper = victimAddressMapper;
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
    public void saveVictimAddress(VictimAddressDto victimAddressDto) {
        VictimAddress victimAddress = victimAddressMapper.victimAddressFromDto(victimAddressDto);
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
