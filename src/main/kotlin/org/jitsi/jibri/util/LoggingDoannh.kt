package org.jitsi.jibri.util

import java.util.*

/**
 *created by: Nguyen Huy Doan
 *at: 12/11/2021 1:52 PM
 */
class LoggingDoannh {
    companion object {
        private val pattern = "[${Date()}] DOANNH LOG-------: "
        public fun log(message: String) {
            println(pattern + message)
        }
    }
}