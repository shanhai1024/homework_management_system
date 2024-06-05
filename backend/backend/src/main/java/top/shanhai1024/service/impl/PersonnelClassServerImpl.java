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
    PersonnelClass existingClass = personnelClassRepository.findById(personnelClass.getId())
            .orElseThrow(() -> new EntityNotFoundException("PersonnelClass not found"));

    // 初始化集合
    existingClass.getPersonnel().size();

    // 清空现有的 personnel 集合
    existingClass.getPersonnel().clear();

//    // 添加新的 personnel 元素
//    existingClass.getPersonnel().addAll(personnelClass.getPersonnel());
//
//    // 设置双向关系 (如果需要)
//    for (Personnel personnel : existingClass.getPersonnel()) {
//        personnel.setPersonnelClass(existingClass);
//    }

    // 保存更新后的实体
    personnelClassRepository.save(existingClass);
}


}
