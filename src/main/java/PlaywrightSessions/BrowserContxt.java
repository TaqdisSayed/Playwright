package PlaywrightSessions;

import com.microsoft.playwright.*;

public class BrowserContxt {


     public static void main(String[] args) {

         try (Playwright playwright = Playwright.create()) {
             Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                     .setHeadless(false));
             BrowserContext context = browser.newContext();

             Page p1 = context.newPage();
             p1.navigate("https://academy.naveenautomationlabs.com/");
             p1.locator("text=Login").click();


             BrowserContext context1 = browser.newContext();
             Page p2 = context1.newPage();
             p2.navigate("https://accounts.google.com/lifecycle/steps/signup/name?continue=https://mail.google.com/mail/u/0/&dsh=S-854686734:1747648556694245&emr=1&flowEntry=SignUp&flowName=GlifWebSignIn&followup=https://mail.google.com/mail/u/0/&ifkv=ASKV5Mg_QbkGNH667LrJh3AlRieHi2r6YCTsJdOvtBjuP70rLrr6_lK3EeDmOvso66FC2Pcou-aa0A&osid=1&service=mail&TL=AArrULRx5etLr6g-Gsa_Mg_n8ZS-posXerrNC45BGuO5aHa10wFFAdNF_Cfdm2CW");
            //Fill [placeholder="Password"]
             p2.locator("[aria-label=\"First name\"]").fill("taqdis");
             // Click [aria-label="Last name \(optional\)"]
             p2.locator("[aria-label=\"Last name \\(optional\\)\"]").click();
             // Fill [aria-label="Last name \(optional\)"]
             p2.locator("[aria-label=\"Last name \\(optional\\)\"]").fill("sayyed");


             context.close();
             p1.close();

             context1.close();
             p2.close();



         }


    }
}
