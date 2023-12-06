package com.calopsita.despesas.exception

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class CustomErrorType(
        @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
        @JsonProperty("timestamp")
        var timestamp: LocalDateTime,
        @JsonProperty("message")
        var message: String,
        @JsonProperty("errors")
        var errors: MutableList<String>,
)
