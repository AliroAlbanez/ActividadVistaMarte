package com.example.actividad7m6.modelos

import android.util.Log

import com.example.actividad7m6.modelos.local.MarsDAO
import com.example.actividad7m6.modelos.remoto.RetrofitClient

class Repositorio (private val marsDao:MarsDAO){
    private val networkService = RetrofitClient.retrofitInstance()
    val marsListLiveData = marsDao.getAllDatos()



    suspend fun  fechMars(){

        val service = kotlin.runCatching { networkService.fecthMarsList()}

        service.onSuccess {
            when(it.code()){
                in 200..299-> it.body()?.let {
                    marsDao.insertAll(fromInternetToMarsEntity(it))
                }
                else -> Log.d("Repo", "${it.code()}-${it.errorBody()}")
            }
            service.onFailure {
                Log.e("Error","${it.message}")
            }
        }
    }

}
