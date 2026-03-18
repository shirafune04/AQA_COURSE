import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void scrollToBlock() {
        WebElement block = driver.findElement(By.xpath("//h2[contains(text(),'Онлайн пополнение')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", block);
        try { Thread.sleep(500); } catch (Exception e) {}
    }
}