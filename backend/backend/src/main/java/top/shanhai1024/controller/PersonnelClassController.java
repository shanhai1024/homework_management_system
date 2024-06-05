package top.shanhai1024.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.util.SaResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.shanhai1024.entity.PO.PersonnelClass;
import top.shanhai1024.service.PersonnelClassServer;

import java.util.List;

@RestController
@AllArgsConstructor
@Validated
@Slf4j
@SaIgnore
@RequestMapping("/api/v1/personnelClass")
public class PersonnelClassController {
    private final PersonnelClassServer personnelClassServer;
    @GetMapping
    SaResult getAllClass(){
        return SaResult.data( personnelClassServer.getAllClass());
    }


    @DeleteMapping("/{id}")
    public SaResult deleteClass(@PathVariable Integer id) {
        personnelClassServer.deletePersonnelClassesById(id);
        return SaResult.ok();
    }
    @PutMapping()
    SaResult updatePersonnelClasses(@RequestBody PersonnelClass personnelClass){
        personnelClassServer.updatePersonnelClasses(personnelClass);
        return SaResult.ok();
    }



}
