package top.shanhai1024.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import top.shanhai1024.entity.PO.Student;

import java.util.List;

public interface StudentRepository  extends JpaRepository<Student, Integer> {
    @Query(value = "SELECT students.id,students.age,students.contact_info,students.gender,student_classes.class_name,teachers.`name` FROM students JOIN student_classes ON students.class_id=student_classes.id JOIN teachers ON student_classes.teacher_id=teachers.id",nativeQuery = true)
    List<Student> getAllStudentData();

    Page<Student> findAll(Pageable pageable);
}
