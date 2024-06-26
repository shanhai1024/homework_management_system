package top.shanhai1024.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.util.SaResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.shanhai1024.entity.PO.PersonnelClass;
import top.shanhai1024.service.PersonnelClassService;

import java.util.List;

@RestController
@AllArgsConstructor
@Validated
@Slf4j
@SaIgnore
@RequestMapping("/api/v1/personnelClass")
public class PersonnelClassController {
    private final PersonnelClassService personnelClassService;
    @GetMapping
    SaResult getAllClass(){
        return SaResult.data( personnelClassService.getAllClass());
    }


    @DeleteMapping("/{id}")
    public SaResult deleteClass(@PathVariable Integer id) {
        personnelClassService.deletePersonnelClassesById(id);
        return SaResult.ok();
    }
    @PostMapping()
    SaResult addPersonnelClasses(@RequestBody PersonnelClass personnelClass){
        val personnelClass1 = personnelClassService.addPersonnelClasses(personnelClass);
        return SaResult.data(personnelClass1);
    }
    @PutMapping()
    SaResult updatePersonnelClasses(@RequestBody PersonnelClass personnelClass){
        personnelClassService.updatePersonnelClasses(personnelClass);
        return SaResult.ok();
    }



}
