import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.jupiter.api.Assertions.*;

class MtsPaymentTest {
    private WebDriver driver;
    private MtsHomePage homePage;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        homePage = new MtsHomePage(driver);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void testAllTabs() throws Exception {
        homePage.scrollToBlock();

        String[][] tabs = {
                {"Домашний интернет", "Номер абонента"},
                {"Рассрочка", "Номер счета на 44"},
                {"Задолженность", "Номер счета на 2073"}
        };

        for (String[] tab : tabs) {
            homePage.selectTab(tab[0]);

            String phone = homePage.getPhonePlaceholder();
            String amount = homePage.getAmountPlaceholder();
            String email = homePage.getEmailPlaceholder();

            assertTrue(phone.length() > 0);
            assertTrue(amount.length() > 0);
            assertTrue(email.length() > 0);
        }
    }
    @Test
    void testPaymentFrame() {
        homePage.scrollToBlock();
        homePage.selectTab("Услуги связи");
        homePage.fillForm("297777777", "100", "katy@mail.com");

        PaymentFrame frame = homePage.clickContinue();

        // Просто выводим всё что нашли
        System.out.println("Сумма: " + frame.getTotalAmount());
        System.out.println("Кнопка: " + frame.getButtonAmount());
        System.out.println("Телефон: " + frame.getPhoneNumber());

        // Проверяем поля
        System.out.println("Номер карты: " + frame.hasField("Номер карты"));
        System.out.println("CVC: " + frame.hasField("CVC"));
        System.out.println("Иконки: " + frame.hasIcons());
    }
}