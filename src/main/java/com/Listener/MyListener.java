package com.Listener;


import org.testng.TestListenerAdapter;

public class MyListener extends TestListenerAdapter {
//  i try to create own listener to connect screenshot with report
//    @Override
//    public void onTestFailure(ITestResult tr) {
//        String reportFolder = System.getProperty("user.dir")
//                + "/target/surefire-reports/html/";
//
//        String screenshotFolderName = "screenshot/";
//        String screenshotFullFolder = reportFolder + screenshotFolderName;
//        String screenshotName = tr.getMethod()+ "_" + General.getDateStampSimple() + ".png";
//
//        String screenshotLinkFolder = screenshotFolderName+screenshotName; // For HTML report
//        String screenshotPath = screenshotFullFolder + screenshotName; //For system
//
//        General.getPageScreenShot(screenshotPath);
//        Reporter.setCurrentTestResult(tr);
//        General.sendComments("<a href='"+screenshotLinkFolder+"'><img src='"+screenshotLinkFolder+"' width='200' height='150' alt='Click on image to enlarge'>");
//    }

}
