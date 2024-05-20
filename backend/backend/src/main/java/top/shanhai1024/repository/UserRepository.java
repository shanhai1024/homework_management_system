package top.shanhai1024.repository;

import top.shanhai1024.entity.PO.User;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

/**
 * @author mycomputer
 */
@Repository

public interface UserRepository extends CrudRepository<User, Long> {


    //    查询登录用户
    Optional<User> findByUserName(String username);

    //查询用户权限
    @Query(value = "SELECT DISTINCT perms FROM menu  WHERE id IN  (SELECT menu_id FROM role_menu WHERE  role_id IN  (SELECT  role_id FROM user_role  WHERE  user_id =?))", nativeQuery = true)
    List<String> findPermsById(@Param("id") String id);


    //    查询登录用户
    @Query(value = "SELECT * FROM `user` WHERE phone_number=?", nativeQuery = true)
    Optional<User> findByPhoneNumber(String phoneNumber);

    //    返回一个账号所拥有的角色标识集合
    @Query(value = "SELECT role_key  FROM role WHERE role.id in (SELECT role_id FROM user_role WHERE user_id =?)", nativeQuery = true)
    Optional<User> getRoleList(@Param("id") String id );


}
