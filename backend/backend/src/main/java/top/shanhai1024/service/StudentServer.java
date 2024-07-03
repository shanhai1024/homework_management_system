package top.shanhai1024.service;

import top.shanhai1024.entity.DTO.StudentData;

import java.util.List;

public interface StudentServer {
     List<StudentData> getAllStudentData(int page, int size);
     void deleteStudent(Integer id);
     void updateStudent(Integer id, StudentData studentData);
     void addStudent(StudentData studentData);
}
