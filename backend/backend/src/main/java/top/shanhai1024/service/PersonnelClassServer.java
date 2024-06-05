package top.shanhai1024.service;

import top.shanhai1024.entity.PO.PersonnelClass;

import java.util.List;

public interface PersonnelClassServer {
    List<PersonnelClass> getAllClass();
    int deletePersonnelClassesById(Integer id);
    void updatePersonnelClasses(PersonnelClass personnelClass);
}
