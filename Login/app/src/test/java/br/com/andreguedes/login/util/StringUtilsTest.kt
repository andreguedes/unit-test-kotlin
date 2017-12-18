package br.com.andreguedes.login.util

import org.junit.Assert.*
import org.junit.Test

/**
 * Created by Andre on 14/12/17.
 */
class StringUtilsTest {

    @Test
    fun shouldReturnTrueIfEmailIsValid() {
        val email = StringUtils.isEmailValid("andre@gmail.com")

        assertTrue(email)
    }

    @Test
    fun shouldReturnTrueIfEmailIsInvalid() {
        val email = StringUtils.isEmailValid("andre@.com")

        assertFalse(email)
    }

    @Test
    fun shouldReturnPhoneWithMask() {
        val phone = StringUtils.applyMask("14997428612", "(##)#####-####")

        assertEquals("(14)99742-8612", phone)
    }

    @Test
    fun shouldReturnPhoneWithoutMask() {
        val phone = StringUtils.unmask("(14)99742-8612")

        assertEquals("14997428612", phone)
    }



}