import ohtu.*
import ohtu.authentication.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description """A new user account can be created 
              if a proper unused username 
              and a proper password are given"""

scenario "creation successful with correct username and password", {
    given 'command new user is selected', {
        getToRegisterPage();
    }
 
    when 'a valid username and password are entered', {
        giveUsernameAndPassword("user5", "Password1");
    }

    then 'new user is registered to system', {
        driver.getPageSource().contains("Welcome to Ohtu App!").shouldBe true
    }
}

scenario "can login with succesfully generated account", {
    given 'command new user is selected', {
        getToRegisterPage();
    }
 
    when 'a valid username and password are entered', {
        giveUsernameAndPassword("user6", "Password1");

        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        element = driver.findElement(By.linkText("logout"));
        element.click();
        element = driver.findElement(By.linkText("login"));
        element.click();
    }

    then  'new credentials allow logging in to system', {
        element = driver.findElement(By.name("username"));
        element.sendKeys("user6");
        element = driver.findElement(By.name("password"));
        element.sendKeys("Password1");
        
        element = driver.findElement(By.name("login"));
        element.submit();

        driver.getPageSource().contains("Welcome to Ohtu Application!").shouldBe true
    }
}

scenario "creation fails with correct username and too short password", {
    given 'command new user is selected', {
        getToRegisterPage();
    }
    when 'a valid username and too short password are entered', {
        giveUsernameAndPassword("user7", "p7");
    }

    then 'new user is not be registered to system', {
        driver.getPageSource().contains("length greater or equal to 8").shouldBe true
    }
}

scenario "creation fails with correct username and pasword consisting of letters", {
    given 'command new user is selected', {
        getToRegisterPage();
    }

    when 'a valid username and password consisting of letters are entered', {
        giveUsernameAndPassword("user7", "password");
    }

    then 'new user is not be registered to system', {
        driver.getPageSource().contains("must contain one character that is not a letter").shouldBe true
    }
}

scenario "creation fails with too short username and valid password", {
    given 'command new user is selected', {
        getToRegisterPage();
    }

    when 'a too short username and valid password are entered', {
        giveUsernameAndPassword("us", "password1");
    }

    then 'new user is not be registered to system', {
        driver.getPageSource().contains("length 5-10").shouldBe true
    }
}

scenario "creation fails with already taken username and valid pasword", {
    given 'command new user is selected', {
        getToRegisterPage();
    }

    when 'an already taken username and valid password are entered', {
        giveUsernameAndPassword("pekka", "password1");
    }

    then 'new user is not be registered to system', {
        driver.getPageSource().contains("username or password invalid").shouldBe true
    }
}

scenario "can not login with account that is not successfully created", {
    given 'command new user is selected', {
        getToRegisterPage();
    }

    when 'a invalid username/password are entered', {
        giveUsernameAndPassword("us", "password");
    }

    then  'new credentials do not allow logging in to system', {
        element = driver.findElement(By.linkText("back to home"));       
        element.click();

        element = driver.findElement(By.linkText("login"));       
        element.click();

        element = driver.findElement(By.name("username"));
        element.sendKeys("pe");
        element = driver.findElement(By.name("password"));
        element.sendKeys("password");

        element = driver.findElement(By.name("login"));
        element.submit();

        driver.getPageSource().contains("wrong username or password").shouldBe true
    }
}

void getToRegisterPage() {
    driver = new HtmlUnitDriver();
    driver.get("http://localhost:8090");
    element = driver.findElement(By.linkText("register new user"));       
    element.click(); 
}

void giveUsernameAndPassword(String username, String password) {
    element = driver.findElement(By.name("username"));
    element.sendKeys(username);
    element = driver.findElement(By.name("password"));
    element.sendKeys(password);
    element = driver.findElement(By.name("passwordConfirmation"));
    element.sendKeys(password);
        
    element = driver.findElement(By.name("add"));
    element.submit();
}
