package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WisePage {
        public WisePage() {

            PageFactory.initElements(Driver.getDriver(), this);
        }

        @FindBy(xpath = "(//a[@class='elementskit-btn whitespace--normal'])[2]")
        public WebElement exploreTheCourseButon;

    }