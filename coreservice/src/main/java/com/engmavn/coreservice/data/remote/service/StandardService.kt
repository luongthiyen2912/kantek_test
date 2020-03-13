package com.demo.coreservice.data.remote.service

import com.demo.coreservice.models.User.UserRespond
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface StandardService {
    @FormUrlEncoded
    @POST("api/v1/user/login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<UserRespond>

}