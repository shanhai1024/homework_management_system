package top.shanhai1024.controller;

import cn.dev33.satoken.util.SaResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import top.shanhai1024.entity.PO.Teacher;
import top.shanhai1024.service.TeacherService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teachers")
@AllArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping
    public SaResult getAllTeachers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        List<Teacher> allTeachers = teacherService.getAllTeachers(page, size);
        return SaResult.data(allTeachers);
    }

    @GetMapping("/{id}")
    public SaResult getTeacherById(@PathVariable Integer id) {
        Teacher teacher = teacherService.getTeacherById(id);
        if (teacher != null) {
            return SaResult.data(teacher);
        } else {
            return SaResult.error("没有找到这个老师");
        }
    }

    @PostMapping
    public SaResult createTeacher(@RequestBody Teacher teacher) {
        Teacher createdTeacher = teacherService.createTeacher(teacher);
        return SaResult.data(createdTeacher);
    }

    @PutMapping("/{id}")
    public SaResult updateTeacher(@PathVariable Integer id, @RequestBody Teacher teacher) {
        Teacher updatedTeacher = teacherService.updateTeacher(id, teacher);
        if (updatedTeacher != null) {
            return SaResult.data(updatedTeacher);
        } else {
            return SaResult.error("老师未找到");
        }
    }

    @DeleteMapping("/{id}")
    public SaResult deleteTeacher(@PathVariable Integer id) {
        teacherService.deleteTeacher(id);
        return SaResult.ok("删除成功");
    }
}
