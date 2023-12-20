package com.inforad.asistenciaapp.data.dataSource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reuniones")
data class ReunionEntity(

    @PrimaryKey
    var id: String = "",

    @ColumnInfo(name = "asunto")
    var asunto: String = "",

    @ColumnInfo(name = "detalle")
    var detalle: String = "",

    @ColumnInfo(name = "fecha")
    var fecha: String = "",

    @ColumnInfo(name = "estado")
    var estado: String = "",

)
