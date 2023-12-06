package com.calopsita.despesas.models

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "Depesas")
data class DespesaModel(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int?,
        var descricao: String,
        var categoria: String,
        var valor: Double,
        var criadoEm: LocalDateTime,
)
