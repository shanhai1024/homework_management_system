package top.shanhai1024.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.shanhai1024.service.PersonnelService;

import java.util.List;

@SpringBootTest
class BackendApplicationTests {
    @Autowired
    PersonnelService personnelService;

    @Test
    void contextLoads() {
        List<Object[]> personnelStatisticsData = personnelService.getPersonnelStatisticsData();
        System.out.println(personnelStatisticsData);
    }


}
