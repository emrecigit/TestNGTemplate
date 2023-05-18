package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class ReusableMethods {
    public static void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {

        }
    }




    public static void tumSayfaFotografCek(WebDriver driver, String methodNameGetir)  {
        TakesScreenshot tss = (TakesScreenshot) driver;
        LocalDateTime ldt = LocalDateTime.now();
        String tarihEtiketi = methodNameGetir+"_"+"FullScreen"+"_"+ldt.getYear()+"_"+ldt.getMonthValue()+"_"
                +ldt.getDayOfMonth()+"_"+ldt.getHour()+"_"+ldt.getMinute()+"_"+ldt.getSecond()+".png";
        String path= "target/ekranResimleri/"+tarihEtiketi;
        File tumSayfaFotograf= new File(path);
        File geciciResim = tss.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(geciciResim,tumSayfaFotograf);
        } catch (IOException e) {
        }
    }
    public static void webElementFotografCek(WebDriver driver, WebElement webElement , String methodNameGetir) {
        LocalDateTime ldt = LocalDateTime.now();
        String tarihEtiketi = methodNameGetir+"_"+ "WebElement"+"_"+ldt.getYear()+"_"+ldt.getMonthValue()+"_"
                +ldt.getDayOfMonth()+"_"+ldt.getHour()+"_"+ldt.getMinute()+"_"+ldt.getSecond()+".png";
        String path= "target/ekranResimleri/"+tarihEtiketi;
        File tumSayfaFotograf= new File(path);
        File geciciResim = webElement.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(geciciResim,tumSayfaFotograf);
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) {
        System.out.println(methodNameGetir());
    }

    public static String  methodNameGetir() {
        String currentMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        return currentMethodName;
    }

    //     public static String methodNameGetir() {
    //     StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace(); // Method ismini getirir 2-1
    //     String currentMethodName = stackTrace[1].getMethodName();                // Method ismini getirir 2-2
    //     return currentMethodName;
    // }
}
