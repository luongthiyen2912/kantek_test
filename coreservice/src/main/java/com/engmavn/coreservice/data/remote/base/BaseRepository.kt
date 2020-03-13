package com.demo.coreservice.data.remote.base

import android.accounts.NetworkErrorException
import androidx.annotation.NonNull
import com.demo.coreservice.data.local.AppDataManager
import com.demo.coreservice.data.remote.network.ServiceError
import com.demo.coreservice.data.remote.network.ServiceResponse
import com.demo.coreservice.utils.Network
import com.task.data.remote.ServiceGenerator
import retrofit2.Response
import java.io.IOException

abstract class BaseRepository {
    val UNDELIVERABLE_EXCEPTION_TAG = "UNDELIVERABLE_EXCEPTION"
    val JSON_ENCODING = "application/json; charset=utf-8"

    protected var serviceGenerator: ServiceGenerator

    constructor(serviceGenerator: ServiceGenerator) {
        this.serviceGenerator = serviceGenerator
    }

    @NonNull
    protected suspend fun processCall(responseCall: suspend () -> Response<*>): Any? {
        if (!Network.isConnected(AppDataManager.getInstance().getContext())) {
            return NetworkErrorException()
        }
        return try {
            val response = responseCall.invoke()
            val responseCode = response.code()
            if (response.isSuccessful) {
                ServiceResponse(responseCode,response.body())
            } else {
                ServiceResponse(responseCode,response.errorBody())
            }
        } catch (e: IOException) {
            return e
        }
    }
//    @Throws(Exception::class)
//    protected open fun <T> mappingRespond(
//        cls: Class<out ERespond?>?,
//        serviceResponse: ServiceResponse
//    ): T? {
//        return if (serviceResponse.code < ServiceError.SERVER_ERROR_CODE && serviceResponse.code > 0) {
//            if (serviceResponse.code == ServiceError.SUCCESS_CODE) {
//                serviceResponse.data as T?
//            } else {
//                val responseBodyStr =
//                    (serviceResponse.data as ResponseBody?)!!.string()
//                EObject.fromJson(responseBodyStr, cls) as T?
//            }
//        } else {
//            throw NetworkErrorException(Constants.SERVER_ERROR_CODE)
//        }
//    }
}