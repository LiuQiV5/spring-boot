package com.liuqi.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldControler {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello World";
    }

    @RequestMapping("/exception")
    public String exception()throws Exception{
        throw new Exception("测试异常");
    }

    @RequestMapping("/index")
    public String index(ModelMap map){
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "1111111111");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }
}
