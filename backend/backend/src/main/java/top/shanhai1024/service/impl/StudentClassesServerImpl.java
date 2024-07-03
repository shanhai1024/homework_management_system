package top.shanhai1024.service.impl;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import top.shanhai1024.entity.DTO.StudentClassDTO;
import top.shanhai1024.entity.PO.Teacher;
import top.shanhai1024.repository.StudentClassRepository;
import top.shanhai1024.repository.StudentRepository;
import top.shanhai1024.service.StudentCLassesService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentClassesServerImpl implements StudentCLassesService {
    private final StudentClassRepository studentClassRepository;
    @Override
    public List<StudentClassDTO> getAllStudentClass(int page, int size) {
        val all = studentClassRepository.findAll(PageRequest.of(page, size));
        val collect = all.stream().map(studentClass -> {
                    return StudentClassDTO.builder()
                    .className(studentClass.getClassName())
                    .id(studentClass.getId())
                    .counselor(studentClass.getTeacher().getName())
                    .build();
                })
                .collect(Collectors.toList());

        return collect;
    }

    @Override
    public Teacher getStudentClassById(Integer id) {
        return null;
    }

    @Override
    public Teacher createStudentClass(Teacher teacher) {
        return null;
    }

    @Override
    public Teacher updateStudentClass(Integer id, Teacher teacher) {
        return null;
    }

    @Override
    public void deleteStudentClass(Integer id) {

    }
}
