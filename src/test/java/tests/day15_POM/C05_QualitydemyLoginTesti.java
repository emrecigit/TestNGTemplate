package tests.day15_POM;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.*;

import static utilities.Driver.getDriver;

public class C05_QualitydemyLoginTesti {
    @Test
    public void test01_team4() throws InterruptedException {
        // QUALITYDEMY ANA SAYFAYA GIDIN
        getDriver().get(ConfigReader.getProperty("qdUrl"));

        // login linkine tiklayin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
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
        String result = String.valueOf(Reporter.getCurrentTestResult());
        System.out.println("***" + result + "***");
        if (result.contains("TestResult")) {
            System.out.println("Test PASSED!");
            // Test sonucunu göstermek için overlay elementini ekleyin
            JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
            jse.executeScript("var overlay = document.createElement('div');"
                    + "overlay.style.position = 'fixed';"
                    + "overlay.style.top = '0';"
                    + "overlay.style.left = '0';"
                    + "overlay.style.width = '100%';"
                    + "overlay.style.height = '100%';"
                    + "overlay.style.backgroundColor = 'rgba(0, 0, 0, 0.5)';"
                    + "overlay.style.color = '#fff';"
                    + "overlay.style.fontSize = '24px';"
                    + "overlay.style.display = 'flex';"
                    + "overlay.style.justifyContent = 'center';"
                    + "overlay.style.alignItems = 'center';"
                    + "overlay.textContent = 'Test PASSED!';"
                    + "document.body.appendChild(overlay);");

            TakePhotoMethods_P.tumSayfaFotografCek(Driver.getDriver(), TakePhotoMethods_P.methodNameGetir());
            TakePhotoMethods_P.webElementFotografCek(Driver.getDriver(), qualitydemyPage.basariliGirisKontrolElementi, TakePhotoMethods_P.methodNameGetir());

            // Overlay elementini kaldırın
            jse.executeScript("setTimeout(function() {"
                    + "var overlay = document.getElementById('overlay');"
                    + "overlay.parentNode.removeChild(overlay);"
                    + "}, 2000);");
        } else {
            System.out.println("Test FAILED!");
        }
        // Test sonucunu raporlayın
        Reporter.log("Test PASSED!");
        // sayfayi kapatin
        Driver.closeDriver();

        //String result = String.valueOf(Reporter.getCurrentTestResult());
        //jse.executeScript("alert('Test PASSED!');");
        //Alert alert = Driver.getDriver().switchTo().alert();
        //String alertText = alert.getText();
        //alert.accept();
        // WebDriver driver = (WebDriver) jse;
        // WebDriver driver = Driver.getDriver();
        // jse.executeScript("arguments[0].textContent = 'Test PASSED!'", qualitydemyPage.basariliGirisKontrolElementi);
        // Test PASSED yazisi basariliGirisKontrolElementi 'ne atandi
        // Driver tarafından yönetilen bir alert mesajını ekran görüntüsü olarak
        // yakalamak mümkün değildir. Alert mesajı, driver'a ait bir bileşen olduğu için,
        // ekran görüntüsü alındığında alert mesajı görünmeyecektir.
    }
}