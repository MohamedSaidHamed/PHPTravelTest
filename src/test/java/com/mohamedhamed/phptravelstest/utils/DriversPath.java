/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohamedhamed.phptravelstest.utils;

/**
 *
 * @author Mohamed
 */
public class DriversPath {
    //Change as required

    /**
     *
     */
    public static String screenshotsPath = "C:\\JavaEE";

    /**
     *
     */
    public DriversPath() {
    }
    
    /**
     *
     * @return
     */
    public String detectOS(){
        String os = System.getProperty("os.name").toLowerCase();
        if(os.contains("win"))
            return "windows";
        else if(os.contains("mac"))
            return "mac";
        else if(os.contains("nix") || os.contains("nux") || os.contains("aix"))
            return "linux";
        else
            return"";
    }

    /**
     *
     * @param browser
     * @return
     */
    public String getDriverKey(String browser) {
        switch (browser) {
            case "firefox":
                return "webdriver.firefox.driver";
            case "chrome":
                return "webdriver.chrome.driver";
            case "internetExplorer":
                return "webdriver.ie.driver";
            default:
                return "";
        }
    }

    /**
     *
     * @param os
     * @param browser
     * @return
     */
    public String getDriverPathByBrowser(String os, String browser) {
        //Ability to add more browsers
        switch (os) {
            case "windows":

                switch (browser) {
                    case "chrome":
                        //path to drivers
                        //Chamge {userDir to a valid directory}
                        return "{userDir}chromedriver_win32_2\\chromedriver.exe";
                    case "firefox":
                        return "";
                    case "internetExplorer":
                        return "";
                    default:
                        return "You have to select a valid browser";
                }
            case "mac":
                switch (browser) {
                    case "chrome":
                        return "";
                    case "firefox":
                        return "";
                    case "internetExplorer":
                        return "";
                    default:
                        return "You have to select a valid browser";
                }
            case "linux":
                switch (browser) {
                    case "chrome":
                        return "";
                    case "firefox":
                        return "";
                    case "internetExplorer":
                        return "";
                    default:
                        return "You have to select a valid browser";
                }
            default:
                return null;
        }

    }

}
