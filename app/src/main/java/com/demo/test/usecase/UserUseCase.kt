package com.demo.test.usecase

import androidx.lifecycle.MutableLiveData
import com.demo.coreservice.data.remote.network.Resource
import com.demo.coreservice.models.User
import com.task.data.DataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class UserUseCase @Inject
constructor(
    private val dataRepository: DataSource,
    override val coroutineContext: CoroutineContext
) : UserUseCaseImpl, CoroutineScope {
    private val loginMutableLiveData = MutableLiveData<Resource<User.UserRespond>>()
     override val loginLiveData: MutableLiveData<Resource<User.UserRespond>> = loginMutableLiveData


    override fun login(email:String, password:String) {
        var serviceResponse: Resource<User.UserRespond>?

        loginMutableLiveData.postValue(Resource.Loading())
        launch {
            try {
                serviceResponse = dataRepository.login(email,password)
                loginMutableLiveData.postValue(serviceResponse)
            } catch (e: Exception) {
                loginMutableLiveData.postValue(Resource.Error(e))
            }
        }
    }
}