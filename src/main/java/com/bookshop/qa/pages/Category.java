package com.bookshop.qa.pages;

import com.bookshop.qa.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Category extends BaseClass {

    @FindBy(xpath = "//div[@title='The Story of My Life'")
    WebElement helenKeller;

    @FindBy(xpath = "//*[@id=\"pro\"]/div/div[2]/button")
    WebElement addToCartHK;

    public Category() {
        PageFactory.initElements(driver, this);
    }

    public void helenKellerBook(){
        int numberOfClicks = 5;

        for (int i = 0; i < numberOfClicks; i++) {
            addToCartHK.click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
