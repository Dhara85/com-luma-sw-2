package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * 5.Write down the following test into ‘SaleTest’ class
 * 1. verifyTheTotalItemsDisplayedOnTheWomens
 * JacketsPage()
 * * Click on ‘Sale’ Menu tab
 * * Click on ‘Jackets’ link on left side
 * under WOMEN’S DEAL Category
 * * Verify the text ‘Jackets’ is displayed
 * * Count the Total Item Displayed on Page
 * and print the name of all items into
 * console.
 * * Verify total 12 Items displayed on page.
 */
public class SaleTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/ ";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomensJacketsPage(){
        // Click on Sale Menu tab
        driver.findElement(By.xpath("//span[text()='Sale']")).click();
        //Click on Jackets link on left side under Women's Deal Category
        driver.findElement(By.xpath("(//a[text()='Jackets'])[1]")).click();
        //Verify the text 'Jackets' is displayed
        String expectedText = "Jackets";
        WebElement actualTextElement = driver.findElement(By.xpath("//span[@class='base']"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals(expectedText, actualText);
        //Count the total Item Displayed on page and print the name of all items into console
        List<WebElement> items = driver.findElements(By.xpath("//li[@class = 'item product product-item']"));
        //Verify total 12 Items displayed on page
        List<WebElement> itemsName = driver.findElements(By.xpath("//a[@class = 'product-item-link']"));
        System.out.println("Total Items : "+items.size());

        for(WebElement list : itemsName){
            System.out.println(list.getText());
        }

        int count = 12;
        int actualCount = items.size();
        Assert.assertEquals(count,actualCount);
    }
}
