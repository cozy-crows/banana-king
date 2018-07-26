package com.example.bananaking.web.controller;

import com.example.bananaking.entity.Page;
import com.example.bananaking.repository.PageRepository;
import com.example.bananaking.service.CommentService;
import com.example.bananaking.service.dto.KingOfComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by jerry on 2018/7/21.
 * <p>
 * for index.html page
 *
 * @author jerry
 */
@Controller
public class IndexController {

    @Autowired
    private PageRepository pageRepo;
    @Autowired
    private CommentService commentService;

    /**
     * first page
     *
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String index(Model model) {
        List<Page> pages = pageRepo.findAll();
        model.addAttribute("pages", pages);
        return "main/index";
    }

    @RequestMapping("/fans")
    public String fans(
        @RequestParam(value = "pageId", defaultValue = "540088262692058") String pageId,
        Model model) {
        List<KingOfComment> kingOfComments = commentService.top10CommentUsers();
        model.addAttribute("kingOfComments", kingOfComments);
        return "main/fans";
    }
}
