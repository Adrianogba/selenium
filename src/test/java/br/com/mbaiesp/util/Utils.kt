package br.com.mbaiesp.util

import java.lang.Exception
import org.openqa.selenium.WebDriver
import br.com.mbaiesp.driver.CoreDriver
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.OutputType
import org.apache.commons.io.FileUtils
import org.openqa.selenium.By
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

/**
 * Classe com metodos de apoio, que otimizam a codificacao das classes de pagina
 *
 * @author thiago.freire
 */
object Utils {
    fun extrairStackTrace(e: Exception): String {
        val stack = e.stackTrace
        var exception = ""
        for (s in stack) {
            exception = """$exception$s
		"""
        }
        return exception
    }

    /**
     * Metodo para capturar screenshot
     * @param driver
     *
     * @param fileName
     * - Nome do arquivo
     */
    fun takeScreenshot(driver: WebDriver?, casoDeteste: String, nomeEvidencia: String) {
        CoreDriver
        val scrFile = (CoreDriver.getWebDriver() as TakesScreenshot)
                .getScreenshotAs(OutputType.FILE)
        try {
            val pastaImages = "Evidencias/$casoDeteste/$nomeEvidencia.jpg"
            val pastaResultado = "resultadoTest/$pastaImages"
            val fileDestino = File(pastaResultado)
            FileUtils.copyFile(scrFile, fileDestino, true)
        } catch (e: Exception) {
            System.err.println(e.message)
        }
    }

    val data: Date
        get() {
            val cal = Calendar.getInstance()
            return cal.time
        }
    val dataAtual: String?
        get() = try {
            val formatDate = SimpleDateFormat("ddMMyyyy")
            val calendar: Calendar = GregorianCalendar()
            val data = Date()
            calendar.time = data
            formatDate.format(data)
        } catch (e: Exception) {
            null
        }

    fun WebDriver.goTo(url: String) {
        this.navigate().to(url)
    }

    fun WebDriver.webSearch(searchFieldName: By, keys: String) {
        this.findElement(searchFieldName).sendKeys(keys)
        this.findElement(searchFieldName).submit()
    }
}