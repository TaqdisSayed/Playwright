package PlaywrightSessions;

import com.microsoft.playwright.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Example {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();

            // Open new page
            Page page = context.newPage();

            // Go to https://academy.naveenautomationlabs.com/
            page.navigate("https://academy.naveenautomationlabs.com/");

            // Click text=Login
            page.locator("text=Login").click();

            // Click [placeholder="Name"]
            page.frameLocator("#microfe-popup-login").locator("[placeholder=\"Name\"]").click();

            // Fill [placeholder="Name"]
            page.frameLocator("#microfe-popup-login").locator("[placeholder=\"Name\"]").fill("Ravi");

            page.pause();

            // Click [placeholder="Email address"]
            page.frameLocator("#microfe-popup-login").locator("[placeholder=\"Email address\"]").click();

            // Click [placeholder="Name"]
            page.frameLocator("#microfe-popup-login").locator("[placeholder=\"Name\"]").click();

            // Fill [placeholder="Name"]
            page.frameLocator("#microfe-popup-login").locator("[placeholder=\"Name\"]").fill("Taqdis");

            // Click [placeholder="Email address"]
            page.frameLocator("#microfe-popup-login").locator("[placeholder=\"Email address\"]").click();

            // Fill [placeholder="Email address"]
            page.frameLocator("#microfe-popup-login").locator("[placeholder=\"Email address\"]").fill("syedtaqdis56@gmail.com");

            // Click [placeholder="Password"]
            page.frameLocator("#microfe-popup-login").locator("[placeholder=\"Password\"]").click();

            // Fill [placeholder="Password"]
            page.frameLocator("#microfe-popup-login").locator("[placeholder=\"Password\"]").fill("Ninewest1$");

            // Click [placeholder="Enter your number"]
            page.frameLocator("#microfe-popup-login").locator("[placeholder=\"Enter your number\"]").click();

            // Fill [placeholder="Enter your number"]
            page.frameLocator("#microfe-popup-login").locator("[placeholder=\"Enter your number\"]").fill("+971 567 654 932");

            // Click text=Next
            // page.waitForNavigation(new Page.WaitForNavigationOptions().setUrl("https://academy.naveenautomationlabs.com/"), () ->
            page.waitForNavigation(() -> {
                page.frameLocator("#microfe-popup-login").locator("text=Next").click();
            });
        }
    }
}
