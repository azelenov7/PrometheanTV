import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Primary {

    @Test
    public void openBroadcastCenterAndSignInAndOverlayTilesObservation() {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://ptvdemo:TomLikesSmallChips!@qa.broadcast.promethean.tv");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement signinButton = driver.findElement(By.xpath("//div[contains(@class,'tertiary')]"));
        signinButton.click();

        WebElement username = driver.findElement(By.xpath("//input[@id='usernameOrEmail']"));
        username.clear();
        username.sendKeys("qatest@p33.org");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.clear();
        password.sendKeys("Temp1234567!");
        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
        submit.click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='channel_card_check channel_card_not_selected']")));
        driver.findElement(By.xpath("//span[contains(.,'Library')]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'footer ng-scope')]")));
        driver.findElement(By.xpath("//div[@class='cta_primary']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='md-button md-ink-ripple md-focused']")));
        driver.findElement(By.xpath("//button[@role='menuitem']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='tree_node_all']")));
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//md-icon[contains(.,'close')]")).click();

        driver.quit();
    }
}
