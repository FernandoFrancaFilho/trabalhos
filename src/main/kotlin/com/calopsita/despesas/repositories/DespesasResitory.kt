package com.calopsita.despesas.repositories

import com.calopsita.despesas.models.DespesaModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DespesasResitory : JpaRepository<DespesaModel, Int> {
}