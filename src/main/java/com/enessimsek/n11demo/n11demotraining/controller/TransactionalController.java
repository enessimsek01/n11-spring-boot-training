package com.enessimsek.n11demo.n11demotraining.controller;

import com.enessimsek.n11demo.n11demotraining.converter.CategoryConverter;
import com.enessimsek.n11demo.n11demotraining.dto.CategoryDto;
import com.enessimsek.n11demo.n11demotraining.entity.Category;
import com.enessimsek.n11demo.n11demotraining.transactional.ts1.Ts1Service;
import com.enessimsek.n11demo.n11demotraining.transactional.ts2.Ts2Service;
import com.enessimsek.n11demo.n11demotraining.transactional.ts3.Ts3Service1;
import com.enessimsek.n11demo.n11demotraining.transactional.ts4.Ts4Service1;
import com.enessimsek.n11demo.n11demotraining.transactional.ts5.Ts5Service1;
import com.enessimsek.n11demo.n11demotraining.transactional.ts6.Ts6Service1;
import com.enessimsek.n11demo.n11demotraining.transactional.ts7.Ts7Service;
import com.enessimsek.n11demo.n11demotraining.transactional.ts8.Ts8Service;
import com.enessimsek.n11demo.n11demotraining.transactional.ts9.Ts9Service1;
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

    @Autowired
    private Ts5Service1 ts5Service1;

    @Autowired
    private Ts6Service1 ts6Service1;

    @Autowired
    private Ts7Service ts7Service;

    @Autowired
    private Ts8Service ts8Service;

    @Autowired
    private Ts9Service1 ts9Service1;

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

    /**
     * 5: ikisi de transactional olan bir yerde kayıt işlemi
     */
    @PostMapping("/ts5")
    public void ts5(){
        ts5Service1.save();
    }

    /**
     * 6: sadece transactional olan bir yerde kayıt işlemi sırasında hata
     */
    @PostMapping("/ts6")
    public void ts6(){
        ts6Service1.save();
    }

    /**
     * 7: non transactional olan bir yerde kayıt işlemi sırasında hata
     */
    @PostMapping("/ts7")
    public void ts7(){
        ts7Service.save();
    }

    /**
     * 8: aynı class içerisinde requires new kullanımı
     */
    @PostMapping("/ts8")
    public void ts8(){
        ts8Service.save();
    }

    /**
     * 9: requires new i farklı classa taşıma
     */
    @PostMapping("/ts9")
    public void ts9(){
        ts9Service1.save();
    }
}
