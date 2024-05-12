package com.example.repository;

import com.example.entity.PO.Homework;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author null
 * 作业Repository
 */
public interface HomeworkRepository  extends JpaRepository<Homework,Integer> {
}
