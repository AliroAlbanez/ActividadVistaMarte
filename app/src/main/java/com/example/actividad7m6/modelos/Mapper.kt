package com.example.actividad7m6.modelos

import com.example.actividad7m6.modelos.local.MarsEntity
import com.example.actividad7m6.modelos.remoto.MarsClass

fun fromInternetToMarsEntity(marsList: List<MarsClass>): List<MarsEntity>{

    return marsList.map {

        MarsEntity(
            id= it.id,
            price = it.price,
            type = it.type,
            imgSrc = it.imgSrc
        )
    }

}