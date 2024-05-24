package top.shanhai1024.service;

import java.util.List;

/**
 * @author null
 * 用户服务
 */
public interface PersonnelService {
    List<Object[]> getPersonnelStatisticsData();
    void  deleteById(Long id);
}
