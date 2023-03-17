package com.enessimsek.n11demo.n11demotraining.service;

import com.enessimsek.n11demo.n11demotraining.converter.ResponseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class WebService {

    @Autowired
    @Qualifier("json")
    private ResponseConverter responseConverter;

    public void convertResponse(){
        responseConverter.convert();

    }
}
