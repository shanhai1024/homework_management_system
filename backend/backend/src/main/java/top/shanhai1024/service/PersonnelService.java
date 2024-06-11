package top.shanhai1024.service;

import cn.dev33.satoken.util.SaResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import top.shanhai1024.entity.PO.Personnel;

import java.util.List;

/**
 * @author null
 * 用户服务
 */
public interface PersonnelService {
    List<Object[]> getPersonnelStatisticsData();
    void  deleteById(Long id);
    public Page<Object> getAllPersonnelData(Pageable pageable);
    void addPersonnel(Personnel personnel);
}
