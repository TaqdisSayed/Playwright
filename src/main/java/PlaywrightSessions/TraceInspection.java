package PlaywrightSessions;

import com.microsoft.playwright.*;

import java.nio.file.Paths;


public class TraceInspection {


    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();

            // Start tracing before creating / navigating a page.
            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true));
                    //.setSources(true));

            // Open new page
            Page page = context.newPage();

            // Go to https://academy.naveenautomationlabs.com/
            page.navigate("https://academy.naveenautomationlabs.com/");

            // Click .nav-link.badge.cartBtn.hide-md
            page.locator(".nav-link.badge.cartBtn.hide-md").click();

            // Click text=Courses Demo Site WebDriver APIs Webinars Login >> i
            page.locator("text=Courses Demo Site WebDriver APIs Webinars Login >> i").click();

            // Click text=Login
            page.locator("text=Login").click();

            // Click [placeholder="Name"]
            page.frameLocator("#microfe-popup-login").locator("[placeholder=\"Name\"]").click();

            // Fill [placeholder="Name"]
            page.frameLocator("#microfe-popup-login").locator("[placeholder=\"Name\"]").fill("test");

            // Click [placeholder="Email address"]
            page.frameLocator("#microfe-popup-login").locator("[placeholder=\"Email address\"]").click();

            // Fill [placeholder="Email address"]
            page.frameLocator("#microfe-popup-login").locator("[placeholder=\"Email address\"]").fill("test123@gmail.com");

            // Click [placeholder="Password"]
            page.frameLocator("#microfe-popup-login").locator("[placeholder=\"Password\"]").click();

            // Fill [placeholder="Password"]
            page.frameLocator("#microfe-popup-login").locator("[placeholder=\"Password\"]").fill("test123");

            // Click [placeholder="Enter your number"]
            page.frameLocator("#microfe-popup-login").locator("[placeholder=\"Enter your number\"]").click();

            // Fill [placeholder="Enter your number"]
            page.frameLocator("#microfe-popup-login").locator("[placeholder=\"Enter your number\"]").fill("+971 787 654 543");

            // Click #loginPopupCloseBtn svg[role="img"]
            page.frameLocator("#microfe-popup-login").locator("#loginPopupCloseBtn svg[role=\"img\"]").click();

            // Stop tracing and export it into a zip archive.
            context.tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("trace.zip")));
        }
    }
}