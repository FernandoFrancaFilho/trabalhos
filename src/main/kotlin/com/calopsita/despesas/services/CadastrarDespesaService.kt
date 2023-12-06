package com.calopsita.despesas.services

import com.calopsita.despesas.dtos.CadastrarDespesaDto
import com.calopsita.despesas.dtos.DespesaDtoResponse
import com.calopsita.despesas.models.DespesaModel
import com.calopsita.despesas.repositories.DespesasResitory
import org.springframework.stereotype.Service
import java.time.LocalDateTime

interface CadastrarDespesaService {
    fun cadastrar(cadastrarDespesaDto: CadastrarDespesaDto): DespesaDtoResponse
}

@Service
class CadastrarDespesaServiceImpl(private val despesasResitory: DespesasResitory) : CadastrarDespesaService {
    override fun cadastrar(cadastrarDespesaDto: CadastrarDespesaDto): DespesaDtoResponse {
        val model = DespesaModel(descricao = cadastrarDespesaDto.descricao, categoria = cadastrarDespesaDto.categoria, valor = cadastrarDespesaDto.valor, criadoEm = LocalDateTime.now(), id = null)
        val save = despesasResitory.save(model)
        return DespesaDtoResponse(
                id = save.id!!,
                descricao = save.descricao,
                categoria = save.categoria,
                valor = save.valor,
                criadoEm = save.criadoEm
        )
    }

}