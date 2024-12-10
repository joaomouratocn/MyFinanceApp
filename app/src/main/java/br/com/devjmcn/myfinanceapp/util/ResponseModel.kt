package br.com.devjmcn.myfinanceapp.util

sealed class ResponseModel<out T> {
    data class Success<out T>(val data:T) : ResponseModel<T>()
    data class Error(val message:String) : ResponseModel<Nothing>()
}