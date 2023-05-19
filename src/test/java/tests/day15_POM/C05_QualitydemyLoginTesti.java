package tests.day15_POM;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.*;

public class C05_QualitydemyLoginTesti {
    @Test
    public void test01() throws InterruptedException {
        // QUALITYDEMY ANA SAYFAYA GIDIN
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        // login linkine tiklayin
        QualitydemyPage qualitydemyPage= new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();

        // gecerli username ve sifre yi ilgili kutulara yazin
        qualitydemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        qualitydemyPage.acceptCookieElementi.click();
        ReusableMethods_P.bekle(5);
        // login butonuna basin
        qualitydemyPage.loginButonu.click();

        // basarili olarak giris yapildigini test edin
        Assert.assertTrue(qualitydemyPage.basariliGirisKontrolElementi.isDisplayed());
        //String result = String.valueOf(Reporter.getCurrentTestResult());
        //JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        //jse.executeScript("alert('Test PASSED!');");

        TakePhotoMethods_P.tumSayfaFotografCek(Driver.getDriver(), TakePhotoMethods_P.methodNameGetir());
        TakePhotoMethods_P.webElementFotografCek(Driver.getDriver(), qualitydemyPage.basariliGirisKontrolElementi, TakePhotoMethods_P.methodNameGetir());

        // sayfayi kapatin
        Driver.closeDriver();
    }

}
