package top.shanhai1024.repository;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;
import top.shanhai1024.entity.PO.PersonnelClass;

import java.util.List;

public interface PersonnelClassRepository extends JpaRepository<PersonnelClass, Integer> {

    @Query("SELECT new top.shanhai1024.entity.PO.PersonnelClass(pc.id, pc.name) FROM PersonnelClass pc")
    List<PersonnelClass> findAllPersonnelClasses();

    @Modifying
    @Transactional
    @Query("DELETE FROM PersonnelClass WHERE id = :id")
    int  deletePersonnelClassesById(@Param("id") @NotNull Integer id);

    @Transactional
    @Modifying
    @Query("update PersonnelClass p set p.id = ?1 where p.id is not null")
    int updateIdByIdNotNull(@NonNull Integer id);

    @Transactional
    @Modifying
    @Query("update PersonnelClass p set p.id = ?1, p.name = ?2 where p.id is not null and p.name is not null")
    int updateIdAndNameByIdNotNullAndNameNotNull(@NonNull Integer id, @NonNull String name);

    @Transactional
    @Modifying
    @Query(value = "UPDATE `personnel_managements`.`personnel_class` SET `class_name` = ?2 WHERE `id` = ?1",nativeQuery = true)
    int updatePersonnelClasses(Integer id ,String name);
}
