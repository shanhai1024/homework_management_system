package top.shanhai1024.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.shanhai1024.entity.PO.Personnel;
import top.shanhai1024.entity.PO.PersonnelClass;

import top.shanhai1024.repository.PersonnelClassRepository;
import top.shanhai1024.service.PersonnelClassServer;
import java.util.List;


@Service
@AllArgsConstructor
public class PersonnelClassServerImpl implements PersonnelClassServer {
    private final PersonnelClassRepository personnelClassRepository;

    @Override
    public List<PersonnelClass> getAllClass() {
        return personnelClassRepository.findAllPersonnelClasses();
    }

    @Override
    public int deletePersonnelClassesById(Integer id) {
        return personnelClassRepository.deletePersonnelClassesById(id);
    }

//    @Override
//    public void updatePersonnelClasses(PersonnelClass personnelClass) {
//
//        personnelClassRepository.save(personnelClass);
//    }
@Override
@Transactional
public void updatePersonnelClasses(PersonnelClass personnelClass) {
    personnelClassRepository.updatePersonnelClasses(personnelClass.getId(),personnelClass.getName());
}

    @Override
    public void addPersonnelClasses(PersonnelClass personnelClass) {
        personnelClassRepository.save(personnelClass);
    }


}
