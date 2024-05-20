package top.shanhai1024.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.shanhai1024.entity.PO.YearlyData;
import top.shanhai1024.repository.YearlyDataRepository;

import java.util.List;

@Service
public class YearlyDataService {

    @Autowired
    private YearlyDataRepository yearlyDataRepository;

    @Transactional(readOnly = true)
    public List<YearlyData> getAllYearlyData() {
        return yearlyDataRepository.findAllByOrderByYearAsc();
    }
}
