package com.inforad.asistenciaapp.data.dataSource.local

import com.inforad.asistenciaapp.data.dataSource.local.dao.UserDao
import com.inforad.asistenciaapp.data.dataSource.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

class UserLocalDataSourceImpl(private val userDao: UserDao): UserLocalDataSource {
    override suspend fun create(user: UserEntity) = userDao.insert(user)
    override suspend fun createAll(users: List<UserEntity>) = userDao.insertAll(users)

    override fun getUsers(): Flow<List<UserEntity>> = userDao.getUsers()

    override suspend fun update(
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
    ) = userDao.update(id, name, lastname, dni, email, phone, numero_padron, manzana, metros, lotes_detalle, image)

    override suspend fun delete(id: String) = userDao.delete(id)

}