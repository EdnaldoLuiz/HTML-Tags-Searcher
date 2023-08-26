package com.htmlTags.config;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MalformedURLException.class)
    public String urlInvalida(MalformedURLException ex, Model model) {
        return "error";
    }

    @ExceptionHandler(IOException.class)
    public String getIOException(IOException ex, Model model) {
        return "error"; 
    }
}
