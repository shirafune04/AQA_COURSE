import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaymentFrame extends BasePage {

    public PaymentFrame(WebDriver driver) {
        super(driver);
        switchToFrame();
    }

    private void switchToFrame() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));
            driver.switchTo().frame(0);
            Thread.sleep(3000); // Увеличил паузу

            // Выводим всё что есть в iframe
            System.out.println("=== СОДЕРЖИМОЕ IFRAME ===");
            System.out.println(driver.getPageSource());
            System.out.println("==========================");

        } catch (Exception e) {
            System.out.println("Ошибка при переходе в iframe: " + e.getMessage());
        }
    }

    public String getTotalAmount() {
        try {
            // Ищем разные варианты
            String[] xpaths = {
                    "//*[contains(text(),'BYN')]",
                    "//*[contains(text(),'руб')]",
                    "//*[contains(text(),'.00')]",
                    "//div[contains(@class,'total')]",
                    "//button"
            };

            for (String xpath : xpaths) {
                if (driver.findElements(By.xpath(xpath)).size() > 0) {
                    String text = driver.findElement(By.xpath(xpath)).getText();
                    if (text.contains("150") || text.contains("BYN") || text.contains("руб")) {
                        return text;
                    }
                }
            }
            return "Не найдено";
        } catch (Exception e) {
            return "Ошибка";
        }
    }

    public String getButtonAmount() {
        try {
            WebElement btn = driver.findElement(By.xpath("//button"));
            return btn.getText();
        } catch (Exception e) {
            return "Нет кнопки";
        }
    }

    public String getPhoneNumber() {
        try {
            String[] xpaths = {
                    "//*[contains(text(),'375')]",
                    "//*[contains(text(),'Номер:')]",
                    "//*[contains(text(),'телефон')]"
            };

            for (String xpath : xpaths) {
                if (driver.findElements(By.xpath(xpath)).size() > 0) {
                    return driver.findElement(By.xpath(xpath)).getText();
                }
            }
            return "Не найден";
        } catch (Exception e) {
            return "Ошибка";
        }
    }

    public boolean hasField(String name) {
        try {
            return driver.findElements(By.xpath("//*[contains(text(),'" + name + "')]")).size() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean hasIcons() {
        try {
            return driver.findElements(By.xpath("//img")).size() > 0;
        } catch (Exception e) {
            return false;
        }
    }
}