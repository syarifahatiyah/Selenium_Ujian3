package com.juaracoding.selenium3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestLogin {
    WebDriver driver;
    String pathChromeDriver = "C:\\juaracoding\\chromedriver.exe";

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", pathChromeDriver);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String url = "https://shop.demoqa.com/my-account/";
        driver.get(url);
        System.out.println("Get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");
    }


    @Test(priority = 1)
    public void testValidLogin(){
        //step action
        login("syarifah","admin123");
        //step verify
        String txtDashboard = driver.findElement(By.xpath("//*[@id='post-8']/div/div/div/p[2]")).getText();
        Assert.assertEquals(txtDashboard, "From your account dashboard you can view your recent orders, " +
                "manage your shipping and billing addresses, and edit your password and account details.");
        driver.findElement(By.xpath("//*[@id='post-8']/div/div/div/p[1]/a")).click();
        System.out.println("Berhasil Logout");

    }

    @Test(priority = 2)
    public void testInvalidLogin(){
        delay(1);
        //step action
        login("syarifah","admin1234");
        //step verify
        String txtInvalidLogin = driver.findElement(By.xpath("///*[@id='post-8']/div/div/div[1]/ul")).getText();
        Assert.assertEquals(txtInvalidLogin, "ERROR: The username or password you entered is incorrect.");
    }

    @AfterClass
    public void quitBrowser(){
        delay(3);
        driver.quit();
        System.out.println("Quit Browser");
    }

    static void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    void login(String username, String password){
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id='customer_login']/div[1]/form/p[3]/button")).click();
    }
}
