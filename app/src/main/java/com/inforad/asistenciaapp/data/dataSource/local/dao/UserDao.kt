package com.inforad.asistenciaapp.data.dataSource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.inforad.asistenciaapp.data.dataSource.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<UserEntity>)

    @Query("SELECT * FROM users")
    fun getUsers(): Flow<List<UserEntity>>

    @Query("UPDATE users SET name = :name, lastname = :lastname, dni = :dni, email = :email, phone = :phone, numero_padron = :numero_padron, manzana = :manzana, metros = :metros, lotes_detalle = :lotes_detalle, image = :image WHERE id = :id" )
    suspend fun update(
        id: String,
        name: String,
        lastname: String,
        dni: String,
        email: String,
        phone: String,
        numero_padron: String,
        manzana: String,
        metros: String,
        lotes_detalle: String,
        image: String
    )

    @Query("DELETE FROM users WHERE id = :id")
    suspend fun delete(id: String)

}