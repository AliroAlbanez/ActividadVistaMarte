package com.example.actividad7m6.vistas.viewsModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.actividad7m6.modelos.Repositorio
import com.example.actividad7m6.modelos.local.MarsDB
import com.example.actividad7m6.modelos.local.MarsEntity
import kotlinx.coroutines.launch

class ViewModelMars (application: Application): AndroidViewModel(application){

    private val repository : Repositorio



    init{
        val bd= MarsDB.getDataBase(application)
        val  marsDao = bd.getMarsDao()

        repository = Repositorio(marsDao)

        viewModelScope.launch {

            repository.fechMars()
        }
    }

    fun getMarsList(): LiveData<List<MarsEntity>> = repository.marsListLiveData

}