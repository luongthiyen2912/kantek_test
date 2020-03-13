package com.task.data

import com.demo.coreservice.data.local.LocalRepository
import com.demo.coreservice.data.remote.network.Resource
import com.demo.coreservice.models.User
import com.task.data.remote.RemoteRepository
import javax.inject.Inject


/**
 * Created by AhmedEltaher on 5/12/2016
 */

class DataRepository @Inject
constructor(private val remoteRepository: RemoteRepository, private val localRepository: LocalRepository) : DataSource {

    override suspend fun login(email: String, password : String): Resource<User.UserRespond> {
        return remoteRepository.login(email,password)
    }

}
