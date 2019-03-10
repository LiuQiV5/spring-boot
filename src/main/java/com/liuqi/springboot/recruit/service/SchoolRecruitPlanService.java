package com.liuqi.springboot.recruit.service;

import com.liuqi.springboot.recruit.basevo.IntentVo;
import com.liuqi.springboot.recruit.basevo.PlanVo;
import com.liuqi.springboot.recruit.basevo.UrlVo;
import com.liuqi.springboot.recruit.dao.*;
import com.liuqi.springboot.recruit.entity.*;
import com.liuqi.springboot.recruit.vo.ConcreteFormVo;
import com.liuqi.springboot.recruit.vo.PagePlanVo;
import com.liuqi.springboot.recruit.vo.RecruitPlanVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SchoolRecruitPlanService {

    @Autowired
    private SchoolRecruitPlanDao schoolRecruitPlanDao;

    @Autowired
    private SchoolRecruitPlanNoticeDao schoolRecruitPlanNoticeDao;

    @Autowired
    private SchoolRecruitPlanFormDao schoolRecruitPlanFormDao;

    @Autowired
    private SchoolRecruitIntentDao schoolRecruitIntentDao;

    @Autowired
    private SchoolRecruitReviewTypeDao schoolRecruitReviewType;

    @Autowired
    private SchoolRecruitUrlDao schoolRecruitUrlDao;
    /**
     * 查出所有的招生计划
     * 该方法没有限制学校
     *
     * @param qPageRequest
     * @return
     */
    public PagePlanVo findAll(Pageable qPageRequest) {
        Page<PlanVo> planVos = schoolRecruitPlanDao.findAllPlanVo(qPageRequest);
        return new PagePlanVo(planVos.getContent(), planVos.getNumberOfElements(), qPageRequest.getPageNumber(), qPageRequest.getPageSize());
    }

    /**
     * 保存招生计划
     *
     * @param recruitPlanVo
     * @throws Exception
     */
    @Transactional
    public void savePlan(RecruitPlanVo recruitPlanVo) throws Exception {
        SchoolRecruitPlan schoolRecruitPlan = recruitPlanVo.planVOToPlanDO(recruitPlanVo);
        if (schoolRecruitPlan.getId() == null) {

            //保存招生计划,招生计划表单和报考意向
            savePlanConf(schoolRecruitPlan,recruitPlanVo.getForm());

            //新增招生计划通知
            List<SchoolRecruitPlanNotice> notices = recruitPlanVo.noticeVOsToNoticeDOs(recruitPlanVo);
            if (notices != null && notices.size() > 0) {
                for (SchoolRecruitPlanNotice notice : notices) {
                    notice.setPlanid(schoolRecruitPlan.getId());
                    notice.setOperateuserid(11l);
                    schoolRecruitPlanNoticeDao.save(notice);
                }
            }

            //新增时同时生成一个材料审核类型
            SchoolRecruitReviewType type = new SchoolRecruitReviewType();
            type.setName("材料审核");
            type.setPlanid(schoolRecruitPlan.getId());
            schoolRecruitReviewType.save(type);

        } else {
            //修改
            Optional<SchoolRecruitPlan> planOptional = schoolRecruitPlanDao.findById(schoolRecruitPlan.getId());
            SchoolRecruitPlan plan = planOptional.get();
            plan.setTitle(schoolRecruitPlan.getTitle());
            plan.setGuide(schoolRecruitPlan.getGuide());
            plan.setStartdate(schoolRecruitPlan.getStartdate());
            plan.setEnddate(schoolRecruitPlan.getEnddate());
            plan.setDescription(schoolRecruitPlan.getDescription());

            //删除招生计划表单模板、报考意向以及首页样式访问地址，重新生成
            schoolRecruitUrlDao.deleteByPlanid(plan.getId());
            List<SchoolRecruitPlanForm> planForms = schoolRecruitPlanFormDao.findAllByPlanid(plan.getId());
            if(planForms!=null && planForms.size()>0) {
                for (SchoolRecruitPlanForm planForm : planForms) {
                    schoolRecruitIntentDao.deleteByPlanFormid(planForm.getId());
                }
            }
            schoolRecruitPlanFormDao.deleteByPlanid(plan.getId());


            //保存招生计划表单和报考意向
            savePlanConf(plan,recruitPlanVo.getForm());

        }
    }

    /**
     * 根据id查出招生计划
     * @param id
     * @return
     */
    public RecruitPlanVo findPlanById(Long id){
        //组装RecruitPlanVo
        Optional<SchoolRecruitPlan> optionalPlan = schoolRecruitPlanDao.findById(id);
        SchoolRecruitPlan plan = optionalPlan.get();
        List<ConcreteFormVo> formVos = schoolRecruitPlanFormDao.findAllPlanFormByPlanId(plan.getId());
        List<IntentVo> intentVos = schoolRecruitIntentDao.findIntentByPlanId(plan.getId());

        Map<Long,ConcreteFormVo> formVoMap = new HashMap<>(6);
        if (formVos!=null && formVos.size()>0) {
            for (ConcreteFormVo formVo : formVos) {
                formVoMap.put(formVo.getPlanformid(),formVo);
            }
        }

        if (intentVos!=null && intentVos.size()>0) {
            for (IntentVo intentVo : intentVos) {
                ConcreteFormVo formVo = formVoMap.get(intentVo.getPlanformid());
                if (formVo!=null) {
                    formVo.add(intentVo);
                }
            }
        }

        List<UrlVo> urlVos = schoolRecruitUrlDao.findUrlByPlanId(plan.getId());

        RecruitPlanVo planVo = new RecruitPlanVo();
        planVo.setPlanId(plan.getId());
        planVo.setForm(formVos);
        planVo.setGuide(plan.getGuide());
        planVo.setDescription(plan.getDescription());
        planVo.setEndDate(plan.getEnddate());
        planVo.setStartDate(plan.getStartdate());
        planVo.setTitle(plan.getTitle());
        planVo.setCreateDate(plan.getCreatedate());
        planVo.setUrl(urlVos);
        return planVo;
    }

    /**
     * 保存招生计划配置
     * @param plan
     * @param formVoList
     */
    private void savePlanConf(SchoolRecruitPlan plan,List<ConcreteFormVo> formVoList){
        Map<String,Object> indexMap = new HashMap<>(6);
        schoolRecruitPlanDao.save(plan);
        if (formVoList != null && formVoList.size() > 0) {
            for (ConcreteFormVo concreteFormVo : formVoList) {
                //保存表单与报考意向
                SchoolRecruitPlanForm form = concreteFormVo.voToDo(concreteFormVo);
                form.setPlanid(plan.getId());
                schoolRecruitPlanFormDao.save(form);

                List<IntentVo> voList = concreteFormVo.getIntent();
                if (voList != null && voList.size() > 0) {
                    for (IntentVo intentVo : voList) {
                        SchoolRecruitIntent intent = new SchoolRecruitIntent();
                        intent.setComment(intentVo.getComment());
                        intent.setPlanFormid(form.getId());
                        schoolRecruitIntentDao.save(intent);
                    }
                }
                indexMap.put(concreteFormVo.getIndexpath(),concreteFormVo);
            }
            //自动生成首页的访问地址,判断要生成几个
            if(!indexMap.isEmpty()) {
                for (String indexPath : indexMap.keySet()) {
                    SchoolRecruitUrl url = new SchoolRecruitUrl();
                    url.setPlanid(plan.getId());
                    url.setUrl("http://prefix/"+indexPath);
                    schoolRecruitUrlDao.save(url);
                }
            }
        }
    }
}
