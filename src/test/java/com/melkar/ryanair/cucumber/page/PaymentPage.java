package com.melkar.ryanair.cucumber.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static java.lang.Thread.sleep;

public class PaymentPage extends PageObject {

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void fillPassengerInfo() throws InterruptedException {
        List<WebElement> elements = driver.findElements(By.cssSelector("[ng-model='$ctrl.pax.name.title']"));
        for (WebElement elemenet : elements) {
            Select select = new Select(elemenet);
            select.selectByVisibleText("Ms");
        }
        List<WebElement> name = driver.findElements(By.cssSelector("input[placeholder='e.g. John']"));
        name.get(0).sendKeys("Karolina");
        name.get(1).sendKeys("Magdalena");
        sleep(3000);
        List<WebElement> surname = driver.findElements(By.cssSelector("input[placeholder='e.g. Smith']"));
        surname.get(0).sendKeys("Smith");
        surname.get(1).sendKeys("Bolland");

    }

    public void fillCardInfo() throws InterruptedException {
        driver.findElement(By.cssSelector("input[placeholder='Enter card number']")).sendKeys("371621717968329");
        sleep(3000);


        List<WebElement> cardType = driver.findElements(By.cssSelector("[ng-model='$ctrl.cardModel.cardType']"));
        for (WebElement card : cardType) {
            Select select = new Select(card);
            select.selectByValue("AX");
        }
        sleep(2000);

        Select expieryDate = new Select(driver.findElement(By.name("expiryMonth")));
        expieryDate.selectByValue("number:3");
        Select expieryYear = new Select(driver.findElement(By.name("expiryYear")));
        expieryYear.selectByValue("number:2021");
        sleep(3000);
        driver.findElement(By.name("securityCode")).sendKeys("3865");
        driver.findElement(By.cssSelector("input[placeholder='e.g. John Smith']")).sendKeys("Karolina Smith");
    }

    public void fillBillingAddress() {
        driver.findElement(By.cssSelector("input[placeholder='e.g. 21 Sun Lane']")).sendKeys("21 Sun Lane");
        driver.findElement(By.cssSelector("input[placeholder='e.g. Sun Land']")).sendKeys("Sun Land");
        driver.findElement(By.cssSelector("input[placeholder='e.g. Dublin']")).sendKeys("Dublin");
        driver.findElement(By.cssSelector("input[placeholder='e.g. 12345']")).sendKeys("12345");
    }

    public void acceptTermsAndPay() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("document.getElementsByName('acceptPolicy')[0].click();");
        driver.findElement(By.cssSelector("button[ng-click='$ctrl.processPayment()']")).click();
    }

    public String getErrorMessage() throws InterruptedException {
        Thread.sleep(10000);
        return driver.findElement(By.cssSelector("div[class='info-title']")).getText();
    }
}
