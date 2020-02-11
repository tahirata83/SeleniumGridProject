import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class GroupThree {

    private WebDriver driver;
    private WebDriverWait wait;

    @Parameters({"browser"})
    @BeforeClass
    public void setup(String browser) throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName(browser);
        cap.setPlatform( Platform.WIN10 );

        cap.setCapability("name", "Web Driver demo Test");
        URL url = new URL("https://tahirata:52a53485-a1b6-4a7f-98da-562ac3255d6e@ondemand.eu-central-1.saucelabs.com:443/wd/hub");

        driver = new RemoteWebDriver(url, cap);

    }
    public void setup1(String browser) throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName(browser);
        cap.setPlatform( Platform.MAC );

        cap.setCapability("name", "Web Driver demo Test");
        URL url = new URL("https://tahirata:52a53485-a1b6-4a7f-98da-562ac3255d6e@ondemand.eu-central-1.saucelabs.com:443/wd/hub");

        driver = new RemoteWebDriver(url, cap);

    }

    @Test
    @Parameters({"username", "password"})
    public void test(String username, String password) {
        driver.get("https://test-basqar.mersys.io/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.cssSelector("[formcontrolname=\"username\"]")).sendKeys(username);
        driver.findElement(By.cssSelector("[formcontrolname=\"password\"]")).sendKeys(password);
        driver.findElement(By.cssSelector("button[aria-label=\"LOGIN\"]")).click();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

        @Test

    public void test1() throws InterruptedException {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            WebElement ThreeLine = driver.findElement(By.xpath("//button[@class='navbar-toggle-button mat-icon-button mat-button-base ng-star-inserted']//*[@class='svg-inline--fa fa-bars fa-w-14']"));
            ThreeLine.click();

            //Thread.sleep(2000);

            WebElement HumanResources = driver.findElement(By.cssSelector("fuse-navigation .group-items > .nav-item:nth-child(4)"));
            HumanResources.click();

          //  Thread.sleep(2000);

            WebElement Setup = driver.findElement(By.xpath("//span[@class='nav-link-title ng-tns-c30-21 ng-star-inserted']"));
            Setup.click();
           // Thread.sleep(2000);


            WebElement PositionSalary=driver.findElement(By.xpath("//span[text()='Position Salary']"));
            PositionSalary.click();


            WebElement PlusSign = driver.findElement(By.xpath("//button[@class='mat-button mat-icon-button mat-button-base']"));
            PlusSign.click();


          WebElement names = driver.findElement(By.xpath("//ms-dialog-content//ms-text-field[@placeholder='GENERAL.FIELD.NAME']//input"));

           names.sendKeys("tata2");

           WebElement save= driver.findElement(By.xpath("//span[text()='Save']"));
            save.click();

            WebElement delete= driver.findElement(By.xpath("//td[contains(text(), 'tata2')]/..//ms-delete-button"));
            delete.click();
            WebElement yes= driver.findElement(By.xpath("//span[contains(text(),'Yes')]"));
            yes.click();
        }



        @AfterClass
        public void quit () {
            driver.quit();
        }

    }
