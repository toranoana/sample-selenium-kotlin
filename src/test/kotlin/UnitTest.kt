import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.safari.SafariDriver

class UnitTest {

    @Test
    fun test01(){
        // chromeでテストを実行
        loginTest(chromeDriver())
    }

    @Test
    fun test02(){
        // Firefoxでテストを実行
        loginTest(firefoxDriver())
    }

    @Test
    fun test03(){
        // Safariでテストを実行
        loginTest(safariDriver())
    }

    @Test
    private fun loginTest(driver: WebDriver) {
        System.setProperty("webdriver.chrome.driver", "./exe/chromedriver")
        val driver = ChromeDriver()

        driver.get("https://localhost/top/")
        sleep()

        driver.findElement(By.linkText("ログイン")).click()
        sleep()

        Assertions.assertEquals("https://localhost/login/", driver.currentUrl)

        val loginId = "{ログインID}"
        val loginPass = "{ログインパスワード}"

        driver.findElement(By.id("login_id")).sendKeys(loginId)

        driver.findElement(By.id("login_pass")).sendKeys(loginPass)

        driver.findElement(By.id("submitLoginButton")).click()
        sleep()

        Assertions.assertEquals("https://localhost/top/", driver.currentUrl)

        driver.findElement(By.linkText("ログアウト")).click()
        sleep()

        Assertions.assertEquals("https://localhost/logout/", driver.currentUrl)

        driver.quit()
    }

    fun chromeDriver(): WebDriver {
        // Chromeを起動
        System.setProperty("webdriver.chrome.driver", "./exe/chromedriver")
        return ChromeDriver()
    }

    fun firefoxDriver(): WebDriver {
        // firefoxを起動
        System.setProperty("webdriver.gecko.driver", "./exe/geckodriver")
        return FirefoxDriver()
    }

    fun safariDriver(): WebDriver {
        // Safariを起動（SafariはDriverの配置は不要です）
        return SafariDriver()
    }

    private fun sleep() {
        // ミリ秒単位で待機時間を指定
        Thread.sleep(2000)
    }
}
