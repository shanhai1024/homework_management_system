package top.shanhai1024.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import top.shanhai1024.entity.PO.Teacher;
import top.shanhai1024.repository.TeacherRepository;
import top.shanhai1024.service.TeacherService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    @Override
    public List<Teacher> getAllTeachers(int page, int size) {
        return teacherRepository.findAll(PageRequest.of(page, size)).getContent();
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
