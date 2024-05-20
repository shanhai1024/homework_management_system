package top.shanhai1024.repository;

import top.shanhai1024.entity.PO.Homework;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author null
 * 作业Repository
 */
public interface HomeworkRepository  extends JpaRepository<Homework,Integer> {
}
