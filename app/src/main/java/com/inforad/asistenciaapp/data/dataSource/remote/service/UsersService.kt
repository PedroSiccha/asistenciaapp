package com.inforad.asistenciaapp.data.dataSource.remote.service

import com.inforad.asistenciaapp.domain.model.AuthResponse
import com.inforad.asistenciaapp.domain.model.Reunion
import com.inforad.asistenciaapp.domain.model.User
import okhttp3.MultipartBody
import okhttp3.Request
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path

interface UsersService {

    @GET("users")
    suspend fun getUsers(): Response<List<User>>

    @PUT("users/{id}")
    suspend fun update(
        @Path("id") id: String,
        @Body() user: User,
    ): Response<User>

    @Multipart
    @PUT("users/updateWithImage/{id}")
    suspend fun updateWithImage(
        @Part file: MultipartBody.Part,
        @Path("id") id: String,
        @Part("name") name: RequestBody,
        @Part("lastname") lastname: RequestBody,
        @Part("dni") dni: RequestBody,
        @Part("email") email: RequestBody,
        @Part("phone") phone: RequestBody,
        @Part("numero_padron") numero_padron: RequestBody,
        @Part("manzana") manzana: RequestBody,
        @Part("lote") lote: RequestBody,
        @Part("metros") metros: RequestBody,
        @Part("lotes_detalle") lotes_detalle: RequestBody,
        @Part("lotes_cantidad") lotes_cantidad: RequestBody
    ): Response<User>

    @Multipart
    @POST("users/createWithImage")
    suspend fun createWithImage(
        @Part file: MultipartBody.Part,
        @Part("name") name: RequestBody,
        @Part("lastname") lastname: RequestBody,
        @Part("dni") dni: RequestBody,
        @Part("password") password: RequestBody,
        @Part("email") email: RequestBody,
        @Part("phone") phone: RequestBody,
        @Part("numero_padron") numero_padron: RequestBody,
        @Part("manzana") manzana: RequestBody,
        @Part("lote") lote: RequestBody,
        @Part("metros") metros: RequestBody,
        @Part("lotes_detalle") lotes_detalle: RequestBody,
        @Part("lotes_cantidad") lotes_cantidad: RequestBody
    ): Response<User>

    @GET("users/search/{dato}")
    suspend fun findByName(
        @Path("dato") dato: String
    ): Response<List<User>>

    @DELETE("users/{id}")
    suspend fun delete(
        @Path("id") id: String,
    ): Response<Unit>

}