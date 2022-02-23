package br.com.mbaiesp.test

import org.junit.jupiter.api.*

class Aula1 {
    @Test
    fun testeUm() {
        println("\t\tTeste um")
    }

    @Test
    fun testeDois() {
        println("\t\tTeste dois")
    }

    @BeforeEach
    fun antesDeCadaTeste() {
        println("\tAntes do teste")
    }

    @AfterEach
    fun depoisDeCadaTeste() {
        println("\tdepois do teste")
    }

    companion object {
        @BeforeAll
        fun antesDeCadaClass() {
            println("Antes da classe")
        }

        @AfterAll
        fun depoisDeCadaClass() {
            println("depois da classe")
        }
    }
}