package ru.tinkoff;

import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.support.PageFactory;

import ru.tinkoff.pages.CurrentProviderPage;
import ru.tinkoff.pages.HomePage;
import ru.tinkoff.pages.PaymentsPage;
import ru.tinkoff.pages.ProvidersPage;

import static org.openqa.selenium.support.PageFactory.initElements;

public class SampleJUnitTest extends JUnitTestBase {

    private String providerName;
    private HomePage homepage;
    private PaymentsPage paymentsPage;
    private ProvidersPage providersPage;
    private CurrentProviderPage currentProviderPage;


    @Before
    public void initPageObjects() {
        homepage = initElements(driver, HomePage.class);
        paymentsPage = initElements(driver, PaymentsPage.class);
        providersPage = initElements(driver, ProvidersPage.class);
        currentProviderPage = initElements(driver, CurrentProviderPage.class);

        driver.get(baseUrl);
    }

    @Test
    public void testProvidersPageHasItems() {
        homepage.loaded();
        homepage.click_to_payments_menu_item();
        paymentsPage.click_to_utility_payments_item();
        if (!providersPage.current_region_is("Москве")) {
            providersPage.click_to_current_region();
            providersPage.click_to_region_item_calling("г. Москва");
        }
        providerName = providersPage.get_first_provider_name();
        providersPage.click_to_first_provider();
        currentProviderPage.click_to_second_menu_item();


    }
}
