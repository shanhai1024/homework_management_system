package top.shanhai1024.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class seudentClass {
    @Autowired
    StudentClassService studentClassService;
    @Test
    void findAll(){
        studentClassService.findAll();
    }
}
