package com.inforad.asistenciaapp.data.dataSource.remote.service

import com.inforad.asistenciaapp.domain.model.AuthResponse
import com.inforad.asistenciaapp.domain.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthService {

    @FormUrlEncoded
    @POST("auth/login")
    suspend fun login(
        @Field("dni")
        dni: String,

        @Field("password")
        password: String,
    ): Response<AuthResponse>

    @POST("users")
    suspend fun register(
        @Body()
        user: User
    ): Response<AuthResponse>
}