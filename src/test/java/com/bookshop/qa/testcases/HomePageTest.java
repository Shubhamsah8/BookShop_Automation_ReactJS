package com.bookshop.qa.testcases;


import com.bookshop.qa.baseclass.BaseClass;
import com.bookshop.qa.pages.HomePage;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


@Listeners(com.bookshop.qa.listener.TestListener.class)
public class HomePageTest extends BaseClass {
    public HomePage homePage;

    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        try {
            initialization();
            homePage = new HomePage();
        } catch (WebDriverException e){
            e.printStackTrace();
        }
    }

    @Test(priority = 1)
    @Description("Verify search functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Search")
    public void searchBookTest() throws InterruptedException {
        Thread.sleep(5000);
        homePage.searchBook(properties.getProperty("bookname"));
        Thread.sleep(2000);
        homePage.cart();
        Thread.sleep(5000);

        WebElement bookElement = driver.findElement(By.xpath("//h6[text()='Bleach Volume 1']"));
        String actualBookTitle = bookElement.getText();
        Assert.assertEquals(actualBookTitle, "Bleach Volume 1", "The actual book title does not match the expected one.");
    }

}
