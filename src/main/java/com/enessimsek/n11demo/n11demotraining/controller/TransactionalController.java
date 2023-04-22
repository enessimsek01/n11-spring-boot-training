package com.enessimsek.n11demo.n11demotraining.controller;

import com.enessimsek.n11demo.n11demotraining.converter.CategoryConverter;
import com.enessimsek.n11demo.n11demotraining.dto.CategoryDto;
import com.enessimsek.n11demo.n11demotraining.entity.Category;
import com.enessimsek.n11demo.n11demotraining.transactional.ts1.Ts1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/transactional")
public class TransactionalController {

    @Autowired
    private Ts1Service ts1Service;

    /**
     * 1: transactional olmayan yerde kayıt işlemi
     */
    @PostMapping("/ts1")
    public void ts1(){
        ts1Service.save();
    }

}
