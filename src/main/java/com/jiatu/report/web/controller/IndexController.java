package com.jiatu.report.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lenovo on 2017/11/29.
 */
@Controller
//@RequestMapping("index")
public class IndexController {

    static Logger log = LoggerFactory.getLogger(IndexController.class);
    @RequestMapping(method = RequestMethod.GET,path = "/welcome")
    @ResponseBody
    public String welcome(HttpServletRequest request, HttpServletResponse response) {
        return "hello ";
    }

    @RequestMapping(method = RequestMethod.GET,path = "/login")
    public String login(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="name", required=false, defaultValue="dengbp") String name,Model model) {
        log.info("call login method...");
        model.addAttribute("name", name);
        return "login";
    }
}
