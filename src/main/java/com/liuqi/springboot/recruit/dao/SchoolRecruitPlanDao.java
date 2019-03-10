package com.liuqi.springboot.recruit.dao;

import com.liuqi.springboot.recruit.basevo.PlanVo;
import com.liuqi.springboot.recruit.entity.SchoolRecruitPlan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SchoolRecruitPlanDao extends JpaRepository<SchoolRecruitPlan,Long> {

    @Query(value ="select new com.liuqi.springboot.recruit.basevo.PlanVo(s.id,s.title,s.startdate,s.enddate) from SchoolRecruitPlan s")
    Page<PlanVo> findAllPlanVo(Pageable qPageRequest);

    SchoolRecruitPlan findById(long id);
}
