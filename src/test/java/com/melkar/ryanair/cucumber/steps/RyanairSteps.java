package com.melkar.ryanair.cucumber.steps;

import com.melkar.ryanair.cucumber.page.ExtrasPage;
import com.melkar.ryanair.cucumber.page.HomePage;
import com.melkar.ryanair.cucumber.page.MainPage;
import com.melkar.ryanair.cucumber.page.PaymentPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RyanairSteps {
    private final WebDriver driver;

    private PaymentPage paymentPage;

    public RyanairSteps() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Before
    public void setUp() {
        driver.manage().deleteAllCookies();
    }

    @After
    public void cleanUp() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

    @Given("^I make a booking from (.*?) to (.*?) for (\\d+) adults$")
    public void searchFor(String departureAirport, String destinationAirport, int adultsCount) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openHomePage();
        sleep(7000);
        mainPage.logIn("kuliievakarolina@gmail.com", "r2yAnair");
        sleep(3000);
        assertTrue(mainPage.isUserLoggedIn());

        sleep(2000);

        mainPage.selectOneWay();
        mainPage.enterDepartureAirport(departureAirport);
        mainPage.enterDestinationAirport(destinationAirport);


        sleep(5000);
        mainPage.enterFlyDate("31", "03", "2018");
        sleep(5000);
        for (int i = 0; i < adultsCount - 1; i++) {
            mainPage.addOneAdult();
        }
        mainPage.checkTermsConditions();
        mainPage.clickLetsGoButton();
        sleep(10000);

        //home
        HomePage homePage = new HomePage(driver);
        homePage.selectFlight();
        sleep(4000);
        homePage.selectStandardFare();
        sleep(7000);
        homePage.pressContinue();
        sleep(2000);


        // extras
        ExtrasPage extrasPage = new ExtrasPage(driver);
        extrasPage.pressCheckOut();
        sleep(3000);
        extrasPage.pressNoInPopUp();
        sleep(2000);

    }

    @When("^I pay for booking with card details$")
    public void certifiedYes() throws InterruptedException {
        paymentPage = new PaymentPage(driver);
        paymentPage.fillPassengerInfo();
        sleep(2000);
        paymentPage.fillCardInfo();
        sleep(3000);
        paymentPage.fillBillingAddress();
        paymentPage.acceptTermsAndPay();
        sleep(2000);
    }

    @Then("^Payment page shows error message$")
    public void checkPaymentErrorMessage() throws InterruptedException {
        assertEquals("Warning payment message", "Oh. There was a problem", paymentPage.getErrorMessage());

        sleep(2000);
    }

}
