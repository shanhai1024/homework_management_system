package top.shanhai1024.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.shanhai1024.repository.PersonnelRepository;
import top.shanhai1024.service.PersonnelService;

import java.util.List;

@SpringBootTest
class BackendApplicationTests {
    @Autowired
    PersonnelService personnelService;
    PersonnelRepository personnelRepository;


    @Test
    void contextLoads() {
        List<Object[]> personnelStatisticsData = personnelService.getPersonnelStatisticsData();
        personnelStatisticsData
                        .forEach(System.out::println);

    }
    @Test
    void deleteById(){
        personnelService.deleteById(25L);
    }
    @Test
    void getAll(){
        List<Object> allPersonnelData = personnelRepository.getAllPersonnelData();
        allPersonnelData.forEach(System.out::println);
    }


}
