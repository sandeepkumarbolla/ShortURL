package com.example.URL_shortner.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class LinkService {
    public String RandomStringGenerator(){
        Random rand = new Random();
        String str = rand.ints(97, 123)
                .limit(5)
                .mapToObj(c -> (char)c).collect(StringBuffer::new, StringBuffer::append, StringBuffer::append)
                .toString();
        return str;
    }
}
