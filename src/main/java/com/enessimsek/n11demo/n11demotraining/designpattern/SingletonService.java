package com.enessimsek.n11demo.n11demotraining.designpattern;

public class SingletonService {

    private static int count = 0;
    private static SingletonService singletonService;


    private SingletonService() {
        System.out.println("oluştum");
        count++;

    }

    public static SingletonService getSingletonService() {
/**
 * BURADA synchronized EKLEMESEYDİK SADECE IF BLOKU VE RETURN STATEMENTS KALSAYDI
 * THREAD SAFE BİR GELİŞTİRME YAPMIŞ OLMAYACAKTIK. YANİ AYNI ANDA İKİ THREAD, SİNGLETONSERVİCE OBJESİ
 * NULL OLDUĞUNDA GELSEYDİ VE İKİSİ DE NULL OLARAK GELSEYDİ, İKİ THREAD DE YENİ BİR SİNGLETONSERVİCE OBJESİ
 * OLUŞTURMAYA ÇALIŞACAKTI. synchronized SAYESİNDE BU DURUMDAN KURTULMUŞ OLUYORUZ
 * --------------------
 * ANCAK BUNUN DA BİR SORUNU VAR synchronized TIPKI 5 ŞERİTTE YAN YANA GİDEN 5 ARACIN BİRDEN TEK ŞERİDE DÜŞÜP
 * SIRALI HALE GELİP İLERLEMESİ GİBİ THREADLERİ SIRAYA KOYUYOR. BU DURUMDA GELEN THREAD BİTENE KADAR DİĞERİNİ
 * BEKLETİYOR. BU DA UYGULAMAYI ZORA SOKUYOR VE YAVAŞLATIYOR.
 * ----------------
 * BUNUN DA BİR ÇÖZÜMÜ VAR synchronized'TAN ÖNCE synchronized OLAN if CASE'İNİ AYNI ŞEKİLDE synchronized'DAN ÖNCE
 * YAZIYORUZ (SATIR 28)
 */
        if (singletonService == null) {
            synchronized (SingletonService.class) {
                if (singletonService == null) {
                    return singletonService = new SingletonService();
                }
            }
        }
            return singletonService;

    }

    public static int getCount() {
        return count;
    }
}
