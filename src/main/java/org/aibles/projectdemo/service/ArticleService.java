package org.aibles.projectdemo.service;

import org.aibles.projectdemo.model.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getAllArticle();
    Article getArticleById(int id);
    Article createArticle(Article article);
    Article updateArticle(int id, Article article);
    void deleteArticle(int id);
}
