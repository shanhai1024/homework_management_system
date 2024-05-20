package top.shanhai1024.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import top.shanhai1024.entity.PO.YearlyData;

import java.util.List;

public interface YearlyDataRepository extends JpaRepository<YearlyData, Long> {

    @Query("SELECT y FROM YearlyData y JOIN FETCH y.category ORDER BY y.year")
    List<YearlyData> findAllByOrderByYearAsc();
}
