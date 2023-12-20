package com.inforad.asistenciaapp.data.mapper

import androidx.room.ColumnInfo
import com.inforad.asistenciaapp.data.dataSource.local.entity.UserEntity
import com.inforad.asistenciaapp.domain.model.User

fun UserEntity.toUser(): User {
    return User(
        id = id,
        name = name,
        lastname = lastname,
        dni = dni,
        email = email,
        phone = phone,
        password = password,
        numeroPadron = numero_padron,
        manzana = manzana,
        lote = lote,
        metros = metros,
        lotesDetalle = lotes_detalle,
        lotesCantidad = lotes_cantidad,
        imagen = image,
    )
}

fun User.toUserEntity(): UserEntity {
    return UserEntity(
        id = id ?: "",
        name = name,
        lastname = lastname,
        dni = dni ?: "",
        email = email ?: "",
        phone = phone,
        password = password ?: "",
        numero_padron = numeroPadron,
        manzana = manzana,
        lote = lote,
        metros = metros,
        lotes_detalle = lotesDetalle,
        lotes_cantidad = lotesCantidad,
        image = imagen ?: "",
    )
}