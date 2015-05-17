package ranorex.csenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class BrowserFactory {

    public static WebDriver createDriver(){
        String browserName = System.getProperty("browserName").toLowerCase();
        switch(browserName) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver","C:\\Users\\Gatto\\IdeaProjects\\com.ranorex\\src\\main\\java\\ranorex\\csenarios\\Drivers\\chromedriver.exe");
                System.out.println(System.getProperty("webdriver.chrome.driver"));
                return new ChromeDriver();
            case "firefox":
                return new FirefoxDriver();
            case "htmlunitdriver":
                return new HtmlUnitDriver();
            default: return  new FirefoxDriver();
        }
    }
}