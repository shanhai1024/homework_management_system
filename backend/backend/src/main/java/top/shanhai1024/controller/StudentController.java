package top.shanhai1024.controller;

import cn.dev33.satoken.util.SaResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import top.shanhai1024.entity.DTO.StudentData;
import top.shanhai1024.service.StudentServer;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@AllArgsConstructor
public class StudentController {
    private final StudentServer studentServer;

    @GetMapping
    public SaResult getAllData(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        List<StudentData> allStudentData = studentServer.getAllStudentData(page, size);
        return SaResult.data(allStudentData);
    }

    @DeleteMapping("/{id}")
    public SaResult deleteStudent(@PathVariable Integer id) {
        studentServer.deleteStudent(id);
        return SaResult.ok("删除成功");
    }

    @PutMapping("/{id}")
    public SaResult updateStudent(@PathVariable Integer id, @RequestBody StudentData studentData) {
        studentServer.updateStudent(id, studentData);
        return SaResult.ok("更新成功");
    }

    @PostMapping
    public SaResult addStudent(@RequestBody StudentData studentData) {
        studentServer.addStudent(studentData);
        return SaResult.ok("添加成功");
    }
}
