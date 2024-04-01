package com.bookshop.qa.testcases;

import com.bookshop.qa.baseclass.BaseClass;
import com.bookshop.qa.pages.Category;
import com.bookshop.qa.pages.HomePage;
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

public class CategoryTest extends BaseClass {
    public HomePage homePage;
    public Category category;

    public CategoryTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        try {
            initialization();
            homePage = new HomePage();
            Thread.sleep(5000);
            category = homePage.categories();
        } catch (WebDriverException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 2)
    @Description("Verify category functionality")
    @Severity(SeverityLevel.NORMAL)
    @Story("Category")
    public void categoryTest() throws InterruptedException {
        Thread.sleep(5000);
        category.helenKellerBook();
        Thread.sleep(2000);
        homePage.cart();
        Thread.sleep(5000);

        WebElement helenKeller = driver.findElement(By.xpath("//h6[text()='The Story of My Life']"));
        String bookTitle = helenKeller.getText();
        Assert.assertEquals(bookTitle, "The Story of My Life", "The actual book title does not match the expected one.");

        WebElement helenBookCount = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/div[3]/div/p"));
        String bookCount = helenBookCount.getText();
        Assert.assertEquals(bookCount, " 5", "The actual book count does not match the expected one.");
    }
}
