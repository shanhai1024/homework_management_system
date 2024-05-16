package com.example.config;

import cn.dev33.satoken.stp.StpInterface;
import com.example.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author mycomputer
 */

// 自定义权限接口实现
@Component
@AllArgsConstructor

public class SaTokenPermissionConfig implements StpInterface {
  private final UserRepository userRepository;

  /**
   * 返回一个账号所拥有的权限码集合
   */
  @Override
  public List<String> getPermissionList(Object loginId, String loginType) {
    return userRepository.findPermsById((String) loginId);
  }

  /**
   * 返回一个账号所拥有的角色标识集合
   */

  @Override
  public List<String> getRoleList(Object loginId, String loginType) {
    return null;
  }
}
