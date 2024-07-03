package top.shanhai1024.entity.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StudentClassDTO {
    private Integer id;
    private String className;
    private String counselor;
}
