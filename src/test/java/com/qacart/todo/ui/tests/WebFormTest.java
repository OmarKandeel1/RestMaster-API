package com.qacart.todo.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebFormTest {

    @Test
    public void submitAllDataOnTheForm() {
        // Open the Edge Web Browser.
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        // Get Text input elements and send name to it
        WebElement textInputElement = driver.findElement(By.xpath("/html/body/main/div/form/div/div[1]/label[1]/input"));
        textInputElement.sendKeys("OmarKandeel");

        // Get Password elements and add password to it
        WebElement passwordElement = driver.findElement(By.xpath("/html/body/main/div/form/div/div[1]/label[2]/input"));

        passwordElement.sendKeys("123456Ok@");

        // Get Password elements and add password to it
        WebElement textAreaElement = driver.findElement(By.xpath("/html/body/main/div/form/div/div[1]/label[3]/textarea"));
        textAreaElement.sendKeys("Text area trying to add text here");


        // Get Disabled input elements and assert
        WebElement disabledInputElement = driver.findElement(By.xpath("/html/body/main/div/form/div/div[1]/label[3]/textarea"));
        Assert.assertTrue(disabledInputElement.isEnabled());


        // Get Readonly input elements and assert it can't take values
        WebElement readOnlyInputElement = driver.findElement(By.xpath("/html/body/main/div/form/div/div[1]/label[5]/input"));
        Assert.assertEquals(readOnlyInputElement.getAttribute("readonly"), "true");


        // Get Dropdown select elements and choose option One
        // WebElement dropDownSelectElement = driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/label[1]/select"));
        //dropDownSelectElement.click();
        WebElement dropDownOptionOneElement = driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/label[1]/select/option[2]"));
        dropDownOptionOneElement.click();


        // Get Dropdown  elements and choose option One
        WebElement dropDownDataListElement = driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/label[2]/input"));
        dropDownDataListElement.click();
        dropDownDataListElement.sendKeys("San Francisco");
        //WebElement dropDownDataListChoicesElement = driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/label[2]/datalist/option[1]"));
        //dropDownDataListChoicesElement.sendKeys("San Francisco");

        // Click on the checkbox of defaultcheckbox

        WebElement defaultCheckBoxElement = driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/div[1]/label[2]/input"));
        defaultCheckBoxElement.click();



        //click on Submit
        WebElement submitButtonElement = driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/button"));
        submitButtonElement.click();

        //check submit is done
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.selenium.dev/selenium/web/submitted-form.html?my-text=OmarKandeel&my-password=123456Ok%40&my-textarea=Text+area+trying+to+add+text+here&my-readonly=Readonly+input&my-select=1&my-datalist=San+Francisco&my-file=&my-check=on&my-check=on&my-radio=on&my-colors=%23563d7c&my-date=&my-range=5&my-hidden=");




    }


}
