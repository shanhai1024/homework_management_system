package top.shanhai1024.entity.PO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author null
 * 作业实体类
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "operation")

public class Homework implements Serializable {
    @Id
    private Integer id;


    @Column(name = "user_id")
    private Integer userId;


    @Column(name = "mandate_id")
    private Integer mandateId;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "path_name")
    private String pathName;

    private Integer statu;

    // Getters and Setters
}