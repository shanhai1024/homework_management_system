package top.shanhai1024.service.impl;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import top.shanhai1024.entity.DTO.StudentData;
import top.shanhai1024.entity.PO.Student;
import top.shanhai1024.repository.StudentRepository;
import top.shanhai1024.service.StudentServer;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentServer {
    private final StudentRepository studentRepository;

    @Override
    public List<StudentData> getAllStudentData(int page, int size) {
        val pageable = PageRequest.of(page, size);
        val studentPage = studentRepository.findAll(pageable);
        return studentPage.stream().map(student -> StudentData.builder()
                        .name(student.getName())
                        .age(student.getAge())
                        .gender(student.getGender())
                        .contactInfo(student.getContactInfo())
                        .studentClass(student.getStudentClass().getClassName())
                        .studentInstructor(student.getStudentClass().getTeacher().getName())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void updateStudent(Integer id, StudentData studentData) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setName(studentData.getName());
            student.setAge(studentData.getAge());
            student.setGender(studentData.getGender());
            student.setContactInfo(studentData.getContactInfo());
            // 这里假设有方法设置studentClass和studentInstructor
            // student.setStudentClass(...);
            // student.setStudentInstructor(...);
            studentRepository.save(student);
        }
    }

    @Override
    public void addStudent(StudentData studentData) {
        Student student = new Student();
        student.setName(studentData.getName());
        student.setAge(studentData.getAge());
        student.setGender(studentData.getGender());
        student.setContactInfo(studentData.getContactInfo());
        studentRepository.save(student);
    }
}
