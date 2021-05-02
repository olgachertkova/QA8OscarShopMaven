package tests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.commons.io.FileUtils;


import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class TestBase {
    WebDriver driver;
    Logger logger = LoggerFactory.getLogger(TestBase.class);


    @BeforeMethod(alwaysRun = true)
    public void openBrowser(Method method, Object[] param){
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("headless");
//        options.addArguments("window-size=1800x900");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://selenium1py.pythonanywhere.com/en-gb/");
        logger.info("Start test: " + method.getName());
        if(param.length != 0) {
            logger.info(" --> With data: " + Arrays.asList(param));
        }
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser(ITestResult result) throws Exception {
//        takeSnapShot(driver);
        driver.quit();
        if(result.isSuccess()){
            logger.info("Test result: PASSED");
        }else{
            logger.error("Test result: FAILED");
            this.takeSnapShot(driver);

        }

        logger.info("Stop test: " + result.getMethod().getMethodName());
        logger.info("======================================================");
    }

    public static void takeSnapShot(WebDriver webdriver) throws Exception{

        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Create new file name
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String curDate = formatter.format(date);
        String filePath = "screenshots/screenshot_" + curDate +".png";

        //Move image file to new destination
        File DestFile=new File(filePath);

        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);

    }




}
