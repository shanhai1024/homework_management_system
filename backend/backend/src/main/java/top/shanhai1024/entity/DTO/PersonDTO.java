package top.shanhai1024.entity.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDTO {
    private Long id;
    private String name;
    private String sex;
    private String phoneNumber;
    private String email;
    private String role;
    private String departmentName; // 如果需要部门信息，可以直接存储部门的ID
}
