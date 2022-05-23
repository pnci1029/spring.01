package HCHH.Spring.controller;

import HCHH.Spring.DTO.ArticleForm;
import HCHH.Spring.Entity.EntityContent;
import HCHH.Spring.repository.ContentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class ArticleController {
    @Autowired
    private ContentRepository contentRepository;

    @GetMapping("articles/new")
    public String articleNew(){
        return "article/new";
    }
    @PostMapping("articles/create")
    public String articleCreate(ArticleForm form){
        System.out.println(form.toString());
        //EntityContent => 엔티티
        EntityContent entityContent= form.toEntity();

        EntityContent saved = contentRepository.save(entityContent);
        System.out.println(saved);
        return "article/new";
    }




}
