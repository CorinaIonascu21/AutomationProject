package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SimpleElements {
    private WebDriver driver;

    public SimpleElements (WebDriver driver) {


        this.driver = driver;
    }
    //ai nevoie de un constructor pt instantarea obiectului, pt parsarea obiectelor dintr-o clasa

    public WebElement loginText(){
        return driver.findElement(By.className("loginPageID"));

    }
}
