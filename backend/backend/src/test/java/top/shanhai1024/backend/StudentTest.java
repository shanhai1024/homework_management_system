package top.shanhai1024.backend;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import top.shanhai1024.service.StudentClassServer;

@SpringBootTest
public class StudentTest {
    @Autowired
    StudentClassServer studentClassServer;
    @Test
    void  selectAll(){
        Pageable pageable = PageRequest.of(1, 10);
        val all = studentClassServer.findAll(pageable);
        all.forEach(System.out::println);
    }
}
