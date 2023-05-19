package utilities;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.WisePage;

public class AlertJavaScriptExecutor_P extends WisePage {
    @Test
    public void test01() throws InterruptedException {
        // wisequarter anasayfaya gidin
        WisePage wisePage = new WisePage();
        Driver.getDriver().get(ConfigReader.getProperty("wiseUrl"));
        // asagiya inerek Software Development Engineer in Test - SDET
        // kursunda Explore the Course butonuna basin
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        // jse ile butona kadar scroll yapalim
        jse.executeScript("arguments[0].scrollIntoView();",exploreTheCourseButon);
        // jse ile click yapalim
        jse.executeScript("arguments[0].click();",exploreTheCourseButon);
        // jse ile alert olusturma
        jse.executeScript("alert('test passed');");
        Thread.sleep(5000);
        //
    }
}




