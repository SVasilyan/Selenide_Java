package tests;


import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.step;
import static java.lang.String.format;

@Feature("Common navigations")
@Owner("SVasilyan")
public class HomePageTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("checking navigation to Myths category")
    public void chooseMythsCategory(){

        step("Open Home page ", homePage::openHomePage);
        step("Click on Myths category",  () -> homePage.chooseMythsCategory());

        step("verify that Myths category is opened ",
                () -> homePage.checkIfTextIsPresent(homePage.getTextSelectedCategory(),"Myths"));
    }


    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("checking navigation to City category")
    public void chooseCityCategory(){

        step("Open Home page ", homePage::openHomePage);
        step("Click on Myths category",  () -> homePage.chooseCityCategory());

        step("verify that Myths category is opened ",
                () -> homePage.checkIfTextIsPresent(homePage.getTextSelectedCategory(),"City"));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("checking navigation to Street category")
    public void chooseStreetCategory(){

        step("Open Home page ", homePage::openHomePage);
        step("Click on Myths category",  () -> homePage.chooseStreetCategory());

        step("verify that Myths category is opened ",
                () -> homePage.checkIfTextIsPresent(homePage.getTextSelectedCategory(),"Street"));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("checking navigation to Tech category")
    public void chooseTechCategory(){

        step("Open Home page ", homePage::openHomePage);
        step("Click on Myths category",  () -> homePage.chooseTechCategory());

        step("verify that Myths category is opened ",
                () -> homePage.checkIfTextIsPresent(homePage.getTextSelectedCategory(),"Tech"));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("checking for broken images in Category icons")
    public void CategoryImagesWorkCorrectlyTest(){

        step("Open Home page ", homePage::openHomePage);
        step("Verifying that all category images are clearly visible and not broken",
                () -> homePage.checkCategoryimages());
        }


    @Severity(SeverityLevel.NORMAL)
    @DisplayName("checking if search result titles have the search text in them")
    @ValueSource(strings = {"Features", "bb", "T-50", "salmon"})
    @ParameterizedTest
    public void testSearchImageByText(String text) {

        step("Open Home page ", homePage::openHomePage);

        step(format("Type \"%s\" in the search bar", text), () ->
                homePage.searchImage(text));

        step(format("Check \"%s\" exist in all search results", text),
                () -> homePage.checksSearchResults(text));

    }
}