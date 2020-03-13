package com.task.data.remote

import com.demo.coreservice.data.remote.network.Resource
import com.demo.coreservice.models.User

/**
 * Created by ahmedEltaher on 3/23/17.
 */

internal interface RemoteSource {
    suspend fun login(email: String, password : String): Resource<User.UserRespond>
}
