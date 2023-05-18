package tests.day15_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TakePhotoMethods;

public class C05_QualitydemyLoginTesti {
    @Test
    public void test01(){
        // QUALITYDEMY ANA SAYFAYA GIDIN
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        // login linkine tiklayin
        QualitydemyPage qualitydemyPage= new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();

        // gecerli username ve sifre yi ilgili kutulara yazin
        qualitydemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        qualitydemyPage.acceptCookieElementi.click();
        ReusableMethods.bekle(5);
        // login butonuna basin
        qualitydemyPage.loginButonu.click();


        // basarili olarak giris yapildigini test edin

        Assert.assertTrue(qualitydemyPage.basariliGirisKontrolElementi.isDisplayed());
        TakePhotoMethods.tumSayfaFotografCek(Driver.getDriver(),TakePhotoMethods.methodNameGetir());
        // sayfayi kapatin
        Driver.closeDriver();
    }

}
