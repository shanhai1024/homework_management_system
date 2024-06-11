package top.shanhai1024.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import top.shanhai1024.entity.PO.Personnel;
import top.shanhai1024.repository.PersonnelRepository;
import top.shanhai1024.service.PersonnelService;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonnelServiceImpl implements PersonnelService {
    private final PersonnelRepository personnelRepository;

    @Override
    public List<Object[]> getPersonnelStatisticsData() {
        return personnelRepository.getPersonnelStatisticsData();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        personnelRepository.deleteById(id);

    }

    @Override
    public Page<Object> getAllPersonnelData(Pageable pageable) {
        return personnelRepository.getAllPersonnelData(pageable);
    }

    @Override
    public void addPersonnel(Personnel personnel) {
        personnelRepository.save(personnel);
    }
}
