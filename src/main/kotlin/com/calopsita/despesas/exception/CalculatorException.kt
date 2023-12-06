package com.calopsita.despesas.exception


class CalculatorException : RuntimeException {
    constructor() : super("Erro inesperado no AppCommerce!")
    constructor(message: String?) : super(message)
}

