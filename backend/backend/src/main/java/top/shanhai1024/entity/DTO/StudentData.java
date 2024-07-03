package top.shanhai1024.entity.DTO;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentData {

    private String name;

    private int age;

    private String gender;
    private  String contactInfo;

    private String studentClass;
    private  String studentInstructor;

}
