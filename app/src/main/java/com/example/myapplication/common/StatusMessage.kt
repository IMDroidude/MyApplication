package com.example.myapplication.common

import com.example.myapplication.R

class StatusMessage(
    private val message: String? = null,
    private val messageId: Int = -1//R.string.connection_alert
) {

    fun parse(provider: (id: Int) -> String): String {
        return message ?: provider.invoke(messageId)
    }

    companion object {

        fun wrapException(e: Throwable?): StatusMessage {
            return StatusMessage(message = e?.message)
        }

        fun from(string: String): StatusMessage {
            return StatusMessage(message = string)
        }
    }
}