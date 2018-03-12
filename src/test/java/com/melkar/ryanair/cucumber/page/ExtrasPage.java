package com.melkar.ryanair.cucumber.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ExtrasPage extends PageObject {

    public ExtrasPage(WebDriver driver) {
        super(driver);
    }


    public void pressCheckOut() {
        driver.findElement(By.cssSelector("button[class='core-btn-primary core-btn-block core-btn-medium btn-text']")).click();
    }

    public void pressNoInPopUp() {
        List<WebElement> elementss = driver.findElements(By.cssSelector("button[class='popup-msg__button popup-msg__button--cancel']"));
        if (!elementss.isEmpty()) {
            driver.findElement(By.cssSelector("button[class='popup-msg__button popup-msg__button--cancel']")).click();
        }
    }


}
