package top.shanhai1024.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import top.shanhai1024.entity.PO.StudentClass;

import java.util.List;

public interface StudentClassServer {

    public Page<StudentClass> findAll(Pageable pageable);
}
