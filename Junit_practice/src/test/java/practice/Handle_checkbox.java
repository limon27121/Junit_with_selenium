package practice;

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
public class Handle_checkbox {
    WebDriver driver;

    @BeforeAll
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void visit_site() throws InterruptedException {
        driver.get("https://testautomationpractice.blogspot.com/");
       driver.findElement(By.id("name")).sendKeys("limon");
        driver.findElement(By.xpath(" //input[@id='email']")).sendKeys("limon@gmail.com");
        driver.findElement(By.xpath(" //input[@id='phone']")).sendKeys("01623692274");
        driver.findElement(By.id("male")).click();
        List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
        System.out.println(checkboxes.size());

        //all checkbox select

//        for(int i=0;i<checkboxes.size();i++){
//            checkboxes.get(i).click();
//
//        }


        //last three checkbox select

        for (int i=4;i<checkboxes.size();i++){
            checkboxes.get(i).click();
        }
        Thread.sleep(10000);
    }

    @AfterAll
    public void close(){
        driver.quit();
    }

}
