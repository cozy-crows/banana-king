package com.example.bananaking.web.controller;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by jerry on 2018/7/21.
 * <p>
 * for index.html page
 *
 * @author jerry
 */
@Controller
public class IndexController {

    /**
     * static page
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("list", Lists.newArrayList("a", "b", "c"));
        return "index.html";
    }

    /**
     * template page
     *
     * @param title
     * @param model
     * @return
     */
    @RequestMapping("/foo")
    public String greeting(@RequestParam(value = "title", required = false, defaultValue = "xiao") String title,
                           Model model) {

        model.addAttribute("name", title);
        return "main/index";
    }
}
