package com.juaracoding.selenium3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Register {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\juaracoding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String url = ("https://shop.demoqa.com/my-account/");
        driver.get(url);
        System.out.println("Get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");

        //Register
        driver.findElement(By.id("reg_username")).sendKeys("syarifah");
        driver.findElement(By.id("reg_email")).sendKeys("syarifahatiyah65@gmail.com");
        driver.findElement(By.id("reg_password")).sendKeys("admin123");
        driver.findElement(By.xpath("//*[@id='customer_login']/div[2]/form/p[4]/button")).click();
        System.out.println("Berhasil Registrasi");


        System.out.println("Delay 5 Detik");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
        System.out.println("Quit Browser");

    }
}
