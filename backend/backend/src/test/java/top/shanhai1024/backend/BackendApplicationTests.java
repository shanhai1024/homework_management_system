package top.shanhai1024.backend;

import jakarta.transaction.Transactional;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import top.shanhai1024.entity.PO.PersonnelClass;
import top.shanhai1024.service.PersonnelClassService;
import top.shanhai1024.service.PersonnelService;

import java.util.List;


@SpringBootTest
@Transactional
class BackendApplicationTests {
    @Autowired
    PersonnelClassService personnelClassService;
@Autowired
    PersonnelService personnelService;

    //
    @Test
    void contextLoads() {
        List<Object[]> personnelStatisticsData = personnelService.getPersonnelStatisticsData();
        personnelStatisticsData
                        .forEach(System.out::println);

    }
//    @Test
//    void deleteById(){
//        personnelService.deleteById(25L);
//    }
    @Test
    void getAll(){
        Pageable pageable = PageRequest.of(1, 10);
       val all = personnelService.getAllPersonnelData(pageable);
        all.forEach(System.out::println);
    }
    @Test
    void getAllData() {
        System.out.println(personnelClassService.getAllClass());
    }

    @Test
    void deleteById() {
        System.out.println(personnelClassService.deletePersonnelClassesById(3));
    }
    @Test
    void save(){
        personnelClassService.updatePersonnelClasses(new PersonnelClass(8,"123"));
    }



}
