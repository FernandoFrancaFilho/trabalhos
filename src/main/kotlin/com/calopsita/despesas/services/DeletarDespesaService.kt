package com.calopsita.despesas.services

import com.calopsita.despesas.repositories.DespesasResitory
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

interface DeletarDespesaService {
    fun deletar(id: Int)
}

@Service
class DeletarDespesaServiceImpl(private val repository: DespesasResitory) : DeletarDespesaService {
    override fun deletar(id: Int) {
        repository.deleteById(id)
    }
}