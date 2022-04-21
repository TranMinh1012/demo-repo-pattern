package org.aibles.projectdemo.exception;

import org.springframework.http.HttpStatus;

public class ArticleNotFoundException extends AbstractException{
    public ArticleNotFoundException() {
        super("Article not found", HttpStatus.NOT_FOUND);
    }
}
