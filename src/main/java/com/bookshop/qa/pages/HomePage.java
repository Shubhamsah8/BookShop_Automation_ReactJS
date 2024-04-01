package com.bookshop.qa.pages;

import com.bookshop.qa.baseclass.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

    @FindBy(xpath = "//input[@placeholder='Which book are you looking for?']")
    WebElement searchBar;

    @FindBy(xpath = "//a[@aria-label='Show cart items']")
    WebElement cart;

    @FindBy(xpath = "//*[@id=\"pro\"]/div/div[2]/button")
    WebElement addToCart;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/main/div[3]/div/div[2]/a/button")
    WebElement biographyCategory;


    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void searchBook(String bookname) throws InterruptedException {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", searchBar);
        searchBar.sendKeys(bookname);
        Thread.sleep(2000);
        addToCart.click();
    }

    public Category categories() throws InterruptedException{

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", biographyCategory);
        Thread.sleep(2000);
        biographyCategory.click();

        return new Category();
    }

    public void cart(){
        cart.click();

        new Cart();
    }
}
