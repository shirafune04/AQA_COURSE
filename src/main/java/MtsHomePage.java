import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class MtsHomePage extends BasePage {

    public MtsHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "select__header")
    private WebElement dropdown;

    @FindBy(xpath = "//button[contains(text(),'Продолжить')]")
    private WebElement continueBtn;

    public void selectTab(String tabName) {
        try {
            dropdown.click();
            Thread.sleep(500);

            List<WebElement> items = driver.findElements(By.className("select__item"));
            for (WebElement item : items) {
                if (item.getText().contains(tabName)) {
                    item.click();
                    break;
                }
            }

            Thread.sleep(500);

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public String getPhonePlaceholder() {
        return driver.findElement(By.id("connection-phone")).getAttribute("placeholder");
    }

    public String getAmountPlaceholder() {
        return driver.findElement(By.id("connection-sum")).getAttribute("placeholder");
    }

    public String getEmailPlaceholder() {
        return driver.findElement(By.id("connection-email")).getAttribute("placeholder");
    }

    public void fillForm(String phone, String amount, String email) {
        driver.findElement(By.id("connection-phone")).sendKeys(phone);
        driver.findElement(By.id("connection-sum")).sendKeys(amount);
        driver.findElement(By.id("connection-email")).sendKeys(email);
    }
    public PaymentFrame clickContinue() {
        continueBtn.click();
        return new PaymentFrame(driver);
    }
}