package com.inforad.asistenciaapp.data.mapper

import androidx.room.ColumnInfo
import com.inforad.asistenciaapp.data.dataSource.local.entity.ReunionEntity
import com.inforad.asistenciaapp.data.dataSource.local.entity.UserEntity
import com.inforad.asistenciaapp.domain.model.Reunion
import com.inforad.asistenciaapp.domain.model.User

fun ReunionEntity.toReunion(): Reunion {
    return Reunion(
        id = id,
        asunto = asunto,
        detalle = detalle,
        fecha = fecha,
        estado = estado
    )
}

fun Reunion.toReunionEntity(): ReunionEntity {
    return ReunionEntity(
        id = id ?: "",
        asunto = asunto,
        detalle = detalle ?: "",
        fecha = fecha,
        estado = estado,
    )
}