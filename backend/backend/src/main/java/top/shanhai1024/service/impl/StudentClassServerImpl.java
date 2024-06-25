package top.shanhai1024.service.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import top.shanhai1024.entity.PO.StudentClass;
import top.shanhai1024.repository.StudentClassRepository;
import top.shanhai1024.service.StudentClassServer;

@Service
@AllArgsConstructor

public class StudentClassServerImpl  implements StudentClassServer{
    private  final StudentClassRepository studentClassRepository;


    @Override
    public Page<StudentClass> findAll(Pageable pageable) {
       return studentClassRepository.findAll(pageable);
    }
}
