package practice.WebTables;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class StaticTable {

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
    public  void Table_row(){
      List<WebElement> rows=driver.findElements(By.xpath("//table[@name='BookTable']//tbody//tr"));
        System.out.println(rows.size());
    }

    @Test
    public void Table_col(){
        List<WebElement> cols=driver.findElements(By.xpath("//table[@name='BookTable']//tbody//tr//th"));
        System.out.println(cols.size());
    }

    @Test
    public void read_specific_data(){
        String data=driver.findElement(By.xpath("//table[@name='BookTable']//tbody//tr[5]//td[1]")).getText();
        System.out.println(data);

    }

    @Test
    public void read_all_data_from_table1() {
        List<WebElement> rows = driver.findElements(By.xpath("//table[@name='BookTable']//tbody//tr"));
        int row_size = rows.size();

        for (int r = 2; r <= row_size; r++) { // start from 2 to skip header row
            List<WebElement> cols = driver.findElements(By.xpath("//table[@name='BookTable']//tbody//tr[" + r + "]//td"));
            for (int c = 1; c <= cols.size(); c++) {
                String table_data = driver.findElement(By.xpath("//table[@name='BookTable']//tbody//tr[" + r + "]//td[" + c + "]")).getText();
                System.out.print(table_data + " | ");
            }
            System.out.println(); // new line after each row
        }
    }

     @Test
    public void print_data_based_on_condition(){
         List<WebElement> rows = driver.findElements(By.xpath("//table[@name='BookTable']//tbody//tr"));
         int row_size = rows.size();
         for (int r=2;r<=row_size;r++){
             String author=driver.findElement(By.xpath("//table[@name='BookTable']//tbody//tr[" + r + "]//td[2]")).getText();
             if (author.equals("Mukesh")){
                 String book_name=driver.findElement(By.xpath("//table[@name='BookTable']//tbody//tr[" + r + "]//td[1]")).getText();
                 System.out.println(book_name);
             }
         }
     }

}
