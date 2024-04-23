package com.example.MyBoard.controller;

import com.example.MyBoard.dto.ArticleDto;
import com.example.MyBoard.repositary.service.ArticleService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/articles")
@Transactional
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/insert")
    public String insert(Model model){
        model.addAttribute("dto",new ArticleDto());
        return "/articles/new";
    }
    @PostMapping("/insert")
    public String insertOne(@Valid @ModelAttribute("dto")ArticleDto dto,
                            BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "/articles/new";
        }
        articleService.add(dto);
        return "redirect:/";
    }
    @PostMapping("/update")
    public String updateOne(@Valid @ModelAttribute("dto")ArticleDto dto,
                            BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "/articles/update";
        }
        articleService.update(dto);
        return "redirect:/";
    }
    @GetMapping("/update")
    public String update(@RequestParam("id")Long id,
                         Model model){
        ArticleDto dto = articleService.findById(id);
        model.addAttribute("dto",dto);
        return "/articles/update";
    }
    @GetMapping("/delete")
    public String deleteform(@RequestParam("id")Long id){
        articleService.deleteById(id);
        return "redirect:/";
    }
    @GetMapping("/")
    public String showAll(Model model){
        List<ArticleDto> list = articleService.findAll();
        model.addAttribute("dtos",list);
        return "articles/show_all";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model,
                         @PathVariable("id")Long id){
        model.addAttribute("dto",articleService.findById(id));
        return "articles/detail";
    }
}

