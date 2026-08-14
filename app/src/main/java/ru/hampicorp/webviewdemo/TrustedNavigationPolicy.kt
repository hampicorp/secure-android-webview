package ru.hampicorp.webviewdemo

import java.net.URI

class TrustedNavigationPolicy(private val trustedHost: String) {
    fun isInternal(url: String): Boolean {
        val uri = runCatching { URI(url) }.getOrNull() ?: return false
        val schemeAllowed = uri.scheme.equals("https", ignoreCase = true)
        val host = uri.host?.lowercase() ?: return false
        val normalizedTrustedHost = trustedHost.lowercase()
        return schemeAllowed && (host == normalizedTrustedHost || host.endsWith(".$normalizedTrustedHost"))
    }
}
