import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaymentFrame extends BasePage {

    public PaymentFrame(WebDriver driver) throws InterruptedException {
        super(driver);
        switchToFrame();
    }

    private void switchToFrame() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(0);
        Thread.sleep(3000);
    }

    public String getTotalAmount() {
        return driver.findElement(By.xpath("//*[contains(text(),'BYN')]")).getText();
    }

    public String getButtonAmount() {
        return driver.findElement(By.xpath("//button")).getText();
    }

    public String getPhoneNumber() {
        return driver.findElement(By.xpath("//*[contains(text(),'375')]")).getText();
    }

    public boolean hasField(String name) {
        return !driver.findElements(By.xpath("//*[contains(text(),'" + name + "')]")).isEmpty();
    }

    public boolean hasIcons() {
        return !driver.findElements(By.xpath("//img")).isEmpty();
    }
}