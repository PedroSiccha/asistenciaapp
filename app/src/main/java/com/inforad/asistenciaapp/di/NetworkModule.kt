package com.inforad.asistenciaapp.di

import com.inforad.asistenciaapp.core.Config
import com.inforad.asistenciaapp.data.dataSource.local.datastore.AuthDatastore
import com.inforad.asistenciaapp.data.dataSource.remote.service.AsistenciaService
import com.inforad.asistenciaapp.data.dataSource.remote.service.AuthService
import com.inforad.asistenciaapp.data.dataSource.remote.service.ReporteService
import com.inforad.asistenciaapp.data.dataSource.remote.service.ReunionService
import com.inforad.asistenciaapp.data.dataSource.remote.service.UsersService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(datastore: AuthDatastore) = OkHttpClient.Builder().addInterceptor{
        val token = runBlocking {
            datastore.getData().first().token
        }
        val newRequest = it.request().newBuilder().addHeader("Authorization", token ?: "").build()
        it.proceed(newRequest)
    }.build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(Config.BASE_URL).client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    @Singleton
    fun  provideAuthService(retrofit: Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)
    }

    @Provides
    @Singleton
    fun  provideReporteService(retrofit: Retrofit): ReporteService {
        return retrofit.create(ReporteService::class.java)
    }

    @Provides
    @Singleton
    fun provideUsersService(retrofit: Retrofit): UsersService {
        return retrofit.create(UsersService::class.java)
    }

    @Provides
    @Singleton
    fun provideReunionesService(retrofit: Retrofit): ReunionService {
        return retrofit.create(ReunionService::class.java)
    }

    @Provides
    @Singleton
    fun provideAsistenciasService(retrofit: Retrofit): AsistenciaService {
        return retrofit.create(AsistenciaService::class.java)
    }

}