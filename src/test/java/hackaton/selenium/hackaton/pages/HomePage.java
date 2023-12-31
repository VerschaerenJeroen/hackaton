package hackaton.selenium.hackaton.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(id = "start-button")
    public WebElement startButton;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
