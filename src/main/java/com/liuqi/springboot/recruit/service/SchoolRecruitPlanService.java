package com.liuqi.springboot.recruit.service;

import com.liuqi.springboot.entity.SchoolRecruitNotice;
import com.liuqi.springboot.recruit.basevo.PlanVo;
import com.liuqi.springboot.recruit.dao.SchoolRecruitPlanDao;
import com.liuqi.springboot.recruit.dao.SchoolRecruitPlanNoticeDao;
import com.liuqi.springboot.recruit.entity.SchoolRecruitPlan;
import com.liuqi.springboot.recruit.entity.SchoolRecruitPlanNotice;
import com.liuqi.springboot.recruit.vo.PagePlanVo;
import com.liuqi.springboot.recruit.vo.RecruitPlanVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SchoolRecruitPlanService {

    @Autowired
    private SchoolRecruitPlanDao schoolRecruitPlanDao;

    @Autowired
    private SchoolRecruitPlanNoticeDao schoolRecruitPlanNoticeDao;

    /**
     * 查出所有的招生计划
     * 该方法没有限制学校
     * @param qPageRequest
     * @return
     */
    public PagePlanVo findAll(Pageable qPageRequest){
        Page<PlanVo> planVos = schoolRecruitPlanDao.findAllPlanVo(qPageRequest);
        return new PagePlanVo(planVos.getContent(),planVos.getNumberOfElements(),qPageRequest.getPageNumber(),qPageRequest.getPageSize());
    }

    /**
     * 保存招生计划
     * @param recruitPlanVo
     * @throws Exception
     */
    @Transactional
    public void savePlan(RecruitPlanVo recruitPlanVo) throws Exception{
        SchoolRecruitPlan schoolRecruitPlan = recruitPlanVo.planVOToPlanDO(recruitPlanVo);
        if(schoolRecruitPlan.getId() == null) {
            //新增
            schoolRecruitPlanDao.save(schoolRecruitPlan);

            List<SchoolRecruitPlanNotice> notices = recruitPlanVo.noticeVOsToNoticeDOs(recruitPlanVo);
            if(notices!=null && notices.size()>0) {
                for (SchoolRecruitPlanNotice notice : notices) {
                    notice.setPlanid(schoolRecruitPlan.getId());
                    notice.setOperateuserid(11l);
                    schoolRecruitPlanNoticeDao.save(notice);
                }
            }

        } else {

        }

    }
}
