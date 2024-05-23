package top.shanhai1024.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import top.shanhai1024.entity.PO.Personnel;

import java.util.List;

public interface PersonnelRepository extends JpaRepository<Personnel, Integer> {

    @Query("SELECT c.name, COUNT(p.name) FROM Personnel p JOIN p.category c GROUP BY c.name")
    List<Object[]> getPersonnelStatisticsData();
}
