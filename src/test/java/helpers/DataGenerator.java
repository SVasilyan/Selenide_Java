package helpers;

import com.github.javafaker.Faker;

public class DataGenerator {


    public static String generateRandomString(int maxLength) {
        Faker fakerString = new Faker();
        return fakerString.lorem().characters(maxLength);
    }

    public static String generateRandomUsername() {
        Faker fakeUsername = new Faker();
        return fakeUsername.name().username();
    }

    public static String generateRandomEmail() {
        Faker fakeEmail = new Faker();
        return fakeEmail.internet().emailAddress();
    }

    public static String generateRandomSurname() {
        Faker fakeSurname = new Faker();
        return fakeSurname.name().lastName();
    }

    public static String generateRandomFirstName() {
        Faker fakeFirstName = new Faker();
        return fakeFirstName.name().firstName();
    }

    public static String generateRandomMiddleName() {
        Faker fakeMiddleName = new Faker();
        return fakeMiddleName.name().nameWithMiddle();
    }

    public static String generateRandomPassword() {
        Faker fakePassword = new Faker();
        return fakePassword.internet().password();
    }
}
