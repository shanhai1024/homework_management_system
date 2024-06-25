package top.shanhai1024.entity.PO;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import top.shanhai1024.entity.PO.Category;
import top.shanhai1024.entity.PO.PersonnelClass;
import top.shanhai1024.entity.PO.StudentClass;

@Entity
@Data
@Table(name = "personnel")
public class Personnel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "sex")
  private String sex;

  @Column(name = "phone_number")
  private Long phoneNumber;

  @Column(name = "email")
  private String email;

  @Column(name = "class_id")
  private Integer classId;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "categories_id")
  private Category category;

  // 映射到 personnel 表中的 student_class_id 字段
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "student_class_id")  // 修正此处的 JoinColumn 映射
  private StudentClass studentClass;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "class_id", insertable = false, updatable = false)
  @ToString.Exclude
  private PersonnelClass personnelClass;

}
