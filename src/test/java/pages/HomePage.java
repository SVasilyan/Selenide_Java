package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.model.Status;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage extends BasePage {

    public HomePage openHomePage() {
        open("/");
        return this;
    }

    private final SelenideElement tbTerm = $("#tbTerm"),
            btnSearch = $("#btnSearch"),
            btnResetSearchCriteria = $("#btnResetSearchCriteria"),
            tbRatingFrom = $("#tbRatingFrom"),
            tbRatingTo = $("#tbRatingTo"),
            tbPriceFrom = $("#tbPriceFrom"),
            tbPriceTo = $("#tbPriceTo"),
            selectedCategory = $("#tSelectedCategoryTitle"),
            ctgEmpty = $x("//*[@id='1']"),
            ctgFull = $x("//*[@id='2']"),
            ctgMyth = $x("//*[@id='3']"),
            ctgCity = $x("//*[@id='4']"),
            ctgStreet = $x("//*[@id='5']"),
            ctgTech = $x("//*[@id='6']"),
            ctgWhoUN = $x("//*[@id='7']"),
            ctgZinc = $x("//*[@id='8']"),
            ctgFantasy = $x("//*[@id='9']"),
            ctgLatin = $x("//*[@id='10']"),
            ctgDesign = $x("//*[@id='11']"),
            ctgKorat = $x("//*[@id='12']"),
            ctgEskimo = $x("//*[@id='13']");

    private final ElementsCollection productTitles = $$(".product-card__title"),
            categoryElements = $$("[id*='category'] img");

    public void chooseMythsCategory() {
        ctgMyth.click();

    }

    public void chooseCityCategory() {
        ctgCity.click();
    }

    public void chooseTechCategory() {
        ctgTech.click();
    }

    public void chooseStreetCategory() {
        ctgStreet.click();
    }

    public SelenideElement getTextSelectedCategory() {
        return selectedCategory;
    }


    public void searchImage(String text) {
        tbTerm.sendKeys(text);
        btnSearch.click();
    }

    public void resetSearch() {
        btnResetSearchCriteria.click();
    }

    public void typeInSearchQuery(String text) {
        tbTerm.sendKeys(text);
    }

    public String getSearchInput() {
        return tbTerm.getAttribute("value");
    }

    public List<SelenideElement> getProductTitles() {
        List<SelenideElement> attributeValues = new ArrayList<>();
        for (SelenideElement title : productTitles) {
            attributeValues.add(title);
        }

        return attributeValues;
    }

    public List<String> getCategoryImages() {
        List<String> imageLinks = new ArrayList<>();
        for (WebElement category : categoryElements) {
            imageLinks.add(category.getAttribute("src"));
        }
        return imageLinks;
    }

    public void checkCategoryimages() {
        List<String> imageLinks = getCategoryImages();
        for (String imgURL : imageLinks) {
            try {
                // Verify if the image URL returns a valid response
                URL url = new URL(imgURL);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();

                // Check the response code
                int responseCode = connection.getResponseCode();
                assertEquals(responseCode, 200, url +
                        " should return responseCode 200, otherwise image is broken");

                connection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void checksSearchResults(String text) {
        List<SelenideElement> attributeValues = getProductTitles();
        for (SelenideElement searchResult : attributeValues) {
            searchResult.shouldHave(Condition.text(text));
        }
    }
}
