package org.aibles.projectdemo.service.iml;

import org.aibles.projectdemo.exception.ArticleAlreadyExited;
import org.aibles.projectdemo.exception.ArticleNotFoundException;
import org.aibles.projectdemo.exception.NoContentException;
import org.aibles.projectdemo.model.Article;
import org.aibles.projectdemo.repository.ArticleRepository;
import org.aibles.projectdemo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceIml implements ArticleService {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceIml(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> getAllArticle() {
        List<Article> articles = articleRepository.findAll();
        if(!articles.isEmpty()){
            return articles;
        }
        else{
            throw new NoContentException();
        }
    }

    @Override
    public Article getArticleById(int id) {
        Article article = articleRepository.findById(id).orElse(null);
        if(article != null){
            return article;
        }
        else{
            throw new ArticleNotFoundException();
        }
    }

    @Override
    public Article createArticle(Article article) {
        articleRepository.findByTitle(article.getTitle()).ifPresentOrElse(article1 ->{
            throw new ArticleAlreadyExited();
        },()->articleRepository.save(article));
        return article;
    }

    @Override
    public Article updateArticle(int id, Article article) {
        Article articleUpdated = articleRepository.findById(id).orElse(null);
        if(articleUpdated != null){
            articleUpdated.setTitle(article.getTitle());
            articleUpdated.setDescription(article.getDescription());
            articleUpdated.setPublished(article.isPublished());
            articleRepository.save(articleUpdated);
            return articleUpdated;
        }
        else{
            throw new ArticleNotFoundException();
        }
    }

    @Override
    public void deleteArticle(int id) {
        Article article = articleRepository.findById(id).orElse(null);
        if(article != null){
            articleRepository.delete(article);
        } else {
            throw new ArticleNotFoundException();
        }
    }

}
