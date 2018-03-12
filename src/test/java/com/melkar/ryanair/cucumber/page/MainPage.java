package com.melkar.ryanair.cucumber.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.Keys.ENTER;

public class MainPage extends PageObject {

    public MainPage(WebDriver driver) {
        super(driver);
    }


    public void openHomePage() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://www.ryanair.com/ie/en/");
    }

    public void logIn(String email, String password) throws InterruptedException {
        driver.findElement(By.cssSelector("a[ui-sref='login']")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("emailAddress")).sendKeys(email);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("password-input > input[name='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("[button-text='MYRYANAIR.AUTHORIZATION.LOGIN.LOGIN_AUTHORIZATION']")).click();
    }

    public boolean isUserLoggedIn() {
        return driver.findElement(By.cssSelector("span[class='username']")).isDisplayed();
    }

    public void selectOneWay() {
        driver.findElement(By.cssSelector("div[class='flight-search-type-option one-way']")).click();
    }

    public void enterDepartureAirport(String city) {
        WebElement departureInput = driver.findElement(By.cssSelector("input[placeholder='Departure airport']"));
        departureInput.click();
        departureInput.clear();
        departureInput.sendKeys(city);
        departureInput.sendKeys(ENTER);
    }

    public void enterDestinationAirport(String city) {
        WebElement destination = driver.findElement(By.cssSelector("input[placeholder='Destination airport']"));
        destination.click();
        destination.clear();
        destination.sendKeys(city);
        destination.sendKeys(ENTER);
    }

    public void enterFlyDate(String day, String month, String year) {
        driver.findElement(By.name("dateInput0")).sendKeys(day);
        driver.findElement(By.name("dateInput1")).sendKeys(month);
        driver.findElement(By.name("dateInput2")).sendKeys(year);

    }

    public void addOneAdult() throws InterruptedException {
        driver.findElement(By.cssSelector("div.dropdown-handle")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("div[value='paxInput.adults'] button[ng-click='$ctrl.increment()']")).click();
    }

    public void checkTermsConditions() {
        driver.findElement(By.className("terms-conditions-checkbox-span")).click();
    }

    public void clickLetsGoButton() {
        driver.findElement(By.cssSelector("[ng-click='searchFlights()']")).click();
    }
}
