package coreUtilities.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtils {

    public static void capture(WebDriver driver, String name) {
        try {
            if (driver == null) {
                System.out.println("❌ Screenshot skipped: WebDriver is null");
                return;
            }

            // Take screenshot
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Add timestamp to avoid overwriting
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            // Destination path
            String dest = System.getProperty("user.dir")
                    + "/target/screenshots/"   // better to use target instead of src/
                    + name + "_" + timestamp + ".png";

            File destFile = new File(dest);
            destFile.getParentFile().mkdirs(); // ensure folder exists

            // Copy file
            FileUtils.copyFile(src, destFile);

            System.out.println("✅ Screenshot saved at: " + dest);
        } catch (Exception e) {
            System.out.println("❌ Screenshot failed: " + e.getMessage());
        }
    }
}
