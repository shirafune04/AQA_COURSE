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

            assertFalse(phone.isEmpty());
            assertFalse(amount.isEmpty());
            assertFalse(email.isEmpty());
        }
    }
    @Test
    void testPaymentFrame() throws InterruptedException {
        homePage.scrollToBlock();
        homePage.selectTab("Услуги связи");
        homePage.fillForm("297777777", "100", "katy@mail.com");

        PaymentFrame frame = homePage.clickContinue();
    }
}