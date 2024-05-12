package com.example.entity.PO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "menu")
public class Menu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String component;

    @Column(name = "create_by")
    private Long createBy;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "del_flag")
    private Integer delFlag;

    private String icon;

    @Column(name = "menu_name")
    private String menuName;

    private String path;

    private String perms;

    private String remark;

    private Character status;

    @Column(name = "update_by")
    private Long updateBy;

    @Column(name = "update_time")
    private Date updateTime;

    private Character visible;

    // Getters and Setters
}