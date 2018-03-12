package com.melkar.ryanair.selenium.test;

import com.melkar.ryanair.cucumber.page.ExtrasPage;
import com.melkar.ryanair.cucumber.page.HomePage;
import com.melkar.ryanair.cucumber.page.MainPage;
import com.melkar.ryanair.cucumber.page.PaymentPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class PaymentDeclineTest extends FunctionalTest {

    @Test
    public void testApp() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openHomePage();
        sleep(3000);
        mainPage.logIn("kuliievakarolina@gmail.com", "r2yAnair");
        sleep(3000);
        assertTrue(mainPage.isUserLoggedIn());

        sleep(2000);

        mainPage.selectOneWay();
        mainPage.enterDepartureAirport("Wroclaw");
        mainPage.enterDestinationAirport("Mallorca");


        sleep(2000);
        mainPage.enterFlyDate("31", "03", "2018");
        sleep(2000);
        mainPage.addOneAdult();
        mainPage.checkTermsConditions();
        mainPage.clickLetsGoButton();
        sleep(8000);

        //home
        HomePage homePage = new HomePage(driver);
        homePage.selectFlight();
        sleep(3000);
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

        // payment
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.fillPassengerInfo();
        sleep(2000);
        paymentPage.fillCardInfo();
        sleep(3000);
        paymentPage.fillBillingAddress();
        paymentPage.acceptTermsAndPay();
        sleep(2000);

        assertEquals("Warning payment message", "Oh. There was a problem", paymentPage.getErrorMessage());

        sleep(2000);

    }

}
