package ru.tinkoff.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

/**
 * Стартовая страница Tinkoff Bank
 */
public class HomePage extends Page {

  @FindBy(how = How.XPATH, using = "//*[@data-reactid='100']")
  public WebElement paymentsLink;

  public HomePage(WebDriver webDriver) {
    super(webDriver);
  }

  public void loaded() {
      assertEquals("Лучший онлайн-банк. Кредитные и дебетовые карты с доставкой на дом.", getTitle());
  }

  public void click_to_payments_menu_item() {
      paymentsLink.click();
      new WebDriverWait(driver, 5).until(
              ExpectedConditions.titleContains("Tinkoff.ru: платежи и переводы денег"));
  }
}
