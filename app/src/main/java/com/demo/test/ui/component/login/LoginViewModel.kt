package com.demo.test.ui.component.login

import androidx.lifecycle.MutableLiveData
import com.demo.coreservice.data.remote.network.Resource
import com.demo.coreservice.models.User
import com.demo.test.ui.base.BaseViewModel
import com.demo.test.usecase.UserUseCase
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val userUseCase: UserUseCase) : BaseViewModel() {
    val loginLiveData: MutableLiveData<Resource<User.UserRespond>> =
        userUseCase.loginLiveData

    fun login(email:String, password:String) {
        userUseCase.login(email,password)
    }
}