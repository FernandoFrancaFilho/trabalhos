package com.calopsita.despesas

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class DespesasApplication

fun main(args: Array<String>) {
    SpringApplication.run(DespesasApplication::class.java, *args)
}
