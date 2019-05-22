package priv.starfish.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import priv.starfish.entity.Role;

/**
 * @description: 角色数据Dao
 * @date: 2019/5/22 16:51
 */
public interface RoleRepository extends CrudRepository<Role, Long> {
    List<Role> findRolesByUserId(Long userId);
}
