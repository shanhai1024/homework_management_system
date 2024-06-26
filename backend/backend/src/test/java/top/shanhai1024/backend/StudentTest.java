package top.shanhai1024.backend;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import top.shanhai1024.service.StudentClassService;

@SpringBootTest
public class StudentTest {
    @Autowired
    StudentClassService studentClassService;
    @Test
    void  selectAll(){
        Pageable pageable = PageRequest.of(0, 10);
        val all = studentClassService.findAll(pageable);
        all.forEach(System.out::println);
    }
}
