package top.shanhai1024.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import top.shanhai1024.entity.DTO.PersonDTO;
import top.shanhai1024.entity.PO.Person;
import top.shanhai1024.entity.PO.Personnel;

public interface PersonService {
 public Page<Person> findAll(Pageable pageable);
 public Page<PersonDTO> getAllPersonnelData(Pageable pageable);
 void deleteById(Long id);

 void addPersonnel(Personnel personnel);

}
