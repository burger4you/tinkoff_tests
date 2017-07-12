package ru.tinkoff.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Страница оплаты провайдера
 */
public class CurrentProviderPage extends Page {

    @FindBy(how = How.XPATH, using = "//*[@class='ui-menu-second__item']")
    @CacheLookup
    public WebElement secondMenuItem;

    public CurrentProviderPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void click_to_second_menu_item() {
        new WebDriverWait(driver, 5).until(
                ExpectedConditions.visibilityOf(secondMenuItem));
        secondMenuItem.click();
    }
}
