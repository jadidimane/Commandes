package utility;

import com.codeborne.selenide.Screenshots;
import static com.codeborne.selenide.Selenide.*;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.WebElement;


public class ScreenShot implements TestWatcher {
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        if (cause instanceof AssertionError) {
            String testName = context.getDisplayName().replace(" ", "_");
            screenshot("FAILED_" + testName);
            System.out.println("📸 Capture faite : FAILED_" + testName);
        }
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        // Rien à faire
    }
}
