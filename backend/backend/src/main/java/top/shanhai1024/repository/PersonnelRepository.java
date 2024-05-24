package top.shanhai1024.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import top.shanhai1024.entity.PO.Personnel;

import java.util.List;
@Repository
public interface PersonnelRepository extends JpaRepository<Personnel, Integer> {

    @Query("SELECT c.name, COUNT(p.name) FROM Personnel p JOIN p.category c GROUP BY c.name")
    List<Object[]> getPersonnelStatisticsData();
    void  deleteById(Long id);
    @Query("SELECT p.id,p.name,p.sex,p.email,p.phoneNumber,aClass .name,c.name FROM Personnel p JOIN Category c ON p.category.id=c.id JOIN aClass ON aClass .id=p.aClass.id")
    List<Object> getAllPersonnelData();
}
