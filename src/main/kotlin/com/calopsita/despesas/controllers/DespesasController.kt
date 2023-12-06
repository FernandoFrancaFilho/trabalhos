package com.calopsita.despesas.controllers

import com.calopsita.despesas.dtos.CadastrarDespesaDto
import com.calopsita.despesas.services.CadastrarDespesaService
import com.calopsita.despesas.services.DeletarDespesaService
import com.calopsita.despesas.services.EditarDespesaService
import com.calopsita.despesas.services.PegarDespesaService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/despesas")
class DespesasController(private val cadastrarDespesaService: CadastrarDespesaService,
                         private val deletarDespesaService: DeletarDespesaService,
                         private val editarDespesaService: EditarDespesaService,
                         private val pegarDespesaService: PegarDespesaService) {

    @GetMapping
    fun pegarDespesa(): ResponseEntity<Any> {
        val despesas = pegarDespesaService.call()
        return ResponseEntity(despesas, HttpStatus.OK)
    }

    @PostMapping
    fun cadastrarDespesa(@Valid @RequestBody cadastrarDespesaDto: CadastrarDespesaDto): ResponseEntity<Any> {
        val id = cadastrarDespesaService.cadastrar(cadastrarDespesaDto)
        return ResponseEntity(id, HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun atualizarDepesa(@PathVariable id: Int,
                        @Valid @RequestBody cadastrarDespesaDto: CadastrarDespesaDto): ResponseEntity<Any> {
        val update = editarDespesaService.editar(id, cadastrarDespesaDto)
        return ResponseEntity(update, HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun deletarDepesa(@PathVariable id: Int): ResponseEntity<Any> {
        deletarDespesaService.deletar(id)
        return ResponseEntity(null, HttpStatus.NO_CONTENT)
    }
}