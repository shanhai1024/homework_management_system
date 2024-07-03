package top.shanhai1024.service.impl;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import top.shanhai1024.entity.DTO.TeacherDTO;
import top.shanhai1024.entity.PO.Teacher;
import top.shanhai1024.repository.TeacherRepository;
import top.shanhai1024.service.TeacherService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    @Override
    public List<TeacherDTO> getAllTeachers(int page, int size) {
        val all = teacherRepository.findAll(PageRequest.of(page, size));
        val collect = all.stream()
                .map(teacher -> {
                    return TeacherDTO.builder()
                            .name(teacher.getName())
                            .contactInfo(teacher.getContactInfo())
                            .specialization(teacher.getSpecialization())
                            .id(teacher.getId()).build();
                }).collect(Collectors.toList());
        return collect;

    }

    @Override
    public Teacher getTeacherById(Integer id) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        return optionalTeacher.orElse(null);
    }

    @Override
    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher updateTeacher(Integer id, Teacher teacher) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        if (optionalTeacher.isPresent()) {
            Teacher existingTeacher = optionalTeacher.get();
            existingTeacher.setName(teacher.getName());
            existingTeacher.setContactInfo(teacher.getContactInfo());
            existingTeacher.setSpecialization(teacher.getSpecialization());
            existingTeacher.setDepartment(teacher.getDepartment());
            // Update other fields as needed
            return teacherRepository.save(existingTeacher);
        }
        return null;
    }

    @Override
    public void deleteTeacher(Integer id) {
        teacherRepository.deleteById(id);
    }
}
