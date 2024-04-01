package com.bookshop.qa.testcases;

import com.bookshop.qa.baseclass.BaseClass;
import com.bookshop.qa.pages.Biography;
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

public class CategoryTest extends BaseClass {
    public HomePage homePage;
    public Biography biography;

    public CategoryTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){

    }
}
