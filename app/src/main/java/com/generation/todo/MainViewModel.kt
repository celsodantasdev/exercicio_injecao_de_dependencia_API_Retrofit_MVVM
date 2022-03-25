package com.generation.todo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.generation.todo.model.Categoria
import com.generation.todo.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel //Indica que a nossa ViewModel vai injetar dependências
class MainViewModel @Inject constructor(
   var repository: Repository): ViewModel() {

   //essa é a var que o usuário não consegue modificar
   private var _responseListCategoria = MutableLiveData<Response<List<Categoria>>>()

   var responseCategoria : LiveData<Response<List<Categoria>>> = _responseListCategoria

   val dataSelecionada = MutableLiveData<LocalDate>()

   init {
       dataSelecionada.value = LocalDate.now()
      listCategoria()
   }

    init{
      listCategoria()
   }
   fun listCategoria(){
      viewModelScope.launch {
         try {
             val response = repository.listCategorias()
            _responseListCategoria.value = response
         }catch (e:Exception){
            Log.d("Error ",e.message.toString())
         }
      }

   }

}