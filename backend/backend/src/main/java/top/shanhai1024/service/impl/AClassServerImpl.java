package top.shanhai1024.service.impl;

import cn.dev33.satoken.util.SaResult;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import top.shanhai1024.repository.AClassRepository;

@Service
@AllArgsConstructor
public class AClassServerImpl {
    private  final AClassRepository aClassRepository;
    public SaResult getAllClass(){
        val aClass = aClassRepository.getClass();
        return SaResult.data(getAllClass());
    }

}
