package com.demo.test.usecase

import androidx.lifecycle.MutableLiveData
import com.demo.coreservice.data.remote.network.Resource
import com.demo.coreservice.models.User

/**
 * Created by ahmedeltaher on 3/22/17.
 */

interface UserUseCaseImpl {
    fun login(email:String, password:String)

    val loginLiveData: MutableLiveData<Resource<User.UserRespond>>

}
