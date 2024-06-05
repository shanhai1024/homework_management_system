package top.shanhai1024.backend;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.shanhai1024.entity.PO.PersonnelClass;
import top.shanhai1024.service.PersonnelClassServer;


@SpringBootTest
@Transactional
class BackendApplicationTests {
    @Autowired
    PersonnelClassServer personnelClassServer;


    //
//    @Test
//    void contextLoads() {
//        List<Object[]> personnelStatisticsData = personnelService.getPersonnelStatisticsData();
//        personnelStatisticsData
//                        .forEach(System.out::println);
//
//    }
//    @Test
//    void deleteById(){
//        personnelService.deleteById(25L);
//    }
//    @Test
//    void getAll(){
//        List<Object> allPersonnelData = personnelRepository.getAllPersonnelData();
//        allPersonnelData.forEach(System.out::println);
//    }
    @Test
    void getAllData() {
        System.out.println(personnelClassServer.getAllClass());
    }

    @Test
    void deleteById() {
        System.out.println(personnelClassServer.deletePersonnelClassesById(3));
    }
    @Test
    void save(){
        personnelClassServer.updatePersonnelClasses(new PersonnelClass(8,"123"));
    }


}
