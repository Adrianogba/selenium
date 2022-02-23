package br.com.mbaiesp.driver

import br.com.mbaiesp.util.ConversorTipos.check
import org.openqa.selenium.WebDriver
import java.util.Locale
import br.com.mbaiesp.config.Browser
import br.com.mbaiesp.config.Property
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.chrome.ChromeDriver
import java.lang.Exception
import java.io.File
import kotlin.Throws

/**
 * Selenium WebDriver
 *
 * @author thiago.freire
 */
object CoreDriver {
    var driver: WebDriver? = null
    var OS = System.getProperty("os.name").lowercase(Locale.getDefault())
    var OS_ARCH = System.getProperty("sun.arch.data.model").lowercase(Locale.getDefault())
    fun getWebDriver(): WebDriver? {
        if (driver == null) {
            try {
                if (Browser.CHROME == Property.BROWSER_NAME) {
                    val chromeOptions = ChromeOptions()
                    //					chromeOptions.addArguments("--start-maximized");// Maximiza o navegador
//					chromeOptions.addArguments("headless");
                    System.setProperty("webdriver.chrome.driver", fileDriverPathChrome.absolutePath)
                    driver = ChromeDriver(chromeOptions)
                }
            } catch (e: Exception) {
                println(e.message)
            }
        }
        return driver
    }

    /**
     *
     * @return sistema Operacional Windows
     */
    val isWindows: Boolean
        get() = OS.indexOf("win") >= 0

    /**
     * @return sistema Operacional Linux
     */
    val isUnix: Boolean
        get() = OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS
                .indexOf("aix") > 0
    val isOS64bits: Boolean
        get() = if (check(OS_ARCH)) {
            Integer.valueOf(OS_ARCH) == 64
        } else false

    @get:Throws(Exception::class)
    private val fileDriverPathChrome: File
        private get() {
            var file: File? = null
            file = if (isWindows) {
                File(Property.CHROME_DRIVE_PATH)
            } else if (isUnix) {
                File(Property.CHROME_DRIVE_LINUX_PATH)
            } else throw Exception("Sistema operacional nao compativel")
            return file
        }

    fun resetDriver() {
        if (driver != null) {
            driver!!.close()
            driver = null
        }
    }
}