package com.calopsita.despesas.dtos

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Null
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor

@NoArgsConstructor
@AllArgsConstructor
data class CadastrarDespesaDto(
        @field:NotBlank(message = "Campo Categoria é de preenchimento obrigatório")
        @JsonProperty("descricao")
        val descricao: String,
        @field:NotBlank(message = "Campo Descrição é de preenchimento obrigatório")
        @JsonProperty("categoria")
        val categoria: String,
        @field:NotBlank(message = "Campo Valor é de preenchimento obrigatório")
        @JsonProperty("valor")
        val valor: Double,
)
