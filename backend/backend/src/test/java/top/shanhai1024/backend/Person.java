package top.shanhai1024.backend;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import top.shanhai1024.repository.PersonRepository;
import top.shanhai1024.service.PersonService;

@SpringBootTest

public class Person {
    @Autowired
    private PersonService personRepository;


    @Test
    void getALl(){
        val all = personRepository.findAll( PageRequest.of(1, 10));
        all.forEach(System.out::println);
    }
}
