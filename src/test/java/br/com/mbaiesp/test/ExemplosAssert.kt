package br.com.mbaiesp.test

import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.hamcrest.core.CombinableMatcher
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.Arrays

class ExemplosAssert {
    @Test
    fun testAssertArrayEquals() {
        val expected = "trial".toByteArray()
        val actual = "trial".toByteArray()
        Assertions.assertArrayEquals(expected, actual, "failure - byte arrays not same")
    }

    @Test
    fun testAssertEquals() {
        Assertions.assertEquals("failure - strings are not equal", "text", "text")
    }

    @Test
    fun testAssertFalse() {
        Assertions.assertFalse(false, "failure - should be false")
    }

    @Test
    fun testAssertNotNull() {
        Assertions.assertNotNull(Any(), "should not be null")
    }

    @Test
    fun testAssertNotSame() {
        Assertions.assertNotSame(Any(), Any(), "should not be same Object")
    }

    @Test
    fun testAssertNull() {
        Assertions.assertNull(null, "should be null")
    }

    @Test
    fun testAssertSame() {
        val aNumber = Integer.valueOf(768)
        Assertions.assertSame(aNumber, aNumber, "should be same")
    }

    // JUnit Matchers assertThat
    @Test
    fun testAssertThatBothContainsString() {
        MatcherAssert.assertThat("albumen", CoreMatchers.both(CoreMatchers.containsString("a")).and(CoreMatchers.containsString("b")))
    }

    @Test
    fun testAssertThatHasItems() {
        MatcherAssert.assertThat(Arrays.asList("one", "two", "three"), CoreMatchers.hasItems("one", "three"))
    }

    @Test
    fun testAssertThatEveryItemContainsString() {
        MatcherAssert.assertThat(Arrays.asList(*arrayOf("fun", "ban", "net")), CoreMatchers.everyItem(CoreMatchers.containsString("n")))
    }

    // Core Hamcrest Matchers with assertThat
    @Test
    fun testAssertThatHamcrestCoreMatchers() {
        MatcherAssert.assertThat("good", CoreMatchers.allOf(CoreMatchers.equalTo("good"), CoreMatchers.startsWith("good")))
        MatcherAssert.assertThat("good", CoreMatchers.not(CoreMatchers.allOf(CoreMatchers.equalTo("bad"), CoreMatchers.equalTo("good"))))
        MatcherAssert.assertThat("good", CoreMatchers.anyOf(CoreMatchers.equalTo("bad"), CoreMatchers.equalTo("good")))
        MatcherAssert.assertThat(7, CoreMatchers.not(CombinableMatcher.either(CoreMatchers.equalTo(3)).or(CoreMatchers.equalTo(4))))
        MatcherAssert.assertThat(Any(), CoreMatchers.not(CoreMatchers.sameInstance(Any())))
    }

    @Test
    fun testAssertTrue() {
        Assertions.assertTrue(true,"failure - should be true")
    }
}