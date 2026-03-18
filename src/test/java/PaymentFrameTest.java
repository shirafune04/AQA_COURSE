import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

class PaymentFrame extends BasePage {

    public PaymentFrame(WebDriver driver) throws InterruptedException {
        super(driver);
        switchToFrame();
    }

    @Step("Переключение на фрейм оплаты")
    private void switchToFrame() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(0);
        Thread.sleep(3000);
    }

    @Step("Получение общей суммы")
    public String getTotalAmount() {
        return driver.findElement(By.xpath("//*[contains(text(),'BYN')]")).getText();
    }

    @Step("Получение суммы на кнопке")
    public String getButtonAmount() {
        return driver.findElement(By.xpath("//button")).getText();
    }

    @Step("Получение номера телефона")
    public String getPhoneNumber() {
        return driver.findElement(By.xpath("//*[contains(text(),'375')]")).getText();
    }

    @Step("Проверка наличия поля: {name}")
    public boolean hasField(String name) {
        return !driver.findElements(By.xpath("//*[contains(text(),'" + name + "')]")).isEmpty();
    }

    @Step("Проверка наличия иконок")
    public boolean hasIcons() {
        return !driver.findElements(By.xpath("//img")).isEmpty();
    }
}