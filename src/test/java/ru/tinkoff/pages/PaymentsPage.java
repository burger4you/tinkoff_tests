package ru.tinkoff.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

/**
 * Страница "Платежи"
 */
public class PaymentsPage extends Page {

    @FindBy(how = How.XPATH, using = "//*[@href='/payments/categories/kommunalnie-platezhi/']")
    private WebElement utilityPayments;

    @FindBy(how = How.XPATH, using = "//*[@class='ui-link payment-page__title_inner']")
    @CacheLookup
    public WebElement firstProviderItem;

    @FindBy(how = How.CSS, using = ".ui-menu__link .ui-link__text")
    @CacheLookup
    public WebElement providerNameField;

    public PaymentsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void click_to_utility_payments_item() {
        utilityPayments.click();
        new WebDriverWait(driver, 5).until(
                ExpectedConditions.titleContains("Оплата ЖКХ без комиссии. Коммунальные платежи онлайн"));
    }
}
