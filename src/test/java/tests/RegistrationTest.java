package tests;


import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



import static io.qameta.allure.Allure.step;

@Feature("Login/Registration")
@Story("Create registration test for regular user, GQ-787")
@Owner("SVasilyan")
public class RegistrationTest extends BaseTest{

   private static final String SUCCESSFUL_REGISTRATION_MESSAGE_PREFIX =
           "User has been registered successfully: ";

   @Test
   @Severity(SeverityLevel.CRITICAL)
   @DisplayName("Checking if the users can sign up to the system")
   public void testRegularUserIsAbleToLogin(){

      step("Open Registration page to register new regular user ", registrationPage::openRegistrationPage);

      step("Type random value in the 'Loginname' field ", registrationPage::typeRandomLoginName);
      step("Type random value in the 'Surname' field ", registrationPage::typeRandomSurname);
      step("Type random value in the 'Firstname' field ", registrationPage::typeRandomFirstName);
      step("Type random value in the 'Patronim' field ", registrationPage::typeRandomPatronim);
      step("Type random value in the 'Email' field ", registrationPage::typeRandomEmail);
      step("Type random value in the 'Password' field ", registrationPage::typeRandomPassword);

      step("Click Register user button", registrationPage::clickRegisterButton);

      step("Сheck regular user can register successfully by checking if we get the right success message", () ->
               registrationPage.checkIfTextIsPresent(registrationPage.getMessageWebElement(), SUCCESSFUL_REGISTRATION_MESSAGE_PREFIX));
   }

}




