package org.aibles.projectdemo.exception;

import org.springframework.http.HttpStatus;

public class ArticleAlreadyExited extends AbstractException{
    public ArticleAlreadyExited() {
        super("Article Already exited", HttpStatus.BAD_REQUEST);
    }
}
