package com.inforad.asistenciaapp.data.dataSource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(

    @PrimaryKey
    var id: String = "",

    @ColumnInfo(name = "name")
    var name: String = "",

    @ColumnInfo(name = "lastname")
    var lastname: String = "",

    @ColumnInfo(name = "dni")
    var dni: String = "",

    @ColumnInfo(name = "email")
    var email: String = "",

    @ColumnInfo(name = "phone")
    var phone: String = "",

    @ColumnInfo(name = "password")
    var password: String = "",

    @ColumnInfo(name = "numero_padron")
    var numero_padron: Int = 0,

    @ColumnInfo(name = "manzana")
    var manzana: String = "",

    @ColumnInfo(name = "lote")
    var lote: Int = 0,

    @ColumnInfo(name = "metros")
    var metros: String = "",

    @ColumnInfo(name = "lotes_detalle")
    var lotes_detalle: String = "",

    @ColumnInfo(name = "lotes_cantidad")
    var lotes_cantidad: String = "",

    @ColumnInfo(name = "image")
    var image: String = "",
)
