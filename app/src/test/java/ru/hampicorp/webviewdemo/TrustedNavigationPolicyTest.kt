package ru.hampicorp.webviewdemo

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class TrustedNavigationPolicyTest {
    private val policy = TrustedNavigationPolicy("example.com")

    @Test
    fun acceptsTrustedHttpsHost() {
        assertTrue(policy.isInternal("https://example.com/catalog"))
        assertTrue(policy.isInternal("https://app.example.com/account"))
    }

    @Test
    fun rejectsLookalikeAndInsecureHosts() {
        assertFalse(policy.isInternal("http://example.com"))
        assertFalse(policy.isInternal("https://example.com.attacker.test"))
        assertFalse(policy.isInternal("javascript:alert(1)"))
    }
}
