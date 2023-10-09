package hackaton.selenium.hackaton;

import hackaton.selenium.hackaton.pages.HomePage;
import org.junit.jupiter.api.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class HackatonSecretTest {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://dusbez5zif8yv.cloudfront.net");

        homePage = new HomePage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void emptyNameSecret() {
        enterNameInput(" ");
    }

    @Test
    public void urlPathSecret() {
        driver.get("https://dusbez5zif8yv.cloudfront.net/sixth-page");
        driver.get("https://dusbez5zif8yv.cloudfront.net/seventh-page");
        driver.get("https://dusbez5zif8yv.cloudfront.net/eighth-page");
    }

    @Test
    public void duplicateNameSecret() {
        enterNameInput("BBB");
    }

    @Test
    public void hiddenTrease() {
        Dimension dimension = new Dimension(1280, 660);
        driver.manage().window().setSize(dimension);

        Actions actions = new Actions(driver);
        actions.moveToLocation(1050, 202).click().perform();
    }

    @Test
    public void emptyName() {
        enterNameInput("");
        WebElement yesInput = driver.findElement(By.id("yes"));
        yesInput.click();
    }


    @Test
    public void localstorageBBBName() {
        enterNameInput("Jeroen");

        WebElement yesInput = driver.findElement(By.id("yes"));
        yesInput.click();

        driver.get("https://dusbez5zif8yv.cloudfront.net/fifth-page");
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        localStorage.setItem("username", "BBB");
        System.out.println("test");
    }

    private void enterNameInput(String name) {
        homePage.startButton.click();

        WebElement modalStartButton = driver.findElement(By.cssSelector("button[tabindex='0']"));
        modalStartButton.click();

        WebElement modalStartTweeButton = driver.findElement(By.cssSelector("button[tabindex='0']"));
        modalStartTweeButton.click();

        WebElement nameInput = driver.findElement(By.id("nameInput"));
        nameInput.sendKeys(name);
        nameInput.sendKeys(Keys.ENTER);
    }
}
