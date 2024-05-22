package top.shanhai1024.entity.PO;

import jakarta.persistence.*;
import lombok.Data;



/**
 * @author null
 * 人员实体类
 */
@Entity
@Data
@Table(name = "personnel")
public class Personnel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "categories_id")
  private Integer categoriesId;

  @Column(name = "name")
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
  @JoinColumn(name = "category_id")
  private Category category;


}