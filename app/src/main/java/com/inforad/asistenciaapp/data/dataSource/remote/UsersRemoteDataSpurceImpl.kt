package com.inforad.asistenciaapp.data.dataSource.remote

import com.inforad.asistenciaapp.data.dataSource.remote.UsersRemoteDataSource
import com.inforad.asistenciaapp.data.dataSource.remote.service.UsersService
import com.inforad.asistenciaapp.domain.model.User
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Response
import java.io.File

class UsersRemoteDataSpurceImpl(private val usersService: UsersService): UsersRemoteDataSource {
    override suspend fun update(id: String, user: User): Response<User> = usersService.update(id, user)

    override suspend fun updateWithImage(id: String, user: User, file: File): Response<User> {
        val connection = file.toURI().toURL().openConnection()
        val mimeType = connection.contentType
        val contentType = "text/plain"
        val requestFile = file.asRequestBody(mimeType.toMediaTypeOrNull())
        val fileFormData = MultipartBody.Part.createFormData("file", file.name, requestFile)
        val nameData = user.name.toRequestBody(contentType.toMediaTypeOrNull())
        val lastnameData = user.lastname.toRequestBody(contentType.toMediaTypeOrNull())
        val dniData = user.dni?.toRequestBody(contentType.toMediaTypeOrNull())
        val emailData = user.email?.toRequestBody(contentType.toMediaTypeOrNull())
        val phoneData = user.phone.toRequestBody(contentType.toMediaTypeOrNull())
        val numero_padronData = user.numeroPadron.toString().toRequestBody(contentType.toMediaTypeOrNull())
        val manzanaData = user.manzana.toRequestBody(contentType.toMediaTypeOrNull())
        val loteData = user.lote.toString().toRequestBody(contentType.toMediaTypeOrNull())
        val metrosData = user.metros.toRequestBody(contentType.toMediaTypeOrNull())
        val lotes_detalleData = user.lotesDetalle.toRequestBody(contentType.toMediaTypeOrNull())
        val lotes_cantidadData = user.lotesCantidad.toRequestBody(contentType.toMediaTypeOrNull())
        return usersService.updateWithImage(fileFormData, id, nameData, lastnameData, dniData!!, emailData!!, phoneData, numero_padronData, manzanaData, loteData, metrosData, lotes_detalleData, lotes_cantidadData)
    }

    override suspend fun createWithImage(user: User, file: File): Response<User> {
        val connection = file.toURI().toURL().openConnection()
        val mimeType = connection.contentType
        val contentType = "text/plain"
        val requestFile = file.asRequestBody(mimeType.toMediaTypeOrNull())
        val fileFormData = MultipartBody.Part.createFormData("file", file.name, requestFile)
        val nameData = user.name.toRequestBody(contentType.toMediaTypeOrNull())
        val lastnameData = user.lastname.toRequestBody(contentType.toMediaTypeOrNull())
        val dniData = user.dni?.toRequestBody(contentType.toMediaTypeOrNull())
        val emailData = user.email?.toRequestBody(contentType.toMediaTypeOrNull())
        val phoneData = user.phone.toRequestBody(contentType.toMediaTypeOrNull())
        val numero_padronData = user.numeroPadron.toString().toRequestBody(contentType.toMediaTypeOrNull())
        val manzanaData = user.manzana.toRequestBody(contentType.toMediaTypeOrNull())
        val loteData = user.lote.toString().toRequestBody(contentType.toMediaTypeOrNull())
        val metrosData = user.metros.toRequestBody(contentType.toMediaTypeOrNull())
        val lotes_detalleData = user.lotesDetalle.toRequestBody(contentType.toMediaTypeOrNull())
        val lotes_cantidadData = user.lotesCantidad.toRequestBody(contentType.toMediaTypeOrNull())
        return usersService.createWithImage(fileFormData, nameData, lastnameData, dniData!!, dniData!!, emailData!!, phoneData, numero_padronData, manzanaData, loteData, metrosData, lotes_detalleData, lotes_cantidadData)
    }

    override suspend fun getUsers(): Response<List<User>> = usersService.getUsers()
    override suspend fun findByName(dato: String): Response<List<User>> = usersService.findByName(dato)
    override suspend fun delete(id: String): Response<Unit> = usersService.delete(id)
}