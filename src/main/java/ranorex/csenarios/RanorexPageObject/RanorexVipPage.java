package ranorex.csenarios.RanorexPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ranorex.csenarios.BrowserFactory;
import java.util.List;

public class RanorexVipPage {

    public static final String ADDRESS_PAGE = "http://www.ranorex.com/web-testing-examples/vip/";

    public WebDriver webDriver = BrowserFactory.createDriver();

    public void openPage(){
        webDriver.get(ADDRESS_PAGE);
    }

    public void refreshPage(){
        webDriver.navigate().refresh();
    }

    public WebElement getFirstNameField(){
        return webDriver.findElement(By.id("FirstName"));
    }

    public WebElement getLastNameField(){
        return webDriver.findElement(By.id("LastName"));
    }

    public List<WebElement> getCategoryField(){
        return webDriver.findElements(By.xpath("//*[@id = 'Category']/*"));
    }

    public WebElement getGenderRadioBoxByName(String name){
        return webDriver.findElement(By.xpath("//*[@id = 'Gender' and @value = " + "'" + name + "'" + "]"));
    }

    public WebElement getAddButton(){
        return webDriver.findElement(By.id("Add"));
    }

    public WebElement getDeleteButton(){
        return webDriver.findElement(By.id("Delete"));
    }

    public WebElement getCategoryArrayList(List<WebElement> categoryList, String category){
        WebElement returnElement = null;
        for(WebElement element : categoryList) {
            if (element.getAttribute("value").equals(category)){
                returnElement = element;
            }
        }
        return returnElement;
    }

    public void quitSite(){
        webDriver.quit();
    }

    public WebElement getFirstNameValueOfPerson(int numberOfLine){
        return webDriver.findElement(By.xpath("//*[@id='VIPs']/tbody/tr["+ (numberOfLine + 1) +"]/td[2]"));
    }

    public WebElement getLastNameValueOfPerson(int numberOfLine){
        return webDriver.findElement(By.xpath("//*[@id='VIPs']/tbody/tr["+ (numberOfLine + 1) +"]/td[3]"));
    }

    public WebElement getGenderValueOfPerson(int numberOfLine){
        return webDriver.findElement(By.xpath("//*[@id='VIPs']/tbody/tr["+ (numberOfLine + 1) +"]/td[4]"));
    }

    public WebElement getCategoryValueOfPerson(int numberOfLine){
        return webDriver.findElement(By.xpath("//*[@id='VIPs']/tbody/tr["+ (numberOfLine + 1) +"]/td[5]"));
    }

    public WebElement getTableRadioButton(int numberOfLine){
        return webDriver.findElement(By.xpath("//*[@id='VIPs']/tbody/tr[" + (numberOfLine + 1) + "]/td[1]/*[@id = 'VIP']"));
    }

    public List<WebElement> getAllTableElements(){
        return webDriver.findElements(By.xpath("//*[@id='VIPs']/tbody/tr"));
    }
}
