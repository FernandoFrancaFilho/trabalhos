package com.calopsita.despesas.exception

import jakarta.validation.ConstraintViolationException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import java.time.LocalDateTime

@ControllerAdvice
class ErrorHandlingControllerAdvice {

    /**
     * Define o formato padrão de definição do Erro que será
     * retornado pela API nesta Aplicação Web
     * @param message - Mensagem de erro
     * @return CustomErrorType - Tipo de erro personalizado
     */
    private fun defaultCustomErrorTypeConstruct(message: String): CustomErrorType {
        return CustomErrorType(
                timestamp = LocalDateTime.now(),
                message = message,
                errors = ArrayList(),
        )
    }

    @ExceptionHandler(CalculatorException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun onCommerceException(calculatorException: CalculatorException): CustomErrorType {
        return defaultCustomErrorTypeConstruct(
                calculatorException.message.orEmpty()
        )
    }

    /*
    Daqui, abaixo, seguem os tratamentos dos erros oriundos das
    validações nos controladores: @Valid (jakarta.validation)
     */
    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun onMethodArgumentNotValidException(e: MethodArgumentNotValidException): CustomErrorType {
        val customErrorType = defaultCustomErrorTypeConstruct(
                "Erros de validacao encontrados"
        )
        for (fieldError in e.bindingResult.fieldErrors) {
            customErrorType.errors.add(fieldError.defaultMessage.orEmpty())
        }
        return customErrorType
    }

    @ExceptionHandler(ConstraintViolationException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun onConstraintViolation(e: ConstraintViolationException): CustomErrorType {
        val customErrorType = defaultCustomErrorTypeConstruct(
                "Erros de validacao encontrados"
        )
        for (violation in e.constraintViolations) {
            customErrorType.errors.add(violation.message)
        }
        return customErrorType
    }
}