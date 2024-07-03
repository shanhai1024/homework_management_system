package top.shanhai1024.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import top.shanhai1024.entity.PO.Person;
import top.shanhai1024.entity.PO.RoleStatistics;

import java.util.List;

public interface PersonRepository  extends JpaRepository<Person,Long> {

    @Query(value = "SELECT " +
            "COUNT(*) AS total, " +
            "SUM(CASE WHEN role = '学生' THEN 1 ELSE 0 END) AS students, " +
            "SUM(CASE WHEN role = '教师' THEN 1 ELSE 0 END) AS teachers, " +
            "SUM(CASE WHEN role NOT IN ('学生', '教师') THEN 1 ELSE 0 END) AS others " +
            "FROM persons",
            nativeQuery = true)
    List<Object[]> getRawRoleStatistics();

    default RoleStatistics getRoleStatistics() {
        List<Object[]> results = getRawRoleStatistics();
        Object[] result = results.get(0);
        return new RoleStatistics(
                ((Number) result[0]).longValue(),
                ((Number) result[1]).longValue(),
                ((Number) result[2]).longValue(),
                ((Number) result[3]).longValue()
        );
    }
}
