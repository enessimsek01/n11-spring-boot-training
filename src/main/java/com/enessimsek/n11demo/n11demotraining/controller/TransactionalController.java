package com.enessimsek.n11demo.n11demotraining.controller;

import com.enessimsek.n11demo.n11demotraining.converter.CategoryConverter;
import com.enessimsek.n11demo.n11demotraining.dto.CategoryDto;
import com.enessimsek.n11demo.n11demotraining.entity.Category;
import com.enessimsek.n11demo.n11demotraining.transactional.ts1.Ts1Service;
import com.enessimsek.n11demo.n11demotraining.transactional.ts2.Ts2Service;
import com.enessimsek.n11demo.n11demotraining.transactional.ts3.Ts3Service1;
import com.enessimsek.n11demo.n11demotraining.transactional.ts4.Ts4Service1;
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

    @Autowired
    private Ts2Service ts2Service;

    @Autowired
    private Ts3Service1 ts3Service1;

    @Autowired
    private Ts4Service1 ts4Service1;
    /**
     * 1: transactional olmayan yerde kayıt işlemi
     */
    @PostMapping("/ts1")
    public void ts1(){
        ts1Service.save();
    }

    /**
     * 2: transactional olan yerde kayıt işlemi
     */
    @PostMapping("/ts2")
    public void ts2(){
        ts2Service.save();
    }

    /**
     * 3: transactional olan yerden olmayan yere geçme
     */
    @PostMapping("/ts3")
    public void ts3(){
        ts3Service1.save();
    }

    /**
     * 4: transactional olmayan yerden olan yere geçme
     */
    @PostMapping("/ts4")
    public void ts4(){
        ts4Service1.save();
    }
}
