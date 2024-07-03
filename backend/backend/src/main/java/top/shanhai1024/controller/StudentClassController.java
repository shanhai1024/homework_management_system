package top.shanhai1024.controller;

import cn.dev33.satoken.util.SaResult;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.shanhai1024.entity.DTO.StudentClassDTO;
import top.shanhai1024.entity.PO.Teacher;
import top.shanhai1024.service.StudentCLassesService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/studentClass")
@AllArgsConstructor
public class StudentClassController {
    private final StudentCLassesService studentClassService;


    @GetMapping()
    SaResult studentClassDTOS (@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        return SaResult.data(studentClassService.getAllStudentClass(page, size));
    }

    @DeleteMapping("/{id}")
    SaResult deleteById(@PathVariable  Integer id){
        studentClassService.deleteStudentClass(id);
        return SaResult.ok("删除班级成功");
    }

    @PostMapping
    SaResult createStudentClass(@RequestBody Teacher teacher){
        studentClassService.createStudentClass(teacher);
        return SaResult.ok("添加班级成功");

    }

    @PutMapping("/{id}")
    public SaResult updateStudentClass(@PathVariable Integer id, @RequestBody  Teacher teacher){
        studentClassService.updateStudentClass(id,teacher);
        return SaResult.ok("更新班级数据成功");
    }

}
