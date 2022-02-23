package br.com.mbaiesp.config

import java.io.File
import java.lang.Exception
import java.util.*

/**
 * @author thiago.freire
 * Define o caminho do driver dos diferentes browsers
 * Acessa as configuracoes definidas no config.properties e retorna o valeu do Propertie
 */
object Property {
    var CHROME_DRIVE_PATH: String? = null
    var CHROME_DRIVE_LINUX_PATH: String? = null
    var FIREFOX_DRIVE_LINUX_PATH: String? = null
    var PHANTOM_DRIVE_PATH: String? = null
    var PHANTOM_DRIVE_LINUX_PATH: String? = null
    var PHANTOM_DRIVE_LINUX_PATH_64BITS: String? = null
    var BROWSER_NAME: String? = null
    var URL: String? = null
    private const val PROP_FILE_CONFIG = "config.properties"
    private const val SRC_SELENIUM = "/src/test/resources/"

    init {
        val properties = config
        CHROME_DRIVE_PATH = File("").absolutePath + SRC_SELENIUM + "driver/windows/chromedriver.exe"
        CHROME_DRIVE_LINUX_PATH = File("").absolutePath + SRC_SELENIUM + "driver/linux/chromedriver"
        BROWSER_NAME = properties.getProperty("browser.name")
        URL = properties.getProperty("url")
    }

    val config: Properties
        get() {
            val properties = Properties()
            val fileIn = ClassLoader.getSystemResourceAsStream(PROP_FILE_CONFIG)
            try {
                properties.load(fileIn)
            } catch (e: Exception) {
                println(e.message)
            }
            return properties
        }
}