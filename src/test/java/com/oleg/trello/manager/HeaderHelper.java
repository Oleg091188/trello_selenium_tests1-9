package com.oleg.trello.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderHelper extends HelperBase {

    public HeaderHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToHomePage() {
        click(By.name("house"));
        click(By.name("house"));
    }

    public void clickOnPlusButton() {
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));
    }

    public void clickOnAvatar() {
       click (By.cssSelector("[data-test-id='header-member-menu-button']"));
    }
}
