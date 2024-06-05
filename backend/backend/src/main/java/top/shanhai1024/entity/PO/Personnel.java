package top.shanhai1024.entity.PO;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

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

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "class_id", insertable = false, updatable = false) // 注意这里要与 classId 对应
  @ToString.Exclude
  private PersonnelClass personnelClass;

}

