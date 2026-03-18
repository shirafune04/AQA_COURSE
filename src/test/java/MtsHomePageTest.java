import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import java.util.List;

class MtsHomePage extends BasePage {

    public MtsHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "select__header")
    private WebElement dropdown;

    @FindBy(xpath = "//button[contains(text(),'Продолжить')]")
    private WebElement continueBtn;

    @Step("Выбор вкладки: {tabName}")
    public void selectTab(String tabName) {
        try {
            dropdown.click();
            Thread.sleep(500);

            List<WebElement> items = driver.findElements(By.className("select__item"));
            for (WebElement item : items) {
                if (item.getText().contains(tabName)) {
                    item.click();
                    break;} }
            Thread.sleep(500);

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    @Step("Получение плейсхолдера телефона")
    public String getPhonePlaceholder() {
        return driver.findElement(By.id("connection-phone")).getAttribute("placeholder");
    }

    @Step("Получение плейсхолдера суммы")
    public String getAmountPlaceholder() {
        return driver.findElement(By.id("connection-sum")).getAttribute("placeholder");
    }

    @Step("Получение плейсхолдера email")
    public String getEmailPlaceholder() {
        return driver.findElement(By.id("connection-email")).getAttribute("placeholder");
    }

    @Step("Заполнение формы: телефон {phone}, сумма {amount}, email {email}")
    public void fillForm(String phone, String amount, String email) {
        driver.findElement(By.id("connection-phone")).sendKeys(phone);
        driver.findElement(By.id("connection-sum")).sendKeys(amount);
        driver.findElement(By.id("connection-email")).sendKeys(email);
    }
    @Step("Нажатие кнопки Продолжить")
    public PaymentFrame clickContinue() throws InterruptedException {
        continueBtn.click();
        return new PaymentFrame(driver);
    }
}