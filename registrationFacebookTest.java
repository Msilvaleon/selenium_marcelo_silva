import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class registrationFacebookTest {

    @Test
    public void fullRegistrationTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/login.php?next=https%3A%2F%2Fwww.facebook.com%2Fsettings%2F%3Fentry_point%3Dbookmark");
        driver.manage().window().maximize();

        driver.findElement(By.linkText("Crear cuenta nueva")).click();
        Thread.sleep(3000);

        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        driver.findElement(By.name("reg_email__")).sendKeys("msilva@imed.cl");
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("msilva@imed.cl");
        driver.findElement(By.name("reg_passwd__")).sendKeys("123456789");

        WebElement elementoDias = driver.findElement(By.id("day"));
        Select dias = new Select(elementoDias);
        dias.selectByValue("26");

        WebElement elementoMeses = driver.findElement(By.id("month"));
        Select meses = new Select(elementoMeses);
        meses.selectByValue("6");

        WebElement elementoAnio = driver.findElement(By.id("year"));
        Select anio = new Select(elementoAnio);
        anio.selectByIndex(42);

        List<WebElement> listaGenero = driver.findElements(By.name("sex"));
        WebElement generoHombre = listaGenero.get(1);
        generoHombre.click();

    }

}
