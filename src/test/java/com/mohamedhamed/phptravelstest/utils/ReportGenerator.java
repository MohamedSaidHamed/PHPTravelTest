/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohamedhamed.phptravelstest.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 *
 * @author Mohamed
 */
public class ReportGenerator implements ITestListener{

    /**
     *
     * @param itr
     */
    @Override
    public void onTestStart(ITestResult itr) {
        System.out.println(" Starting test: " + itr.getName());
        
    }

    /**
     *
     * @param itr
     */
    @Override
    public void onTestSuccess(ITestResult itr) {
        System.out.println(" Test passed: " + itr.getName());
    }

    /**
     *
     * @param itr
     */
    @Override
    public void onTestFailure(ITestResult itr) {
        System.out.println(" Test failed: " + itr.getName());
    }

    /**
     *
     * @param itr
     */
    @Override
    public void onTestSkipped(ITestResult itr) {
        System.out.println(" Test ignored: " + itr.getName());
    }

    /**
     *
     * @param itr
     */
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult itr) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param itc
     */
    @Override
    public void onStart(ITestContext itc) {
        System.out.println("Begin test: " + itc.getName());
    }

    /**
     *
     * @param itc
     */
    @Override
    public void onFinish(ITestContext itc) {
        System.out.println("-End test: " + itc.getName());
    }
    
}
