package com.liuqi.springboot.recruit.controller;

import com.liuqi.springboot.recruit.basevo.FormVo;
import com.liuqi.springboot.recruit.service.SchoolRecruitFormService;
import com.liuqi.springboot.recruit.service.SchoolRecruitInitService;
import com.liuqi.springboot.recruit.service.SchoolRecruitPlanService;
import com.liuqi.springboot.recruit.util.ResponseEntity;
import com.liuqi.springboot.recruit.vo.PagePlanVo;
import com.liuqi.springboot.recruit.vo.RecruitPlanVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/recruit/conf")
public class SchoolRecruitPlanConfController {

    @Autowired
    private SchoolRecruitFormService schoolRecruitFormService;

    @Autowired
    private SchoolRecruitPlanService schoolRecruitPlanService;

    @Autowired
    private SchoolRecruitInitService schoolRecruitInitService;

    /**
     * 招生计划列表初始化接口
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/plans/{pageno}/{pagesize}")
    public ResponseEntity<PagePlanVo> getPlans(@PathVariable("pageno") Integer pageNo, @PathVariable("pagesize")Integer pageSize){

        QPageRequest qPageRequest = new QPageRequest(pageNo - 1, pageSize);

        return new ResponseEntity(schoolRecruitPlanService.findAll(qPageRequest),"获取成功",ResponseEntity.SUCCESS);
    }

    /**
     * 招生计划获取初始化内容接口
     * @param schoolguid
     * @return
     */
    @GetMapping("/find/init")
    public ResponseEntity findInit(@RequestParam("schoolguid") String schoolguid){

        return new ResponseEntity(schoolRecruitInitService.findBySchoolguid(schoolguid),"获取成功",ResponseEntity.SUCCESS);
    }

    /**
     * 招生计划新增接口
     * @param recruitPlanVo
     * @return
     */
    @PostMapping("/save/plan")
    public ResponseEntity savePlan(@RequestBody RecruitPlanVo recruitPlanVo){
        ResponseEntity responseEntity = new ResponseEntity();
        try {
            schoolRecruitPlanService.savePlan(recruitPlanVo);
            responseEntity.setCode(ResponseEntity.SUCCESS);
            responseEntity.setMsg("保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity.setCode(ResponseEntity.FAIL);
            responseEntity.setMsg("保存失败");
        }
        return responseEntity;
    }

    /**
     * 根据id查询招生计划详细内容
     * @param id
     * @return
     */
    @GetMapping("/find/plan/{id}")
    public ResponseEntity<RecruitPlanVo> findPlanById(@PathVariable("id") Long id){

        return new ResponseEntity<>(schoolRecruitPlanService.findPlanById(id),"查询成功",ResponseEntity.SUCCESS);
    }

    /**
     * 查询该校下的所有表单模板
     * @return
     */
    @GetMapping("/find/forms")
    public ResponseEntity<List<FormVo>> findForms(){
        return new ResponseEntity<>(schoolRecruitFormService.findFormBySchoolguid("1111"),"查询成功",ResponseEntity.SUCCESS);
    }
}
