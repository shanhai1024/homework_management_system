package top.shanhai1024.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import top.shanhai1024.entity.PO.Personnel;

import java.util.List;

@Repository
public interface PersonnelRepository extends JpaRepository<Personnel, Long> {

    @Query("SELECT c.name, COUNT(p.name) FROM Personnel p JOIN p.category c GROUP BY c.name")
    List<Object[]> getPersonnelStatisticsData();

    void deleteById(@NotNull Long id);

    @Query("SELECT p.id, p.name, p.sex, p.email, p.phoneNumber, a.name, c.name " +
            "FROM Personnel p " +
            "JOIN p.category c " +
            "JOIN p.personnelClass a")
    Page<Object> getAllPersonnelData(Pageable pageable);
}
