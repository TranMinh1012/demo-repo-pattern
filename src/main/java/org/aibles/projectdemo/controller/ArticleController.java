package org.aibles.projectdemo.controller;

import org.aibles.projectdemo.model.Article;
import org.aibles.projectdemo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleController {


    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public ResponseEntity<List<Article>> getAllArticle(){
        List<Article> articleList = articleService.getAllArticle();
        return new ResponseEntity<>(articleList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable("id") int id){
        Article article = articleService.getArticleById(id);
        return new ResponseEntity<>(article, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Article> createArticle(@Valid @RequestBody Article article){
        Article articleCreated = articleService.createArticle(article);
        return new ResponseEntity<>(articleCreated, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable("id") int id, @Valid @RequestBody Article article){
        articleService.updateArticle(id, article);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Article> deleteArticle(@PathVariable("id") int id){
        articleService.deleteArticle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
