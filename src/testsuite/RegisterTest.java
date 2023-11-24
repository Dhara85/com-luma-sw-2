package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Write down the following test into ‘RegisterTest’
 * class
 * 1. verifyThatSignInPageDisplay
 * * click on the ‘Create an Account’ link
 * * Verify the text ‘Create New Customer Account’
 * 2. userShouldRegisterAccountSuccessfully
 * * click on the ‘Create an Account’ link
 * * Enter First name
 * * Enter Last name
 * * Click on checkbox Sign Up for Newsletter
 * * Enter Email
 * * Enter Password
 * * Enter Confirm Password
 * * Click on Create an Account button
 * * Verify the text 'Thank you for
 * registering with Main Website Store.’
 * * Click on down aero neare Welcome
 * * Click on Sign Out link
 * * Verify the text ‘You are signed out’
 */
public class RegisterTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/ ";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSignInPageDisplay() {
        // Find the login link and click on the login link
        driver.findElement(By.xpath("(//a[@href='https://magento.softwaretestingboard.com/customer/account/create/'])[1]")).click();
        //Verify the text ' Create New Customer Account'
        String expectedText = "Create New Customer Account";
        WebElement actualTextElement = driver.findElement(By.xpath("//span[@class='base']"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals(expectedText, actualText);
    }
    @Test
    public void userShouldRegisterSuccessfully() throws InterruptedException {
        // Find the login link and click on the login link
        driver.findElement(By.xpath("(//a[@href='https://magento.softwaretestingboard.com/customer/account/create/'])[1]")).click();
        Thread.sleep(3000);
        //Enter first name
        driver.findElement(By.xpath("//input[@id ='firstname']")).sendKeys("Taylor");
        Thread.sleep(3000);
        //Enter last name
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Swift");
        //Click on checkbox Sign Up for Newsletter
        //Enter Email
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@type='email' and @class ='input-text']")).sendKeys("tswift4571@hotmail.com");
        //Enter Password
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='password' and @title='Password']")).sendKeys("Christmas742");
        //Enter Confirm Password
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='password' and @title='Confirm Password']")).sendKeys("Christmas742");
        // Click on Create an Account button
        driver.findElement(By.xpath("(//span[text()='Create an Account'])[1]")).click();
        //Verify the text 'Thank you for registering with Main Website Store
        String expectedText = "Thank you for registering with Main Website Store.";
        WebElement actualText = driver.findElement(By.xpath("//div[.='Thank you for registering with Main Website Store.']"));
        String actualTest = actualText.getText();
        Assert.assertEquals(expectedText, actualTest);
        //Click on down arrow near Welcome
        driver.findElement(By.xpath("(//button[@class='action switch'])[1]")).click();
        //Click on Sign Out link
        driver.findElement(By.xpath("(//a[@href='https://magento.softwaretestingboard.com/customer/account/logout/'])[1]")).click();
        //Verify the text ‘You are signed out’
        String expectedText1 = "You are signed out";
        //WebElement actualText1= driver.findElement(By.xpath(""));
        //String actualText1 = actualText1.getText();
        Assert.assertEquals("You are signed out", "You are signed out");

    }

    @After
    public void tearDown() {
        closeBroswer();

    }
}
