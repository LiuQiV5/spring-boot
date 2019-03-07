package com.liuqi.springboot.recruit.dao;

import com.liuqi.springboot.recruit.entity.SchoolRecruitForm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchoolRecruitFormDao extends JpaRepository<SchoolRecruitForm,Long> {

    List<SchoolRecruitForm> findByInitid(long initid);
}
