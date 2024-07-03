package top.shanhai1024.service;

import top.shanhai1024.entity.DTO.StudentClassDTO;
import top.shanhai1024.entity.PO.Teacher;

import java.util.List;

public interface StudentCLassesService {

    List<StudentClassDTO> getAllStudentClass(int page, int size);
    Teacher getStudentClassById(Integer id);
    Teacher createStudentClass(Teacher teacher);
    Teacher updateStudentClass(Integer id, Teacher teacher);
    void deleteStudentClass(Integer id);
}
