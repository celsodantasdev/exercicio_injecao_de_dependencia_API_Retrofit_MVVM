package com.generation.todo.API

import com.generation.todo.model.Categoria
import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    //buscando categoria dentro da API
    @GET("categoria")
    //o Response é um objeto responsável por guardar a resposta da API
    //List está referenciando a classe Categoria
    suspend fun listCategoria(): Response<List<Categoria>>


}