package ranorex.csenarios;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import ranorex.csenarios.RanorexPageObject.RanorexVipPage;
import java.util.List;
import static org.junit.Assert.assertEquals;


public class RanorexAddingIT {

    //Arrange
    String expectedFirstName = "Cat";
    String expectedLastName = "Catsvill";
    String expectedGender = "Male";
    String expectedGender2 = "Female";
    String expectedCategory = "Music";
    String expectedCategory2 = "Sport";
    String expectedFirstName2 = "Dog";
    String expectedLastName2 = "Doggy";

    static private RanorexVipPage page = new RanorexVipPage();

    @AfterClass
    public static void quitFromBrowser(){
        page.quitSite();
    }

    @After
    public void userRefreshRanorexPage(){
        page.refreshPage();
    }

    @Test
    public void userAddPersonsToRanorex(){

        //Arrange
        int numberOfLineForFistPerson = 1;
        int numberOfLineForSecondPerson = 2;

        //Act
        page.openPage();
        page.getFirstNameField().sendKeys(expectedFirstName);
        page.getLastNameField().sendKeys(expectedLastName);

        List<WebElement> listOfElements = page.getCategoryField();

        page.getCategoryArrayList(listOfElements, "Music").click();
        page.getGenderRadioBoxByName("male").click();
        page.getAddButton().click();

        page.getFirstNameField().sendKeys(expectedFirstName2);
        page.getLastNameField().sendKeys(expectedLastName2);
        page.getCategoryArrayList(listOfElements, "Sport").click();
        page.getGenderRadioBoxByName("female").click();
        page.getAddButton().click();

        //Assert
        assertEquals(page.getFirstNameValueOfPerson(numberOfLineForFistPerson).getText(), expectedFirstName);
        assertEquals(page.getLastNameValueOfPerson(numberOfLineForFistPerson).getText(), expectedLastName);
        assertEquals(page.getGenderValueOfPerson(numberOfLineForFistPerson).getText(), expectedGender);
        assertEquals(page.getCategoryValueOfPerson(numberOfLineForFistPerson).getText(), expectedCategory);
        assertEquals(page.getFirstNameValueOfPerson(numberOfLineForSecondPerson).getText(), expectedFirstName2);
        assertEquals(page.getLastNameValueOfPerson(numberOfLineForSecondPerson).getText(), expectedLastName2);
        assertEquals(page.getGenderValueOfPerson(numberOfLineForSecondPerson).getText(), expectedGender2);
        assertEquals(page.getCategoryValueOfPerson(numberOfLineForSecondPerson).getText(), expectedCategory2);
    }

    @Test
    public void userDeletePersonsToRanorex(){

        //Arrange
        int numberOfLineForFistPerson = 1;
        int expectedCountOfLinesAfterSecondDelete = 1;
        int expectedCountOfLinesAfterFirstDelete = 2;

        //Act
        page.openPage();
        page.getFirstNameField().sendKeys(expectedFirstName);
        page.getLastNameField().sendKeys(expectedLastName);

        List<WebElement> listOfElements = page.getCategoryField();

        page.getCategoryArrayList(listOfElements, "Music").click();
        page.getGenderRadioBoxByName("male").click();
        page.getAddButton().click();
        page.getFirstNameField().sendKeys(expectedFirstName2);
        page.getLastNameField().sendKeys(expectedLastName2);

        page.getCategoryArrayList(listOfElements, "Sport").click();
        page.getGenderRadioBoxByName("female").click();
        page.getAddButton().click();
        page.getTableRadioButton(numberOfLineForFistPerson).click();
        page.getDeleteButton().click();

        int actualCountOfLinesAfterFirstDelete = page.getAllTableElements().size();

        page.getTableRadioButton(numberOfLineForFistPerson).click();
        page.getDeleteButton().click();

        int actualCountOfLinesAfterSecondDelete = page.getAllTableElements().size();

        //Assert
        assertEquals(actualCountOfLinesAfterFirstDelete, expectedCountOfLinesAfterFirstDelete);
        assertEquals(actualCountOfLinesAfterSecondDelete, expectedCountOfLinesAfterSecondDelete);
    }
}
