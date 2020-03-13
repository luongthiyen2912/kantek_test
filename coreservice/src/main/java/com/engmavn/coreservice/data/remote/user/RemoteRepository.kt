package com.task.data.remote

import com.demo.coreservice.Settings
import com.demo.coreservice.data.remote.base.BaseRepository
import com.demo.coreservice.data.remote.network.Resource
import com.demo.coreservice.data.remote.network.ServiceError.Companion.SUCCESS_CODE
import com.demo.coreservice.data.remote.network.ServiceResponse
import com.demo.coreservice.data.remote.service.StandardService
import com.demo.coreservice.models.User
import com.demo.coreservice.models.User.UserRespond
import okhttp3.ResponseBody
import javax.inject.Inject


class RemoteRepository : BaseRepository, RemoteSource {
    @Inject
    constructor(serviceGenerator: ServiceGenerator) : super(serviceGenerator)

    override suspend fun login(email: String, password : String ): Resource<User.UserRespond> {
        val standardService =
            serviceGenerator.createService(StandardService::class.java, Settings.URL_SERVER)

        return when (val response =
            processCall(responseCall = { standardService.login(email,password) })) {
            is ServiceResponse -> {
                if (response.code == SUCCESS_CODE){
                    Resource.Success(data = response.data as User.UserRespond)
                }else{
                    Resource.Error(t = response as Throwable)
                }
            }
            else -> {
                Resource.Error(t = response as Throwable)

            }
        }
    }

}
