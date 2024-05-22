package top.shanhai1024.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.shanhai1024.entity.PO.Category;
public interface CategoryRepository extends JpaRepository<Category, Long> {
}