package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("http://localhost:8090");
        System.out.println( driver.getPageSource() );
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click(); 
        
        System.out.println("==");
        
        // onnistunut kirjautuminen
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        element.submit();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );
        
        // oikea käyttäjätunnus, väärä salasana
        element = driver.findElement(By.linkText("login"));       
        element.click(); 
        
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("wrong");
        element = driver.findElement(By.name("login"));
        element.submit();
        
        // ei-olemassaoleva käyttäjätunnus
        element = driver.findElement(By.linkText("login"));       
        element.click(); 
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys("doesNotExist");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        element.submit();
        
        // uuden käyttäjätunnuksen luominen
        element = driver.findElement(By.linkText("register new user"));       
        element.click(); 
        element = driver.findElement(By.name("username"));
        element.sendKeys("user1");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("password_confirmation"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("add"));
        element.submit();
        
        // uuden käyttäjätunnuksen luomisen jälkeen tapahtuma uloskirjautuminen
        element = driver.findElement(By.linkText("register new user"));       
        element.click(); 
        element = driver.findElement(By.name("username"));
        element.sendKeys("user2");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("password_confirmation"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("add"));
        element.submit();
        
        element = driver.findElement(By.linkText("continue to application mainpage")); 
        element.click(); 
        
        element = driver.findElement(By.linkText("continue to application mainpage")); 
        element.click(); 
    }
}
