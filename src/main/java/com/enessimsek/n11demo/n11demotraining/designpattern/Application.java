package com.enessimsek.n11demo.n11demotraining.designpattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Application {

    public static void main(String[] args) {

//      SingletonEnumService instance = SingletonEnumService.INSTANCE;

        Class<?> clazz = null;

        try {
            clazz = Class.forName("com.enessimsek.n11demo.n11demotraining.designpattern.SingletonService");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Constructor<?> constructor = clazz.getDeclaredConstructors()[0];


    }

    private static void BBB() {

        /**
         * REFLECTIONS ARAŞTIR.
         * 3. HAFTA PAZAR PART 5 DAKİKA 40
         */
        for (int i = 0; i < 10; i++) {

            Class<?> clazz = null;

            try {
                clazz = Class.forName("com.enessimsek.n11demo.n11demotraining.designpattern.SingletonService");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            Constructor<?> constructor = clazz.getDeclaredConstructors()[0];
            constructor.setAccessible(true);

            SingletonService singletonService = null;
            try {
                singletonService = (SingletonService)constructor.newInstance(null);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }


        }
        int count = SingletonService.getCount();

        System.out.println(count);
    }

    private static void APP1() {
        for (int i = 0; i < 10; i++) {

            SingletonService singletonService = SingletonService.getSingletonService();
        }

        int count = SingletonService.getCount();

        System.out.println(count);
    }
}
