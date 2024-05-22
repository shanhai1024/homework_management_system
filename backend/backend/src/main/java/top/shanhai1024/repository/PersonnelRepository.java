package top.shanhai1024.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import top.shanhai1024.entity.PO.Personnel;

import java.util.List;

/**
 * @author null
 */
public interface PersonnelRepository extends JpaRepository<Integer, Personnel> {



    @Query("SELECT Category .name,COUNT(Personnel.name) FROM Personnel JOIN Category ON Category.id=Personnel.categoriesId GROUP BY Category.name")
    public List<Object[]> getPersonnelStatisticsData();
}
