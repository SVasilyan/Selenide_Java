package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import config.DriverProvider;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginPage extends BasePage{

    public LoginPage openLoginPage() {
        open("/login");
        return this;
    }

    private final SelenideElement txtLoginname = $("#tfLoginname"),
            txtPassword = $("#tfPassword"),
            btnSubmitLogin = $("#btnSubmitLogin"),
            btnGoToHome = $("#btnSubmitGoToHome"),
            lblError = $x("//div[@class='login']//p[contains(@style, 'color: #FF1C19')]"),
            btnGoToRegistration = $("#btnSubmitGoToRegistration");


    public HomePage login(String username, String password) {
        tryLogin(username, password);
        return new HomePage();
    }

    public void tryLogin(String username, String password) {
        txtLoginname.clear();
        txtLoginname.sendKeys(username);

        txtPassword.clear();
        txtPassword.sendKeys(password);

        btnSubmitLogin.click();
    }

    public HomePage gotoHome() {
        btnGoToHome.click();

        return new HomePage();
    }

    public String getErrorMessage() {
        return lblError.getText();
    }



    public void loginAsRegularUser() {
        login(DriverProvider.driver.getUserName(), DriverProvider.driver.getUserPassword());
        btnSubmitLogin.click();
    }

    public void loginAsAdmin() {
        login(DriverProvider.driver.getAdminName(), DriverProvider.driver.getAdminPassword());
        btnSubmitLogin.click();
    }

    public SelenideElement getErrorWebElement() {
        return lblError;
    }

}
