package com.alex.spring.springselenium.util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@Lazy // Creates object only when it required
@Component
public class ScreenShotUtil {

    @Autowired
    private WebDriver driver;

    @Value("${screenshot.path}")
    private Path path;

    public void takeScreenShot(final String imageName){
        File screenshot = ((TakesScreenshot)this.driver).getScreenshotAs(OutputType.FILE);
        try {
            FileCopyUtils.copy(screenshot, this.path.resolve(imageName).toFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
