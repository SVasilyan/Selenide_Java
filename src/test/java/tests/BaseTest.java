package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.DriverConfig;
import config.DriverProvider;
import helpers.Attach;
import helpers.PropertyReader;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

public class    BaseTest {

    static HomePage homePage = new HomePage();
    static LoginPage loginPage = new LoginPage();
    static RegistrationPage registrationPage = new RegistrationPage();

    @BeforeEach
    void setLogger() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeAll
    static void beforeAll() {
        DriverProvider.setConfig();
    }


    @AfterEach
    void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Selenide.closeWebDriver();
    }
}


