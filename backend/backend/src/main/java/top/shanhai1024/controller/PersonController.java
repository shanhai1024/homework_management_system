package top.shanhai1024.controller;

import cn.dev33.satoken.util.SaResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import top.shanhai1024.entity.PO.Personnel;

import top.shanhai1024.service.PersonService;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/api/v1")
public class PersonController {
    private final PersonService personService;

    /*
 获取人员数据
  */
    @GetMapping("getAllPersonnelData")
    public SaResult getAllPersonnelData(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return SaResult.data(personService.getAllPersonnelData(pageable));
    }


    //    根据id删除人员
    @DeleteMapping("deletePersonnel/{id}")
    public SaResult deleteById(@PathVariable  Long id){
        personService.deleteById(id);
        return SaResult.ok("删除成功");
    }

    @PostMapping("addPersonnel")
    public SaResult addPersonnel(@RequestBody Personnel personnel){
        personService.addPersonnel(personnel);
        return SaResult.ok();
    }


    @GetMapping("/roleCounts")
    public SaResult getRoleCounts() {
        return SaResult.data(personService.getRoleStatistics());
    }




}
