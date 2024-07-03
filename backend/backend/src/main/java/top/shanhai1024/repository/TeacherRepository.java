package top.shanhai1024.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.shanhai1024.entity.PO.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
