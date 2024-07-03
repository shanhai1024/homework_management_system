package top.shanhai1024.service;

import org.springframework.data.domain.Page;
import top.shanhai1024.entity.PO.StudentClass;
import top.shanhai1024.entity.PO.Teacher;

import java.util.List;

public interface StudentCLassesService {

    List<StudentClass> getAllTeachers(int page, int size);
    Teacher getStudentClassById(Integer id);
    Teacher createStudentClass(Teacher teacher);
    Teacher updateStudentClass(Integer id, Teacher teacher);
    void deleteStudentClass(Integer id);
}
