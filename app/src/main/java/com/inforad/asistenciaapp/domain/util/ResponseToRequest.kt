package com.inforad.asistenciaapp.domain.util

import com.inforad.asistenciaapp.domain.model.ErrorResponse
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

object ResponseToRequest {
    fun <T> send(result: Response<T>): Resource<T> {
        return try {
            if (result.isSuccessful) {
                Resource.Success(result.body()!!)
            }else{
                val errorResponse: ErrorResponse? = ConvertErrorBody.convert(result.errorBody())
                Resource.Failure(errorResponse?.message ?: "Error desconocido Cod. ARI01")
            }

        } catch (e: HttpException) {
            e.printStackTrace()
            Resource.Failure(e.message ?: "Hubo un error desconocido en la peticion HTTP")
        } catch (e: IOException) {
            e.printStackTrace()
            Resource.Failure("Verifica tu conexion a internet")
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Failure(e.message ?: "Hubo un error desconocido Cod. ARI02")
        }
    }
}