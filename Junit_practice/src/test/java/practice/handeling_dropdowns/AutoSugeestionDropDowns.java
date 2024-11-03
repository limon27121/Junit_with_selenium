package practice.handeling_dropdowns;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AutoSugeestionDropDowns {
    static WebDriver driver;

    @BeforeAll
    public static void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.google.co.uk/");
        Thread.sleep(10000);
    }

    @Test
    public void dropdown() throws InterruptedException {
        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("selenium");
        List<WebElement>options=driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='presentation']//span"));
        int size=options.size();
        for (int i=0;i<size;i++){
            String op=options.get(i).getText();
           if(op.equals("selenium")){
               options.get(i).click();
               break;
           }

        }
          Thread.sleep(200);
        driver.findElement(By.xpath("//a[@href='https://www.selenium.dev/']//h3[@class='LC20lb MBeuO DKV0Md'][normalize-space()='Selenium']")).click();
    }
//    @AfterAll
//    public static void close(){
//        driver.quit();
//    }
}