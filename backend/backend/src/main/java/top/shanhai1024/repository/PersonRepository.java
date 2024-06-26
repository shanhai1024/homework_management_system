package top.shanhai1024.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.shanhai1024.entity.PO.Person;

public interface PersonRepository  extends JpaRepository<Person,Long> {
}
