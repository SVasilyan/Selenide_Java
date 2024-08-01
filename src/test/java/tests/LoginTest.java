package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.qameta.allure.Allure.step;

@Feature("Login/Registration")
@Story("Create negative test cases for login functionality, GQ-788")
@Owner("SVasilyan")
public class LoginTest extends BaseTest{

    @ParameterizedTest
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Checking that system doesn't allow users with invalid credentials")
    @CsvSource({
            "qq, qwe",
            "qw, 123",
            "za, az",
            "qwer, tyuioiop"
    })
    public void testInvalidCredentialsNotAbleToLogin(String name, String password){


        step("Open Login page ", loginPage::openLoginPage);
        step("typing non-existing login and password in the input fields",
                () -> loginPage.tryLogin(name, password));

        step("verify that System doesn't allow to enter with invalid credentials and error message is shown properly",
                () -> loginPage.checkIfTextIsPresent(loginPage.getErrorWebElement(),"Login name or Password invalid, please verify"));


    }
}


