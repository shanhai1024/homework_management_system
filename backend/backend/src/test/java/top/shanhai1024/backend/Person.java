package top.shanhai1024.backend;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.shanhai1024.repository.PersonRepository;

@SpringBootTest
public class Person {
    @Autowired
    private   PersonRepository personRepository;


    @Test
    void getALl(){
        val all = personRepository.findAll();
        all.forEach(System.out::println);
    }
}
