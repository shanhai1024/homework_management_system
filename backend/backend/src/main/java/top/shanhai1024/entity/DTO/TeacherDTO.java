package top.shanhai1024.entity.DTO;

import lombok.Builder;
import lombok.Data;
import top.shanhai1024.entity.PO.Department;

@Data
@Builder
public class TeacherDTO {

    private Integer id;

    private String name;

    private String contactInfo;

    private String specialization;
}
