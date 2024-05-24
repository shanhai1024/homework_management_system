package top.shanhai1024.controller;


import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.util.SaResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
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


//    根据id删除人员
    @DeleteMapping("deletePersonnel/{id}")
    public SaResult deleteById(@PathVariable  Long id){
        personnelService.deleteById(id);
        return SaResult.ok("删除成功");
    }
}
