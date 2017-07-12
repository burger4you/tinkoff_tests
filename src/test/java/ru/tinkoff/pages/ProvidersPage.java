package ru.tinkoff.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.selenium.factory.WebDriverPool;

import static java.lang.String.format;

/**
 * Страница выбора поставщиков услуг
 */
public class ProvidersPage extends Page {

    private static final String REGION_ITEM_XPATH = "//*[@class='ui-link' and text()='%s']";

    @FindBy(how = How.XPATH, using = "//*[@class='ui-link payment-page__title_inner']")
    @CacheLookup
    public WebElement currentRegion;

    @FindBy(how = How.CSS, using = ".ui-regions")
    @CacheLookup
    public WebElement regionsLayout;

    @FindBy(how = How.XPATH, using = "//*[@class='ui-menu__item ui-menu__item_icons'][1]//a")
    @CacheLookup
    public WebElement firstProviderItem;

    @FindBy(how = How.CSS, using = ".ui-menu__link .ui-link__text")
    public WebElement providerNameField;

    public ProvidersPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean current_region_is(String regionName) {
        return currentRegion.getText().equals(regionName);
    }

    public void click_to_current_region() {
        currentRegion.click();
        new WebDriverWait(driver, 5).until(
                ExpectedConditions.visibilityOf(regionsLayout));
    }

    public void click_to_region_item_calling(String regionName) {
        driver.findElement(By.xpath(format(REGION_ITEM_XPATH, regionName))).click();
    }

    public void click_to_first_provider() {
        firstProviderItem.click();
    }

    public String get_first_provider_name() {
        new WebDriverWait(driver, 5).until(
                ExpectedConditions.visibilityOf(firstProviderItem));
        return firstProviderItem.getCssValue("title");
    }
}
