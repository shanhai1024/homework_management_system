package com.example.entity.PO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;


/**
 * @author null
 * 作业任务发布实体类
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mandates")
public class Mandates implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "upload_id")
    private Integer uploadId;

    private String title;

    @Column(name = "cut_off_time")
    private Date cutOffTime;

    // Getters and Setters
}