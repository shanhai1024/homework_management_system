package top.shanhai1024.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
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
}
