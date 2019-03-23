/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohamedhamed.phptravelstest.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

/**
 *
 * @author Mohamed
 */
public class ScreenshotGenerator {

    /**
     *
     */
    public ScreenshotGenerator() {
    }
    
    /**
     *
     * @param driver
     * @param pathToFile
     * @throws IOException
     */
    public void capture(WebDriver driver, String pathToFile) throws IOException {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String finalPath = pathToFile +"\\" + driver.getTitle() + ".png";
        File screenshotName = new File(finalPath);
        FileUtils.copyFile(screenshotFile, screenshotName);
        Reporter.log("<br/><p>Error screenshot</p><img src="+finalPath+" style='width:400px; height:400px;'></img><br/>");
    }

}
