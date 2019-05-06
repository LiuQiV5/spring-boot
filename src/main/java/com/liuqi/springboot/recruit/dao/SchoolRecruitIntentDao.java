package com.liuqi.springboot.recruit.dao;

import com.liuqi.springboot.recruit.basevo.IntentVo;
import com.liuqi.springboot.recruit.entity.SchoolRecruitIntent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SchoolRecruitIntentDao extends JpaRepository<SchoolRecruitIntent,Long> {

    @Query("select new com.liuqi.springboot.recruit.basevo.IntentVo(ri.id,ri.planFormid,ri.comment) " +
            "from SchoolRecruitIntent ri inner join SchoolRecruitPlanForm pf on pf.id = ri.planFormid " +
            "where pf.planid = :planid")
    List<IntentVo> findIntentByPlanId(@Param("planid") Long planid);

    void deleteByPlanFormid(Long planFormid);
}
