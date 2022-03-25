package com.generation.todo.model


//A classe categoria se extende para a classe Tarefa. Ambas as classes são conectadas.
data class Categoria(var id: Long, var descricao: String?, var tarefa: List<Tarefa>) {

    override fun toString():String{
        return descricao!!
    }

}