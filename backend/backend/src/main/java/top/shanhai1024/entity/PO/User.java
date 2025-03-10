package top.shanhai1024.entity.PO;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @author null
 * 用户实体类
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user") //
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    /**
     * 用户名
     */
    @Column(unique = true,name = "user_name")
    private String userName;
    /**
     * 昵称
     */
    @Column(unique = true ,name = "nick_name")
    private String nickName;
    /**
     * 密码
     */
    private String password;
    /**
     * 账号状态（0正常 1停用）
     */
    private String status="0";
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    @Column(name = "phone_number")
    private String phoneNumber;
    /**
     * 用户性别（0男，1女，2未知）
     */
    private String sex="2";
    /**
     * 头像
     */
    private String avatar;
    /**
     * 用户类型（0管理员，1普通用户）
     */
    @Column(name = "user_type")
    private String userType ="1";
    /**
     * 创建人的用户id
     */
    @Column(name = "create_by")
    private Long createBy;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
    /**
     * 更新人
     */
    @Column(name = "update_by")
    private Long updateBy;
    /**
     * 更新时间
     */
    @UpdateTimestamp
    @Column(name = "update_time")
    private Date updateTime;
    /**
     * 删除标志（0代表未删除，1代表已删除）
     */
    @Column(name = "del_flag")
    private Integer delFlag=0;
}
