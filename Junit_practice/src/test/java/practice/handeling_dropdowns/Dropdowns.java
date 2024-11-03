package practice.handeling_dropdowns;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Dropdowns {
    static WebDriver driver;

    @BeforeAll
    public static void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://testautomationpractice.blogspot.com/");
        Thread.sleep(10000);
    }

    @Test
    public void visit_site() throws InterruptedException {

        WebElement dropdown= driver.findElement(By.xpath("//select[@id='country']"));
        Select select=new Select(dropdown);
//        select.selectByValue("usa");
        select.selectByVisibleText("Germany");

    }

   @Test
    public void find_options(){
       WebElement dropdown= driver.findElement(By.xpath("//select[@id='country']"));
       Select select=new Select(dropdown);
       List<WebElement> option=select.getOptions();

       System.out.println(option.size());

       //printing the options
//       for (int i=0;i<option.size();i++){
//           String name=option.get(i).getText();
//           System.out.println(name);
//           if(name.equals("Canada")){
//
//           }
//
//       }

       //select dropdown based on condition
       for (WebElement op:option){
           String name=op.getText();
           System.out.println(name);
           if (name.equals("Canada")){
               op.click();
           }
       }
    }

    @AfterAll
    public static void close(){
        driver.quit();
    }
}
