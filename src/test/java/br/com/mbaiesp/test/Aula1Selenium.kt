package br.com.mbaiesp.test

import org.openqa.selenium.WebDriver
import br.com.mbaiesp.driver.CoreDriver
import br.com.mbaiesp.util.Utils.goTo
import br.com.mbaiesp.util.Utils.webSearch
import org.junit.jupiter.api.*
import org.openqa.selenium.By
import org.openqa.selenium.support.PageFactory

class Aula1Selenium {
    var driver: WebDriver? = null
    @BeforeEach
    fun before() {
        driver = CoreDriver.getWebDriver()
    }

    @AfterEach
    fun after() {
        driver = null
        CoreDriver.resetDriver()
    }

    @Test
    fun teste01() {
        PageFactory.initElements(driver, this)
        val driver = driver ?: throw NullPointerException()

        driver.goTo("https://www.google.com/?hl=pt-BR")
        driver.webSearch(By.name("q"), "recursividade")
        assert(driver.pageSource.contains("Você quis dizer:"))
        assert(driver.findElement(By.tagName("i")).text == "recursividade")

    }
}