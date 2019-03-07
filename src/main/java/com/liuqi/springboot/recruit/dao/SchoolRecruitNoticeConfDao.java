package com.liuqi.springboot.recruit.dao;

import com.liuqi.springboot.recruit.entity.SchoolRecruitNoticeConf;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchoolRecruitNoticeConfDao extends JpaRepository<SchoolRecruitNoticeConf,Long> {

    List<SchoolRecruitNoticeConf> findByInitid(long initid);
}
