package com.calopsita.despesas.dtos

import java.time.LocalDateTime

data class DespesaDtoResponse(
        val id: Int,
        val descricao: String,
        val categoria: String,
        val valor: Double,
        val criadoEm: LocalDateTime,

        )
