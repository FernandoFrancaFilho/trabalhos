package com.calopsita.despesas.services

import com.calopsita.despesas.dtos.DespesaDtoResponse
import com.calopsita.despesas.repositories.DespesasResitory
import org.springframework.stereotype.Service

interface PegarDespesaService {
    fun call(): List<DespesaDtoResponse>
}

@Service
class PegarDespesaServiceImpl(private val despesasResitory: DespesasResitory) : PegarDespesaService {
    override fun call(): List<DespesaDtoResponse> {
        return despesasResitory.findAll().map {
            DespesaDtoResponse(id = it.id!!,
                    descricao = it.descricao,
                    categoria = it.categoria,
                    valor = it.valor,
                    criadoEm = it.criadoEm)
        }
    }
}
