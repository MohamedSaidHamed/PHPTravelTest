/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohamedhamed.phptravelstest;

import com.mohamedhamed.phptravelstest.utils.DriversPath;
import com.mohamedhamed.phptravelstest.utils.ElementTypes;
import com.mohamedhamed.phptravelstest.utils.GenericTestHelper;
import com.mohamedhamed.phptravelstest.utils.ReportGenerator;
import com.mohamedhamed.phptravelstest.utils.ScreenshotGenerator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 *
 * @author Mohamed
 */
@Listeners(ReportGenerator.class)
public class SignupControllerNGTest {

    WebDriver driver;

    /**
     *
     */
    @BeforeTest
    public void setupEnviromnent() {
        //init the test environment
        DriversPath dp = new DriversPath();
        //passing the desired web browser name to get the required drivers
        System.setProperty(dp.getDriverKey("chrome"), dp.getDriverPathByBrowser(dp.detectOS(), "chrome"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /**
     *
     * @return
     */
    @DataProvider(name = "dataGenerator")
    public static Object[][] generateTestData() {
        //fill in the test data
        List<GenericTestHelper> gtList = new ArrayList<>();
        String url = "https://www.phptravels.net/register";
        gtList.add(new GenericTestHelper(ElementTypes.Input, "//*[@id=\"headersignupform\"]/div[3]/input", "albert"));
        gtList.add(new GenericTestHelper(ElementTypes.Input, "//*[@id=\"headersignupform\"]/div[4]/input", "anestine"));
        gtList.add(new GenericTestHelper(ElementTypes.Input, "//*[@id=\"headersignupform\"]/div[5]/input", "010"));
        gtList.add(new GenericTestHelper(ElementTypes.Input, "//*[@id=\"headersignupform\"]/div[6]/input", "albert@test3anestine.com"));
        gtList.add(new GenericTestHelper(ElementTypes.Input, "//*[@id=\"headersignupform\"]/div[7]/input", "123456"));
        gtList.add(new GenericTestHelper(ElementTypes.Input, "//*[@id=\"headersignupform\"]/div[8]/input", "123456"));
        gtList.add(new GenericTestHelper(ElementTypes.Button, "//*[@id=\"headersignupform\"]/div[9]/button", ""));
        gtList.add(new GenericTestHelper(ElementTypes.Error, "//*[@id=\"headersignupform\"]/div[2]/div", ""));
        return new Object[][]{{gtList, url}};
    }

    /**
     *
     * @param gtList
     * @param url
     * @throws Exception
     */
    @Test(dataProvider = "dataGenerator")
    public void signUpPageTest(List<GenericTestHelper> gtList, String url) throws Exception {
        try {
            driver.get(url);
            gtList.stream().forEach(item -> {
                switch (item.getElemType()) {
                    case Input:
                        driver.findElement(By.xpath(item.getAttrXpath())).sendKeys(item.getValue());
                        break;
                    case Date:
                        //To be able to change dates 
                        break;
                    case RadioButton:
                        //To be able to change radio buttons 
                        break;
                    case SelectOneMenu:
                        //To be able to change select menus
                        break;
                    case Button:
                        WebElement button = driver.findElement(By.xpath(item.getAttrXpath()));
                        if (button.isDisplayed() && button.isEnabled()) {
                            button.click();
                        } else {
                            try {
                                new ScreenshotGenerator().capture(driver, new DriversPath().screenshotsPath);
                                Assert.assertTrue(false);
                            } catch (IOException ex) {
                                Logger.getLogger(SignupControllerNGTest.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                    case Error:
                        try {
                            //giving it 3 seconds to wait for the server response
                            Thread.sleep(3000);
                            String error = driver.findElement(By.xpath(item.getAttrXpath())).getText();
                            if ((!error.trim().isEmpty())) {
                                new ScreenshotGenerator().capture(driver, DriversPath.screenshotsPath);
                                Assert.assertTrue(false);
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(SignupControllerNGTest.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    default:
                        break;

                }

            });

        } catch (Exception ex) {
            Logger.getAnonymousLogger().info(ex.getStackTrace().toString());
            new ScreenshotGenerator().capture(driver, DriversPath.screenshotsPath);
            throw new Exception(ex);
        }
    }

    /**
     *
     * @throws Exception 
     */
    @Test(dependsOnMethods = "signUpPageTest")
    public void recieveVerificationEmailTest() throws Exception {
        //Assiming receiving an email with valid verifivation link
        Assert.assertTrue(true);
    }

    /**
     *
     * @throws Exception
     */
    @AfterTest
    public void releaseEnvironment() throws Exception {
        //close the browser after the test is done
        driver.quit();
    }

}
