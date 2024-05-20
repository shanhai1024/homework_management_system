package top.shanhai1024.service.impl;

import top.shanhai1024.entity.PO.Category;
import top.shanhai1024.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类别管理服务类。
 */
@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    /**
     * 从数据库中获取所有类别。
     *
     * @return 所有类别的列表。
     */
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    /**
     * 将类别保存到数据库中。
     *
     * @param category 要保存的类别。
     * @return 已保存的类别。
     */
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    /**
     * 根据ID从数据库中删除类别。
     *
     * @param id 要删除的类别的ID。
     */
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(Long.valueOf(id));
    }
}
