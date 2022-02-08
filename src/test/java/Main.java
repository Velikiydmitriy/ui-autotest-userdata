import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    WebDriver driver;
    @BeforeClass
    public static void mainPrecondition(){
        final String path = String.format("%s/bin/chromedriver.exe", System.getProperty("user.dir"));
        System.setProperty("webdriver.chrome.driver",path);
    }

    @Before
    public void precondition(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void firstTest(){

        driver.get("https://user-data.hillel.it/html/registration.html");
        driver.findElement(By.className("registration")).click();
        driver.findElement(By.id("first_name")).sendKeys("Dimon");
        driver.findElement(By.id("last_name")).sendKeys("Velikiy");
        driver.findElement(By.id("field_work_phone")).sendKeys("380671181188");
        driver.findElement(By.id("field_phone")).sendKeys("380639996781");
        driver.findElement(By.id("field_email")).sendKeys("1ll4a26@google.com");
        driver.findElement(By.id("field_password")).sendKeys("$2a$08$ySIU0kG");
        driver.findElement(By.id("male")).click();
        driver.findElement(By.id("position")).click();
        driver.findElement(By.id("position")).sendKeys("qa");
        driver.findElement(By.id("button_account")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();

        List<WebElement> authButton = driver.findElements(By.className("authorization"));
        authButton.get(1).click();


        driver.findElement(By.id("email")).sendKeys("1ll4a26@google.com");
        driver.findElement(By.id("password")).sendKeys("$2a$08$ySIU0kG");
        driver.findElement(By.className("login_button")).click();

        driver.findElement(By.id("employees")).click();
        driver.findElement(By.id("mobile_phone")).sendKeys("380639996781");
        driver.findElement(By.id("search")).click();


    }
    @After
    public void postCondition() throws InterruptedException {
        Thread.sleep(9000);
        driver.quit();
    }
}
