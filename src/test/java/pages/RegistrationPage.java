package pages;

import com.codeborne.selenide.SelenideElement;
import helpers.DataGenerator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.crypto.Data;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage extends BasePage {

    public RegistrationPage openRegistrationPage() {
        open("/registration");
        return this;
    }


    private final SelenideElement tbLoginName = $("#tbLoginName"),
            tbSurname = $("#tbSurname"),
            tbFirstName = $("#tbFirstName"),
            tbMiddleName = $("#tbMiddleName"),
            tbEmail = $("#tbEmail"),
            tbPassword = $("#tbPassword"),
            btnGoToHome = $("#btnSubmitGoToHome"),
            tSuccessMessage = $("#tSuccessMessage"),
            btnRegister = $("#btnRegister");


    public void clickRegisterButton() {
        btnRegister.click();
    }

    public void typeInLoginname(String value) {
        typeIn(value, tbLoginName);
    }

    public void typeInSurname(String value) {
        typeIn(value, tbSurname);
    }

    public void typeInFirstname(String value) {
        typeIn(value, tbFirstName);
    }

    public void typeInPatronim(String value) {
        typeIn(value, tbMiddleName);
    }

    public void typeInEmail(String value) {
        typeIn(value, tbEmail);
    }

    public void typeInPassword(String value) {
        typeIn(value, tbPassword);
    }

    private void typeIn(String value, WebElement targetElement) {
        targetElement.clear();
        targetElement.sendKeys(value);
    }


    public String getMessageText() {
        return tSuccessMessage.getText();
    }

    public SelenideElement getMessageWebElement() {
        return tSuccessMessage;
    }



    public void typeRandomLoginName() {
        typeIn(DataGenerator.generateRandomUsername(), tbLoginName);
    }

    public void typeRandomSurname() {
        typeIn(DataGenerator.generateRandomSurname(), tbSurname);
    }

    public void typeRandomFirstName() {
        typeIn(DataGenerator.generateRandomFirstName(), tbFirstName);
    }

    public void typeRandomPatronim() {
        typeIn(DataGenerator.generateRandomMiddleName(), tbMiddleName);
    }

    public void typeRandomEmail() {
        typeIn(DataGenerator.generateRandomEmail(), tbEmail);
    }

    public void typeRandomPassword() {
        typeIn(DataGenerator.generateRandomPassword(), tbPassword);
    }
}