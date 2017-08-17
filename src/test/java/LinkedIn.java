import frameword.ExcelUtils;
import frameword.TestBase;
import models.Candidate;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;

/**
 * Created by agent on 8/17/17.
 */
public class LinkedIn extends TestBase{
    ExcelUtils excelUtils;
    RemoteWebDriver driver = null;
    Collection<Candidate> candidates;
    @BeforeMethod
    public void setUpMethod() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444"),dc);

        excelUtils = new ExcelUtils("linkedin.xlsx");
        candidates = excelUtils.getModelFromExcel(Candidate.class);
    }

    @Test
    public void getName() {
        candidates.stream().forEach(candidate ->
        {
            Candidate newCadidate = new Candidate();
            driver.get(candidate.getPrivateLink());
            String name = driver.findElement(By.xpath("//h1[@class='searchable']")).getText();
            String publicLink = driver.findElement(By.xpath("//a[text()='Public Profile']")).getAttribute("href");
            newCadidate.setName(name);
            newCadidate.setPrivateLink(publicLink);
        });
    }

    @AfterMethod
    public void tearDownMethod() {

        driver.quit();
    }
}
