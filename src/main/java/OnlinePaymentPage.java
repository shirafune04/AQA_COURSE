
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class OnlinePaymentPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//h2[contains(.,'Онлайн пополнение без комиссии')]")
    private WebElement blockTitle;

    @FindBy(xpath = "//div[contains(@class,'pay__partners')]//img")
    private List<WebElement> paymentLogos;

    @FindBy(xpath = "//a[contains(text(),'Подробнее о сервисе')]")
    private WebElement moreDetailsLink;

    @FindBy(xpath = "//button[contains(text(),'Услуги связи')]")
    private WebElement servicesTab;

    @FindBy(xpath = "//button[contains(text(),'Домашний интернет')]")
    private WebElement internetTab;

    @FindBy(xpath = "//button[contains(text(),'Рассрочка')]")
    private WebElement installmentTab;

    @FindBy(xpath = "//button[contains(text(),'Задолженность')]")
    private WebElement debtTab;

    @FindBy(xpath = "//label[@for='connection-phone']")
    private WebElement phoneLabel;  // ДОБАВЛЕНО

    @FindBy(xpath = "//span[contains(text(),'+375')]")  // ИСПРАВЛЕНО: добавлена ]
    private WebElement phonePrefix;

    @FindBy(xpath = "//label[@for='connection-sum']")
    private WebElement sumLabel;  // ДОБАВЛЕНО

    @FindBy(xpath = "//span[contains(text(),'Руб')]")  // ИСПРАВЛЕНО: добавлена ]
    private WebElement sumCurrency;

    @FindBy(xpath = "//label[@for='connection-email']")
    private WebElement emailLabel;  // ДОБАВЛЕНО

    @FindBy(id = "connection-phone")
    private WebElement phoneInput;

    @FindBy(id = "connection-sum")
    private WebElement sumInput;

    @FindBy(id = "connection-email")
    private WebElement emailInput;

    @FindBy(xpath = "//button[contains(text(),'Продолжить')]")
    private WebElement continueButton;

    public OnlinePaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        PageFactory.initElements(driver, this);
    }

    public String getBlockTitle() {
        return wait.until(ExpectedConditions.visibilityOf(blockTitle)).getText();
    }

    public int getLogosCount() {
        return wait.until(ExpectedConditions.visibilityOfAllElements(paymentLogos)).size();
    }

    public void clickMoreDetailsLink() {
        wait.until(ExpectedConditions.elementToBeClickable(moreDetailsLink)).click();
    }

    public void selectServicesTab() {
        wait.until(ExpectedConditions.elementToBeClickable(servicesTab)).click();
    }

    public void selectInternetTab() {
        wait.until(ExpectedConditions.elementToBeClickable(internetTab)).click();
    }

    public void selectInstallmentTab() {
        wait.until(ExpectedConditions.elementToBeClickable(installmentTab)).click();
    }

    public void selectDebtTab() {
        wait.until(ExpectedConditions.elementToBeClickable(debtTab)).click();
    }

    public String getPhoneLabel() {
        return wait.until(ExpectedConditions.visibilityOf(phoneLabel)).getText();
    }

    public String getSumLabel() {
        return wait.until(ExpectedConditions.visibilityOf(sumLabel)).getText();
    }

    public String getEmailLabel() {
        return wait.until(ExpectedConditions.visibilityOf(emailLabel)).getText();
    }

    public String getPhonePrefix() {
        return wait.until(ExpectedConditions.visibilityOf(phonePrefix)).getText();
    }

    public String getSumCurrency() {
        return wait.until(ExpectedConditions.visibilityOf(sumCurrency)).getText();
    }

    public void fillPhoneNumber(String phone) {
        wait.until(ExpectedConditions.visibilityOf(phoneInput)).sendKeys(phone);
    }

    public void fillSum(String sum) {
        wait.until(ExpectedConditions.visibilityOf(sumInput)).sendKeys(sum);
    }

    public void fillEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailInput)).sendKeys(email);
    }
    public void clickContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    public void switchToPaymentFrame() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(0);
    }

}