package top.shanhai1024.service;

import top.shanhai1024.entity.PO.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeachers(int page, int size);
    Teacher getTeacherById(Integer id);
    Teacher createTeacher(Teacher teacher);
    Teacher updateTeacher(Integer id, Teacher teacher);
    void deleteTeacher(Integer id);
}
