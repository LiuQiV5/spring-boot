package com.liuqi.springboot.dao;

import com.liuqi.springboot.entity.SchoolCourseScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolCourseScoreDao extends JpaRepository<SchoolCourseScore,Long> {
}
