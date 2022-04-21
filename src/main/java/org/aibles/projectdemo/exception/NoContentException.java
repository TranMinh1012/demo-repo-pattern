package org.aibles.projectdemo.exception;

import org.springframework.http.HttpStatus;

public class NoContentException extends AbstractException{
    public NoContentException() {
        super("No content", HttpStatus.NO_CONTENT);
    }
}
