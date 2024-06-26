package top.shanhai1024.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import top.shanhai1024.entity.DTO.PersonDTO;
import top.shanhai1024.entity.PO.Person;
import top.shanhai1024.entity.PO.Personnel;
import top.shanhai1024.repository.PersonRepository;
import top.shanhai1024.service.PersonService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class PersonServerImpl implements PersonService {
    private final PersonRepository personRepository;

    @Override
    public Page<Person> findAll(Pageable pageable) {
        return personRepository.findAll(pageable);

    }

    @Override
    public Page<PersonDTO> getAllPersonnelData(Pageable pageable) {
        Page<Person> personsPage = findAll(pageable); // 调用 findAll 方法获取分页数据

        return personsPage.map(this::convertToDTO); // 使用 convertToDTO 方法映射为 Page<PersonDTO>
    }

    private PersonDTO convertToDTO(Person person) {
        PersonDTO dto = new PersonDTO();
        dto.setId(person.getId());
        dto.setName(person.getName());
        dto.setSex(person.getSex());
        dto.setPhoneNumber(person.getPhoneNumber());
        dto.setEmail(person.getEmail());
        dto.setRole(person.getRole());
        if (person.getDepartment() != null) {
            dto.setDepartmentName(person.getDepartment().getDepartmentName());
        }
        return dto;
    }


    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public void addPersonnel(Personnel personnel) {

    }

}

