package com.alex.spring.springselenium.kelvin.service;

import com.github.javafaker.Faker;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@Lazy // Creates object only when it required
@Component
public class ScreenshotService {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private Faker faker;

    @Value("${screenshot.path}")
    private Path path;

    public void takeScreenShot(){
        File screenshot = this.applicationContext.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
        try {
            FileCopyUtils.copy(screenshot, this.path.resolve(faker.name().username() + ".png").toFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
