import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Command {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oea16\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.commandlink.com/");
        driver.manage().window().maximize();
        System.out.println("Open Website");

        Thread.sleep(3000);
        WebElement buttonCookies = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/button[3]"));
        buttonCookies.click();
        System.out.println("Accepted Cookies");

        Thread.sleep(3000);
        WebElement company = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/header[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]"));
        company.click();
        System.out.println("Opened Company Menu");

        Thread.sleep(3000);
        WebDriverWait waitForCarries = new WebDriverWait(driver, 45);
        WebElement careers = waitForCarries.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[4]/header[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[2]/div[1]/div[3]/a[1]/div[1]")));
        careers.click();
        System.out.println("Opened Careers Page");

        Thread.sleep(3000);
        WebElement buttonSearch = driver.findElement(By.xpath("/html[1]/body[1]/div[5]/section[3]/div[1]/div[9]/div[2]/a[1]"));
        Actions scrollDown = new Actions(driver);
        scrollDown.moveToElement(buttonSearch).perform();
        Thread.sleep(3000);
        buttonSearch.click();
        System.out.println("Scrolled down and clicked search");

        Thread.sleep(3000);
        String originalTab = driver.getWindowHandle();
        for (String newTab : driver.getWindowHandles()) {
            if (!newTab.equals(originalTab)) {
                driver.switchTo().window(newTab);
                break;
            }
        }

        String pageText= driver.getPageSource();
        assertTrue(pageText.contains("Current Openings"));
        System.out.println("We are on correct page");

        Thread.sleep(3000);
        driver.quit();
        System.out.println("Closed Browser");

    }
}