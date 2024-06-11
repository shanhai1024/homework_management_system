package top.shanhai1024.service;

import cn.dev33.satoken.util.SaResult;
import top.shanhai1024.entity.PO.Personnel;

import java.util.List;

/**
 * @author null
 * 用户服务
 */
public interface PersonnelService {
    List<Object[]> getPersonnelStatisticsData();
    void  deleteById(Long id);
    List<Object> getAllData();
    void addPersonnel(Personnel personnel);
}
