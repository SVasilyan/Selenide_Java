package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class BasePage {

    private final SelenideElement aHome = $("#aHome"),
            aAdminHut = $("#aAdminHut"),
            aImages = $("#aImages"),
            aAddImage = $("#aAddImage"),
            aAddCategory = $("#aAddCategory"),
            aUsers = $("#aUsers"),
            aAddUser = $("#aAddUser"),
            aUsersStuffMenuHeader = $("#aUsersStuffMenuHeader"),
            aUsrCards = $("#aUsrCards"),
            aUsrAddCard = $("#aUsrAddCard"),
            aToCartTop = $("#aToCartTop"),
            spCartTopMsg = $("#spCartTopMsg"),
            sploggedInName = $("#sploggedInName"),
            aLogoutTop = $("#aLogoutTop"),
            aLogoutBottom = $("#aLogout"),
            spanRole = $x("//*[@id=\"navbar\"]/ul[2]/li/span/span[2]");


    public String getCurrentUserName() {
        return sploggedInName.getText();
    }

    public WebElement getLoggedInName() {
        return sploggedInName;
    }

    public String getCurrentUserRole() {
        return spanRole.getText();
    }

    public void clickLogout() {
        aLogoutTop.click();
    }

    public void checkIfTextIsPresent(SelenideElement element, String expectText) {
        element.shouldHave(Condition.text(expectText));

    }
}





