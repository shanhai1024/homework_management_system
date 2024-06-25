package top.shanhai1024.entity.PO;

import jakarta.persistence.*;
        import lombok.Data;

import java.io.Serializable;

/**
 * (StudentClass)实体类
 *
 * @since 2024-06-24Ò
 */
@Entity
@Data
@Table(name = "student_class")
public class StudentClass implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "student_class_name", nullable = false)
    private String studentClassName;

    @Column(name = "instructor_id", nullable = false)
    private Integer instructorId;

    // Getters and setters
}
