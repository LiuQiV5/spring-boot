package com.liuqi.springboot.recruit.dao;

import com.liuqi.springboot.recruit.entity.SchoolRecruitInit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRecruitInitDao extends JpaRepository<SchoolRecruitInit,Long> {

    SchoolRecruitInit findBySchoolguid(String schoolguid);
}
