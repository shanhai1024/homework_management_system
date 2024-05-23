package top.shanhai1024.controller;


import cn.dev33.satoken.annotation.SaIgnore;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.shanhai1024.service.PersonnelService;

import java.util.List;

/**
 * @author null
 */
@RestController
@AllArgsConstructor
@SaIgnore
@RequestMapping("/api/v1")
public class PersonnelController {
    private  final PersonnelService personnelService;
    /*
    获取人员统计数据
     */
    @GetMapping("getPersonnelStatisticsData")
    public List getData(){
       return personnelService.getPersonnelStatisticsData();
    }
}
