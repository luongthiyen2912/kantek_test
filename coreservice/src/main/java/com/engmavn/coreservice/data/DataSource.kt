package com.task.data

import com.demo.coreservice.data.remote.network.Resource
import com.demo.coreservice.models.User

/**
 * Created by ahmedeltaher on 3/23/17.
 */

interface DataSource {
    suspend fun login(email: String, password : String): Resource<User.UserRespond>
}
