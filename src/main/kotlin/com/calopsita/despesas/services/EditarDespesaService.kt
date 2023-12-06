package com.calopsita.despesas.services

import com.calopsita.despesas.dtos.CadastrarDespesaDto
import com.calopsita.despesas.dtos.DespesaDtoResponse
import com.calopsita.despesas.models.DespesaModel
import com.calopsita.despesas.repositories.DespesasResitory
import org.springframework.stereotype.Service

interface EditarDespesaService {
    fun editar(id: Int, cadastrarDespesaDto: CadastrarDespesaDto): DespesaDtoResponse;
}

@Service
class EditarDespesaServiceImpl(private val despesasResitory: DespesasResitory) : EditarDespesaService {
    override fun editar(id: Int, cadastrarDespesaDto: CadastrarDespesaDto): DespesaDtoResponse {
        return despesasResitory.findById(id).map {
            val save = despesasResitory.save(DespesaModel(id = it.id, descricao = cadastrarDespesaDto.descricao, categoria = cadastrarDespesaDto.categoria, valor = cadastrarDespesaDto.valor, criadoEm = it.criadoEm))
            DespesaDtoResponse(id = save.id!!, descricao = save.descricao, categoria = save.categoria, valor = save.valor, criadoEm = save.criadoEm)
        }.orElseGet(null)
    }
}