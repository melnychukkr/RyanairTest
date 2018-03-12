package com.melkar.ryanair.cucumber.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageObject {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void selectFlight() {
        driver.findElement(By.cssSelector("div[class='flight-header__min-price hide-mobile']")).click();
    }

    public void selectStandardFare() {
        driver.findElement(By.cssSelector("div[class='flights-table-fares__fare-price']")).click();
    }

    public void pressContinue() {
        ((JavascriptExecutor) driver).executeScript("document.getElementById('continue').click();");
//        driver.findElement(By.cssSelector("button[ng-click='$ctrl.processPayment()']")).click();
//        driver.findElement(By.cssSelector("button[id='continue']")).click();
    }


}
