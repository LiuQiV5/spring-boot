package com.liuqi.springboot;

import com.liuqi.springboot.recruit.basevo.IntentVo;
import com.liuqi.springboot.recruit.basevo.NoticeVo;
import com.liuqi.springboot.recruit.vo.ConcreteFormVo;
import com.liuqi.springboot.recruit.vo.RecruitPlanVo;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.results.ResultMatchers;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class RecruitTest {

    private MockMvc mockMvc;
    //启用web上下文
    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() throws Exception {
        //建议使用这种
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void test1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/recruit/conf/plans/{pageno}/{pagesize}", "1", "2")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.data.totalCount").value(1));
    }

    @Test
    public void findInit() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/recruit/conf/find/init")
                .param("schoolguid", "1111")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.data.notices[0].visibility").value("ALL"));
    }

    @Test
    public void savePlan() throws Exception {
        String recuritplanvo = "{\n" +
                "    \"siteid\": \"25\",\n" +
                "    \"schoolguid\": \"1111\",\n" +
                "    \"guide\": \"豆腐干豆腐干\",\n" +
                "    \"description\": \"风格化规范化广泛\",\n" +
                "    \"note\": \"放过机会风格化风格化\",\n" +
                "    \"examination\": \"发规划局规划局规划\",\n" +
                "    \"schoolcode\": \"\",\n" +
                "    \"startDate\": \"2019-03-07\",\n" +
                "    \"endDate\": \"2019-04-07\",\n" +
                "    \"title\": \"南菁自主招生\",\n" +
                "    \"form\": [\n" +
                "        {\n" +
                "            \"id\": \"1\",\n" +
                "            \"alias\": \"2019自主招生表单\",\n" +
                "            \"modelpath\": \"sdfgd\",\n" +
                "            \"indexpath\": \"sdfg\",\n" +
                "            \"imgpath\": \"fghgf\",\n" +
                "            \"name\": \"梵蒂冈\",\n" +
                "            \"model\": \"法国和\",\n" +
                "            \"intent\": [\n" +
                "                {\n" +
                "                    \"id\": \"\",\n" +
                "                    \"planformid\": \"\",\n" +
                "                    \"comment\": \"理科班\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ],\n" +
                "    \"notice\": [\n" +
                "        {\n" +
                "            \"name\": \"贺信\",\n" +
                "            \"type\": \"法国和\",\n" +
                "            \"content\": \"法国和\",\n" +
                "            \"modelpath\": \"岁的法国\",\n" +
                "            \"visibility\": \"ALL\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"鼓励信\",\n" +
                "            \"type\": \"法国和\",\n" +
                "            \"content\": \"绕太阳\",\n" +
                "            \"modelpath\": \"的风格\",\n" +
                "            \"visibility\": \"PASS\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/recruit/conf/save/plan")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(recuritplanvo)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print()
                );
    }

    @Test
    public void findPlanById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/recruit/conf/find/plan/{id}", "6")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    public void findFormBySchoolguid() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/recruit/conf/find/forms")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    public void saveEditPlan() throws Exception {
        String json = "{\n" +
                "    \"planId\": \"6\",\n" +
                "    \"guide\": \"英雄联盟\",\n" +
                "    \"description\": \"召唤师峡谷\",\n" +
                "    \"startDate\": \"2019-03-10\",\n" +
                "    \"endDate\": \"2019-04-07\",\n" +
                "    \"title\": \"江阴一中自主招生\",\n" +
                "    \"form\": [\n" +
                "        {\n" +
                "            \"id\": \"1\",\n" +
                "            \"alias\": \"2019江阴一中自主招生一招表单\",\n" +
                "            \"indexpath\": \"sdfg\",\n" +
                "            \"intent\": [\n" +
                "                {\n" +
                "                    \"comment\": \"理科班\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"comment\": \"文科班\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"2\",\n" +
                "            \"alias\": \"2019江阴一中自主招生二招表单\",\n" +
                "            \"indexpath\": \"法国和\",\n" +
                "            \"intent\": [\n" +
                "                {\n" +
                "                    \"comment\": \"艺术班\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/recruit/conf/save/plan")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print()
                );
    }
}
