package com.enessimsek.n11demo.n11demotraining.converter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("xml")
public class XmlResponseConverter implements ResponseConverter {
    @Override
    public void convert() {
        System.out.println("xml");
    }
}
