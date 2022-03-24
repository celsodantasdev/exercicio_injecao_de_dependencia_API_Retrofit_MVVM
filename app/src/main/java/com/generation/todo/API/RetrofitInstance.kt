package com.generation.todo.API

import com.generation.todo.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    //by lazy inicializa os dados imediatamente junto com a inicialização do objeto
    //tornando os valores disponíveis de imediato futuramente

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    val api: APIService by lazy {
        retrofit.create(APIService::class.java)
    }
}