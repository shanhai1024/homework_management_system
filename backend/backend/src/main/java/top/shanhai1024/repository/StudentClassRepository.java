package top.shanhai1024.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import top.shanhai1024.entity.PO.StudentClass;

@Repository
public interface StudentClassRepository extends JpaRepository<StudentClass,Integer> {

}
