package com.bookIt.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

public class BrowserUtils {
    public static void wait(int second) {
        try {
            Thread.sleep(1000 * second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void verifyEquals(String actual, String expected){
        if(actual.equals(expected)){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }
    }

    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].click();", element);
    }

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForStaleElement(WebElement element) {
        int y = 0;
        while (y <= 15) {
            try {
                element.isDisplayed();
                break;
            } catch (StaleElementReferenceException st) {
                y++;
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            break;
        }
    }

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /*
     * takes screenshot
     * @param name
     * take a name of a test and returns a path to screenshot takes
     */
    public static String getScreenshot(String name) {
        // name the screenshot with the current date time to avoid duplicate name
        //String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        SimpleDateFormat df = new SimpleDateFormat("-yyyy-MM-dd-HH-mm");
        String date = df.format(new Date());

        // TakesScreenshot ---> interface from selenium which takes screenshots
        TakesScreenshot ts = (TakesScreenshot) Driver.get();
        File source = ts.getScreenshotAs(OutputType.FILE);

        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return target;
    }
    /**
     * Wait 15 seconds with polling interval of 200 milliseconds then click
     *
     * @param webElement of element
     */
    public static void clickWithWait(WebElement webElement) {
        Wait wait = new FluentWait<>(Driver.get())
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotVisibleException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(WebDriverException.class);
        WebElement element = (WebElement) wait.until((Function<WebDriver, WebElement>) driver -> webElement);
        try {
            element.click();
        } catch (WebDriverException e) {
            System.out.println(e.getMessage());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            element.click();
        }
    }

    /**
     * waits for backgrounds processes on the browser to complete
     *
     * @param timeOutInSeconds
     */
    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        ExpectedCondition<Boolean> expectation2 = driver -> ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0").equals(true);
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), timeOutInSeconds);
            wait.until(expectation);
            wait.until(expectation2);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    public static void waitForPageTitle(String pageTitle) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
        wait.until(ExpectedConditions.titleIs(pageTitle));
    }

    public static List<String> getListOfString(List<WebElement> listofWebElement){
        List<String>  viewPerPageOptions = new ArrayList<>();
        for(WebElement each: listofWebElement){
            String value = each.getText().trim();
            if(value.length()>0) {
                viewPerPageOptions.add(each.getText());

            }
        }
        return  viewPerPageOptions;
    }
}
