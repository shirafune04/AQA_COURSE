import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MtsOnlinePaymentTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private OnlinePaymentPage paymentPage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testBlockTitle() {
        WebElement title = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h2[contains(.,'Онлайн пополнение без комиссии')]")));

        String actualTitle = title.getText()
                .replace("\n", " ")
                .replaceAll("\\s+", " ")
                .trim();
        assertEquals("Онлайн пополнение без комиссии", actualTitle);
    }

    @Test
    public void testPaymentLogos() {
        List<WebElement> logos = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//div[contains(@class,'pay__partners')]//img")));
        assertTrue(logos.size() >= 5);
    }

    @Test
    public void testMoreDetailsLink() {
        String originalUrl = driver.getCurrentUrl();
        WebElement link = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[contains(text(),'Подробнее о сервисе')]")));
        link.click();
        wait.until(ExpectedConditions.not(
                ExpectedConditions.urlToBe(originalUrl)));
        assertNotEquals(originalUrl, driver.getCurrentUrl());
    }
    @Test
    public void testLabelsForServicesTabs() {
        paymentPage.selectServicesTab();
        assertNotNull(paymentPage.getPhoneLabel);
    }

    @Test
    public void testContinueButton() {
        driver.findElement(By.id("connection-phone")).sendKeys("297777777");
        driver.findElement(By.id("connection-sum")).sendKeys("40");
        driver.findElement(By.id("connection-email")).sendKeys("katyashh@gmail.com");

        driver.findElement(By.xpath("//button[contains(text(),'Продолжить')]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(0);

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(), 'Номер карты')]")));
    }
}