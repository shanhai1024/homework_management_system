package top.shanhai1024.backend;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.shanhai1024.service.TeacherService;

@SpringBootTest
public class Teacher {
    @Autowired
    private  TeacherService teacherService;

    @Test
    void demo(){
        teacherService.getAllTeachers(0,10)
                .forEach(System.out::println);
    }



}
