package com.liuqi.springboot.recruit.dao;

import com.liuqi.springboot.recruit.basevo.UrlVo;
import com.liuqi.springboot.recruit.entity.SchoolRecruitUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SchoolRecruitUrlDao extends JpaRepository<SchoolRecruitUrl, Long> {

    @Query("select new com.liuqi.springboot.recruit.basevo.UrlVo(u.planid,u.url) from SchoolRecruitUrl u where u.planid = :planid")
    List<UrlVo> findUrlByPlanId(@Param("planid") Long planid);

    void deleteByPlanid(Long planid);
}
