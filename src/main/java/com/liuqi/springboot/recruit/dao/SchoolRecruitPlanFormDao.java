package com.liuqi.springboot.recruit.dao;

import com.liuqi.springboot.recruit.entity.SchoolRecruitPlanForm;
import com.liuqi.springboot.recruit.vo.ConcreteFormVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SchoolRecruitPlanFormDao extends JpaRepository<SchoolRecruitPlanForm,Long> {

    @Query("select new com.liuqi.springboot.recruit.vo.ConcreteFormVo(pf.id,pf.formid,srf.modelpath,srf.indexpath,srf.imgpath,srf.name,srf.model,pf.alias) " +
            "from SchoolRecruitPlanForm pf left join SchoolRecruitForm srf on pf.formid = srf.id " +
            "where pf.planid = :planid")
    List<ConcreteFormVo> findAllPlanFormByPlanId(@Param("planid") Long planid);

    void deleteByPlanid(Long planid);

    List<SchoolRecruitPlanForm> findAllByPlanid(Long planid);

}
