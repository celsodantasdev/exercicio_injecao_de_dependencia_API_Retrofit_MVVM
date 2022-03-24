package com.generation.todo.repository

import com.generation.todo.API.RetrofitInstance
import com.generation.todo.model.Categoria
import retrofit2.Response


//a função do repositório faz a ligação entre o banco de dados e o app
//acessando o banco de dados pelo retrofit e retornando o método GET

class Repository {

    suspend fun listCategorias():Response<List<Categoria>>{
        return RetrofitInstance.api.listCategoria()
    }


}